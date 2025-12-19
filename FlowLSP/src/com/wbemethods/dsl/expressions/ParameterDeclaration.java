package com.wbemethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;
import com.wm.util.JavaWrapperType;

/**
 * Represents a parameter declaration (field, record, or recordList)
 */
public class ParameterDeclaration implements IFlowExpression {
	private String name;
	private String type; // "field", "record", "recordList"
	private String dataType; // For fields: String, Integer, etc.
	private boolean isArray;
	private List<String> constraints; // required, optional, etc.
	private List<ParameterDeclaration> children; // For records

	public ParameterDeclaration(String name, String type) {
		this.name = name;
		this.type = type;
		this.constraints = new ArrayList<>();
		this.children = new ArrayList<>();
	}

	public ParameterDeclaration() {
		this.constraints = new ArrayList<>();
		this.children = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public boolean isArray() {
		return isArray;
	}

	public void setArray(boolean isArray) {
		this.isArray = isArray;
	}

	public List<String> getConstraints() {
		return constraints;
	}

	public void addConstraint(String constraint) {
		this.constraints.add(constraint);
	}

	public List<ParameterDeclaration> getChildren() {
		return children;
	}

	public void addChild(ParameterDeclaration child) {
		this.children.add(child);
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public boolean isRecord() {
		return "record".equals(type);
	}

	public boolean isRecordList() {
		return "recordList".equals(type);
	}

	public boolean isField() {
		return "field".equals(type);
	}

	/**
	 * Convert NSField to ParameterDeclaration
	 */
	public void updateField(NSField field) {
		String name = field.getName();
		int type = field.getType();
		int subType = field.getSubType();
		int dimension = field.getDimensions();

		// Handle nested records
		if (type == NSField.FIELD_RECORD) {
			NSRecord nestedRecord = (NSRecord) field;
			String paramType = (dimension == 1) ? "recordList" : "record";
			this.name = name;
			this.type = paramType;

			// Add children
			List<ParameterDeclaration> children = loadChildren(nestedRecord);
			for (ParameterDeclaration child : children) {
				addChild(child);
			}

		} else {
			// Simple field
			this.name = name;
			this.type = "field";
			setDataType(mapJavaTypeToFlowType(type, subType));
			setArray(dimension == 1);
		}
	}

	/**
	 * Map Java type to Flow DSL type
	 */
	private String mapJavaTypeToFlowType(int fType, int wType) {
		if (fType == NSField.FIELD_STRING) {
			return "String";
		} else if (fType == NSField.FIELD_OBJECT) {
			if (wType == JavaWrapperType.JAVA_TYPE_BOOLEAN) {
				return "Boolean";
			} else if (wType == JavaWrapperType.JAVA_TYPE_INTEGER) {
				return "Integer";
			} else if (wType == JavaWrapperType.JAVA_TYPE_FLOAT) {
				return "Float";
			} else if (wType == JavaWrapperType.JAVA_TYPE_DOUBLE) {
				return "Double";
			} else if (wType == JavaWrapperType.JAVA_TYPE_DATE) {
				return "DateTime";
			}
		} else if (fType == NSField.FIELD_RECORD) {
			return "Document";
		}
		return "String";
	}

	/**
	 * Convert NSRecord to list of ParameterDeclarations
	 */
	public List<ParameterDeclaration> loadChildren(NSRecord record) {
		List<ParameterDeclaration> params = new ArrayList<>();

		if (record == null)
			return params;
		NSField[] fields = record.getFields();
		for (int i = 0; i < fields.length; i++) {
			NSField field = fields[i];
			ParameterDeclaration declaration = new ParameterDeclaration();
			declaration.updateField(field);
			params.add(declaration);
		}

		return params;
	}

}