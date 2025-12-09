package expressions.flow.map;

public class FlowMapInvokeExpression extends FlowMapExpression{
	
	String serviceName;
	MapIOExprssion input;
	MapIOExprssion output;
	
	public FlowMapInvokeExpression(String serviceName, MapIOExprssion input, MapIOExprssion output) {
		super();
		this.serviceName = serviceName;
		this.input = input;
		this.output = output;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public MapIOExprssion getInput() {
		return input;
	}
	
	public void setInput(MapIOExprssion input) {
		this.input = input;
	}
	
	public MapIOExprssion getOutput() {
		return output;
	}
	
	public void setOutput(MapIOExprssion output) {
		this.output = output;
	}
}
