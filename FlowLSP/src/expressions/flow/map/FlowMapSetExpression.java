package expressions.flow.map;

public class FlowMapSetExpression extends FlowMapExpression{
	
	String fieldPath;
	String value;
	
	public FlowMapSetExpression(String fieldPath, String value) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
	}
	
}
