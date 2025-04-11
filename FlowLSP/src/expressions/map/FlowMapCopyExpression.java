package expressions.map;

import expressions.FlowElementExpression;

public class FlowMapCopyExpression extends FlowElementExpression{
	
	String from;
	String to;
	
	public FlowMapCopyExpression(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	
}
