package com.webmethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

/**
 * Represents a document type definition (.doc file)
 * Example: document com.example:Student { ... }
 */
public class DocumentDeclaration implements IFlowExpression {
	private String qualifiedName; // e.g., "com.example:Student"
	private String packageName;   // e.g., "com.example"
	private String documentName;  // e.g., "Student"
	private List<ParameterDeclaration> fields;
	private int line;
	private int column;

	public DocumentDeclaration() {
		this.fields = new ArrayList<>();
	}

	public DocumentDeclaration(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		this.fields = new ArrayList<>();
		parseQualifiedName(qualifiedName);
	}

	private void parseQualifiedName(String qualifiedName) {
		if (qualifiedName != null && qualifiedName.contains(":")) {
			String[] parts = qualifiedName.split(":");
			this.packageName = parts[0];
			this.documentName = parts.length > 1 ? parts[1] : "";
		}
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		parseQualifiedName(qualifiedName);
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public List<ParameterDeclaration> getFields() {
		return fields;
	}

	public void addField(ParameterDeclaration field) {
		this.fields.add(field);
	}

	public boolean hasFields() {
		return fields != null && !fields.isEmpty();
	}

	/**
	 * Get a field by name
	 */
	public ParameterDeclaration getField(String name) {
		for (ParameterDeclaration field : fields) {
			if (field.getName().equals(name)) {
				return field;
			}
		}
		return null;
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendLine("document " + qualifiedName + " {");
		context.increaseIndent();
		
		if (hasFields()) {
			for (ParameterDeclaration field : fields) {
				field.generateText(context);
			}
		}
		
		context.decreaseIndent();
		context.appendLine("};");
	}

	@Override
	public String toString() {
		return "DocumentDeclaration{" +
				"qualifiedName='" + qualifiedName + '\'' +
				", packageName='" + packageName + '\'' +
				", documentName='" + documentName + '\'' +
				", fields=" + fields.size() +
				'}';
	}
	
	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getCharPositionInLine() {
		return column;
	}
	
	@Override
	public void setLocation(Token token) {
		if(token==null) {
			return;
		}
		this.line=token.getLine();
		this.column=token.getCharPositionInLine();
	}
	
	@Override
	public String getOutlineNodeName() {
		return null;
	}
}

// Made with Bob
