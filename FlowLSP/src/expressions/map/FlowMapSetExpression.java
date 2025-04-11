package expressions.map;

import expressions.FlowElementExpression;

public class FlowMapSetExpression extends FlowMapExpression{
	
	String key;
	String value;
	
	public FlowMapSetExpression(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
