package expressions.flow.map;

public class FlowMapCopyExpression extends FlowMapExpression{
	
	String from;
	String to;
	
	public FlowMapCopyExpression(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}
	
	
	
}
