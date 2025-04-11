package expressions.map;

import expressions.FlowElementExpression;

public class FlowMapDropExpression extends FlowMapExpression{
	
	String fieldName;
	
	public FlowMapDropExpression(String fieldName) {
		super();
		this.fieldName = fieldName;
	}
	
}
