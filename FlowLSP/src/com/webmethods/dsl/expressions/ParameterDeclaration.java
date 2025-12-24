package com.webmethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSRecordRef;
import com.wm.util.JavaWrapperType;

/**
 * Represents a parameter declaration (field, record, or recordList)
 */
public class ParameterDeclaration implements IFlowExpression {
	private String name;
	private String type; // "field", "record", "recordList"
	private String dataType; // For fields: String, Integer, etc.
	private int dimension; // 0 = scalar, 1 = 1D array, 2 = 2D array, etc.
	private String documentReference; // For records: reference to external document type (e.g., "com.example:Student")
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

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	/**
	 * Check if this parameter is an array (1D or higher)
	 */
	public boolean isArray() {
		return dimension > 0;
	}

	public String getDocumentReference() {
		return documentReference;
	}

	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}

	/**
	 * Check if this record has a document reference
	 */
	public boolean hasDocumentReference() {
		return documentReference != null && !documentReference.isEmpty();
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

		} else if (type == NSField.FIELD_RECORDREF) {
			NSRecordRef nestedRecord = (NSRecordRef) field;
			String paramType = (dimension == 1) ? "recordList" : "record";
			this.name = name;
			this.type = paramType;
			setDimension(dimension);
			this.documentReference = nestedRecord.getTargetName().getFullName();

		}else {
			// Simple field
			this.name = name;
			this.type = "field";
			;
			setDataType(NSFieldTypeMapper.getTypeName(type, subType));
			setDimension(dimension);
		}
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

	@Override
	public void generateText(FlowTextContext context) {
		if (isField()) {
			// Generate array brackets based on dimension
			StringBuilder arrayStr = new StringBuilder();
			for (int i = 0; i < dimension; i++) {
				arrayStr.append("[]");
			}
			if (dimension > 0) {
				arrayStr.append(" ");
			} else {
				arrayStr.append(" ");
			}
			context.appendLine(dataType + arrayStr.toString() + name + ";");
		} else if (isRecord()) {
			// Generate record with optional document reference and optional body
			if (hasDocumentReference() && !hasChildren()) {
				// Document reference without body
				context.appendLine("record " + name + " (" + documentReference + ");");
			} else {
				// With body (may or may not have document reference)
				if (hasDocumentReference()) {
					context.appendLine("record " + name + " (" + documentReference + ") {");
				} else {
					context.appendLine("record " + name + " {");
				}
				context.increaseIndent();
				if (hasChildren()) {
					for (ParameterDeclaration child : getChildren()) {
						child.generateText(context);
					}
				}
				context.decreaseIndent();
				context.appendLine("};");
			}
		} else if (isRecordList()) {
			// Generate recordList with optional document reference and optional body
			if (hasDocumentReference() && !hasChildren()) {
				// Document reference without body
				context.appendLine("recordList " + name + " (" + documentReference + ");");
			} else {
				// With body (may or may not have document reference)
				if (hasDocumentReference()) {
					context.appendLine("recordList " + name + " (" + documentReference + ") {");
				} else {
					context.appendLine("recordList " + name + " {");
				}
				context.increaseIndent();
				if (hasChildren()) {
					for (ParameterDeclaration child : getChildren()) {
						child.generateText(context);
					}
				}
				context.decreaseIndent();
				context.appendLine("};");
			}
		}
	}

}