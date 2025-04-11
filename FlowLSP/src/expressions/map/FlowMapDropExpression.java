package expressions.map;

import expressions.FlowElementExpression;

public class FlowMapDropExpression extends FlowElementExpression{
	
	String fieldName;
	
	public FlowMapDropExpression(String fieldName) {
		super();
		this.fieldName = fieldName;
	}
	
}
