package expressions.map;

public class FlowMapInvokeExpression extends FlowMapExpression{
	
	MapIOExprssion input;
	MapIOExprssion output;
	
	public FlowMapInvokeExpression(MapIOExprssion input, MapIOExprssion output) {
		super();
		this.input = input;
		this.output = output;
	}
	
}
