package expressions.flow;

import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;
import expressions.flow.map.MapIOExprssion;

public class FlowInvokeExpression extends FlowElementExpression{
	
	List<FlowStepProperty> properties;
	String serviceName;
	MapIOExprssion input;
	MapIOExprssion output;
	
	public FlowInvokeExpression(String serviceName,MapIOExprssion input, MapIOExprssion output) {
		super();
		this.serviceName=serviceName;
		this.input = input;
		this.output = output;
		properties = new ArrayList<FlowStepProperty>();
	}

	public FlowInvokeExpression() {
		properties = new ArrayList<FlowStepProperty>();
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
	
	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}
	
}
