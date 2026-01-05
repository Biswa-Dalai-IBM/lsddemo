package com.webmethods.dsl.expressions.flow.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.VariableResolver;
import com.webmethods.g11n.text.DateUtils;
import com.wm.data.IData;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapSet;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.Namespace;
import com.wm.util.JavaWrapperType;
import com.wm.util.coder.IDataJSONCoder;
import com.wm.validator.DateValidator;
import com.wm.validator.ValidationResults;

/**
 * Represents a MAP SET operation (field = value)
 */
public class FlowMapSetExpression extends FlowMapExpression {
	
	private String fieldPath;
	private Object value;
	private VariableResolver variableResolver;

	public FlowMapSetExpression(String fieldPath, Object value) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
	}

	public FlowMapSetExpression(String fieldPath, Object value, VariableResolver variableResolver) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
		this.variableResolver = variableResolver;
	}

	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}

	public String getFieldPath() {
		return fieldPath;
	}

	public Object getValue() {
		return value;
	}

	
	
	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		FlowMapSet setData = createFlowMapSet(namespace);
		NSField nsField = NSFieldPathBuilder.buildNSField(namespace,fieldPath, variableResolver);
		setData.setInputType(nsField);
		
		Object inputValue = processValueByType(nsField);
		if (inputValue != null) {
			setData.setInput(inputValue);
		}
		
		return setData;
	}
	
	/**
	 * Create and configure a FlowMapSet instance
	 */
	private FlowMapSet createFlowMapSet(Namespace namespace) {
		FlowMapSet setData = new FlowMapSet(null);
		String nsFieldPath = NSFieldPathBuilder.buildNSFieldPath(namespace,fieldPath, variableResolver);
		if(nsFieldPath==null) {
			return null;
		}
		setData.setField(nsFieldPath);
		setData.setVariables(false);
		setData.setOverwrite(true);
		setData.setGlobalVariables(false);
		setData.setName("Setter");
		return setData;
	}
	
	/**
	 * Process value based on NSField type and dimension
	 */
	private Object processValueByType(NSField nsField) {
		int fieldType = nsField.getType();
		int dimension = nsField.getDimensions();
		
		// Handle Record/RecordRef types
		if (fieldType == NSField.FIELD_RECORD || fieldType == NSField.FIELD_RECORDREF) {
			return processRecordValue(dimension);
		}
		
		// Handle String types
		if (fieldType == NSField.FIELD_STRING) {
			return processStringValue(dimension);
		}
		
		// Handle Object types with JavaWrapperType
		if (fieldType == NSField.FIELD_OBJECT) {
			return processObjectValue(nsField, dimension);
		}
		
		return null;
	}
	
	/**
	 * Process Record/RecordRef values
	 */
	private Object processRecordValue(int dimension) {
		if (dimension == NSField.DIM_SCALAR) {
			return convertJson2IData((String) value);
		} else if (dimension == NSField.DIM_ARRAY) {
			return convertJsonArrayToIDataArray((String) value);
		}
		return null;
	}
	
	/**
	 * Process String values
	 */
	private Object processStringValue(int dimension) {
		if (dimension == NSField.DIM_SCALAR) {
			return processScalarString();
		} else if (dimension == NSField.DIM_ARRAY) {
			return processStringArray();
		} else if (dimension == NSField.DIM_TABLE) {
			return processStringTable();
		}
		return null;
	}
	
	/**
	 * Process Object values with JavaWrapperType
	 */
	private Object processObjectValue(NSField nsField, int dimension) {
		int javaWrapperType = nsField.getJavaWrapperType();
		
		if (dimension == NSField.DIM_SCALAR) {
			return processScalarObjectValue(javaWrapperType);
		}
		// Add array handling if needed in the future
		return null;
	}
	
	/**
	 * Process scalar object values based on JavaWrapperType
	 */
	private Object processScalarObjectValue(int javaWrapperType) {
		String valueStr = value.toString();
		
		switch (javaWrapperType) {
			case JavaWrapperType.JAVA_TYPE_INTEGER:
				return Integer.parseInt(valueStr);
			case JavaWrapperType.JAVA_TYPE_FLOAT:
				return Float.parseFloat(valueStr);
			case JavaWrapperType.JAVA_TYPE_DOUBLE:
				return Double.parseDouble(valueStr);
			case JavaWrapperType.JAVA_TYPE_BOOLEAN:
				return Boolean.parseBoolean(valueStr);
			case JavaWrapperType.JAVA_TYPE_BYTE:
				return Byte.parseByte(valueStr);
			case JavaWrapperType.JAVA_TYPE_CHARACTER:
				return valueStr.isEmpty() ? null : valueStr.charAt(0);
			case JavaWrapperType.JAVA_TYPE_LONG:
				return Long.parseLong(valueStr);
			case JavaWrapperType.JAVA_TYPE_SHORT:
				return Short.parseShort(valueStr);
			case JavaWrapperType.JAVA_TYPE_BIG_INTEGER:
				return new java.math.BigInteger(valueStr);
			case JavaWrapperType.JAVA_TYPE_BIG_DECIMAL:
				return new java.math.BigDecimal(valueStr);
			case JavaWrapperType.JAVA_TYPE_DATE:
				DateValidator dateValidator = new DateValidator();
				ValidationResults validate = dateValidator.validate(valueStr);
				return validate.getResultsValue();
			case JavaWrapperType.JAVA_TYPE_byte_ARRAY:
				// byte[] - return as-is or convert if needed
				return valueStr.getBytes();
			case JavaWrapperType.JAVA_TYPE_XOP_OBJECT:
				// XOPObject - return as string for now
				return valueStr;
			default:
				return valueStr;
		}
	}
	
	/**
	 * Process scalar string value
	 */
	private String processScalarString() {
		String valueStr = (String) value;
		if (valueStr.startsWith("\"\"\"") && valueStr.endsWith("\"\"\"")) {
			return valueStr.substring(3, valueStr.length() - 6);
		}
		return valueStr;
	}
	
	/**
	 * Process string array value
	 */
	private String[] processStringArray() {
		return ((String) value)
			.replace("[", "")
			.replace("]", "")
			.replace("\"", "")
			.split("\\s*,\\s*");
	}
	
	/**
	 * Process string table (2D array) value
	 */
	private String[][] processStringTable() {
		String text = (String) value;
		text = text.substring(1, text.length() - 1);
		String[] rows = text.split("\\],\\s*\\[");
		String[][] result = new String[rows.length][];
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = rows[i].replace("[", "").replace("]", "").replace("\"", "");
			result[i] = rows[i].split("\\s*,\\s*");
		}
		return result;
	}
	
	/**
	 * Convert JSON array string to IData array
	 */
	private IData[] convertJsonArrayToIDataArray(String jsonArrayStr) {
		ObjectMapper mapper = new ObjectMapper();
		List<IData> datas = new ArrayList<IData>();
		try {
			JsonNode jsonNode = mapper.readTree(jsonArrayStr);
			jsonNode.forEach(n -> {
				IData data = convertJson2IData(n.toString());
				if (data != null) {
					datas.add(data);
				}
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return datas.toArray(new IData[datas.size()]);
	}

	/**
	 * Convert JSON string to IData
	 */
	private IData convertJson2IData(String text) {
		IDataJSONCoder jsonCoder = new IDataJSONCoder();
		try {
			return jsonCoder.decodeFromBytes(text.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void generateText(FlowTextContext context) {
		String valueStr = value.toString();
		
		// Check if value is a JSON object (starts with '{')
		if (valueStr.startsWith("{")) {
			// JSON object - output as-is
			context.appendLine("set " + fieldPath + " = " + valueStr + ";");
		}
		// Check if value is an array literal (starts with '[')
		else if (valueStr.startsWith("[")) {
			// Array literal - output as-is
			context.appendLine("set " + fieldPath + " = " + valueStr + ";");
		}
		// Check if value is a triple-quoted string (multiline string for XML)
		else if (valueStr.startsWith("\"\"\"")) {
			// Triple-quoted string - output as-is
			context.appendLine("set " + fieldPath + " = " + valueStr + ";");
		}
		// Check if it's a simple string value
		else if (value instanceof String) {
			String strValue = (String) value;
			// Check if it's a variable reference or field path (no quotes)
			if (strValue.startsWith("$") ||
			    strValue.matches("^[a-zA-Z_][a-zA-Z0-9_]*(/[a-zA-Z_][a-zA-Z0-9_]*)*$")) {
				// Variable reference or field path - output as-is
				context.appendLine("set " + fieldPath + " = " + strValue + ";");
			}
			// Check if it's already a quoted string
			else if (strValue.startsWith("\"") && strValue.endsWith("\"")) {
				// Already quoted - output as-is
				context.appendLine("set " + fieldPath + " = " + strValue + ";");
			}
			// Check if string contains quotes, newlines, or XML-like content - use triple quotes
			else if (strValue.contains("\"") || strValue.contains("\n") ||
			         strValue.contains("<") && strValue.contains(">")) {
				// Use triple-quoted string for XML or multi-line content
				context.appendLine("set " + fieldPath + " = \"\"\"" + strValue + "\"\"\";");
			}
			else {
				// Simple unquoted string - add regular quotes
				context.appendLine("set " + fieldPath + " = \"" + strValue + "\";");
			}
		}else if(value instanceof Date){
			Date date = (Date)value;
			String pattern = DateUtils.calculateDatePattern(Locale.getDefault(), true);
			String formattedDate = DateUtils.getLocalizedStringUsingPattern(date,Locale.getDefault(),pattern);
			context.appendLine("set " + fieldPath + " = \"" + formattedDate + "\";");
		}else {
			context.appendLine("set " + fieldPath + " = " + valueStr + ";");
		}
	}
	
	@Override
	public String getOutlineNodeName() {
		return "SET";
	}

}
