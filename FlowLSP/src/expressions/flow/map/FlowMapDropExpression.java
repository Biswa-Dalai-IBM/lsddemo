package expressions.flow.map;

public class FlowMapDropExpression extends FlowMapExpression{
	
	String fieldName;
	
	public FlowMapDropExpression(String fieldName) {
		super();
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}
	
}
