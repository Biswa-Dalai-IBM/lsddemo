package com.wbemethods.dsl.expressions.flow.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.VariableResolver;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapSet;
import com.wm.lang.ns.NSField;
import com.wm.util.coder.IDataJSONCoder;

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
	public FlowElement getFlowElement() {
		FlowMapSet setData = new FlowMapSet(null);
		String nsFieldPath = NSFieldPathBuilder.buildNSFieldPath(fieldPath, variableResolver);
		setData.setField(nsFieldPath);
		setData.setVariables(false);
		setData.setOverwrite(true);
		setData.setGlobalVariables(false);
		setData.setName("Setter");
		NSField nsField = NSFieldPathBuilder.buildNSField(fieldPath, variableResolver);
		setData.setInputType(nsField);
		
		
		if(nsField.getType()==NSField.FIELD_RECORD && nsField.getDimensions()==NSField.DIM_SCALAR) {
			IData data = convertJson2IDada((String)value);
			if(data!=null) {
				setData.setInput(data);
			}
			
		}else if(nsField.getType()==NSField.FIELD_RECORD && nsField.getDimensions()==NSField.DIM_ARRAY) {
			ObjectMapper mapper = new ObjectMapper();
			List<IData> datas = new ArrayList<IData>();
			try {
				JsonNode jsonNode = mapper.readTree((String)value);
				jsonNode.forEach(n->{
					IData data = convertJson2IDada(n.toString());
					if(data!=null) {
						datas.add(data);
					}
				});
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			setData.setInput((IData[]) datas.toArray(new IData[datas.size()]));
			
		}else if(nsField.getType()==NSField.FIELD_STRING && nsField.getDimensions()==NSField.DIM_SCALAR) {
			String valueStr = (String)value;
			if(valueStr.startsWith("\"\"\"") && valueStr.endsWith("\"\"\"")) {
				valueStr = valueStr.substring(3, valueStr.length()-6);
			}
			setData.setInput(valueStr);
		}else if(nsField.getType()==NSField.FIELD_STRING && nsField.getDimensions()==NSField.DIM_ARRAY) {
			String[] array = ((String) value)
			        .replace("[", "")
			        .replace("]", "")
			        .replace("\"", "")
			        .split("\\s*,\\s*");
			setData.setInput(array);
		}else if(nsField.getType()==NSField.FIELD_STRING && nsField.getDimensions()==NSField.DIM_TABLE) {
			String text = (String) value;
			text = text.substring(1, text.length() - 1);

	        String[] rows = text.split("\\],\\s*\\[");

	        String[][] result = new String[rows.length][];

	        for (int i = 0; i < rows.length; i++) {
	            rows[i] = rows[i].replace("[", "").replace("]", "").replace("\"", "");
	            result[i] = rows[i].split("\\s*,\\s*");
	        }
			setData.setInput(result);
		}
		return setData;
	}

	private IData convertJson2IDada(String text) {
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
		}else {
			context.appendLine("set " + fieldPath + " = " + valueStr + ";");
		}
	}

}
