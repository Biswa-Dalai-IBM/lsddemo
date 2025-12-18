package expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a parameter declaration (field, record, or recordList)
 */
public class ParameterDeclaration implements IFlowExpression{
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
}