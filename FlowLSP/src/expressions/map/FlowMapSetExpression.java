package expressions.map;

import expressions.FlowElementExpression;

public class FlowMapSetExpression extends FlowElementExpression{
	
	String key;
	String value;
	
	public FlowMapSetExpression(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
