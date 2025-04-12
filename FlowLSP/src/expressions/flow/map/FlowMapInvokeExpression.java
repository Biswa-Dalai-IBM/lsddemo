package expressions.flow.map;

public class FlowMapInvokeExpression extends FlowMapExpression{
	
	String serviceName;
	MapIOExprssion input;
	MapIOExprssion output;
	
	public FlowMapInvokeExpression(String serviceName,MapIOExprssion input, MapIOExprssion output) {
		super();
		this.serviceName=serviceName;
		this.input = input;
		this.output = output;
	}
	
}
