package expressions.flow.map;

import java.util.List;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.flow.FlowMapInvoke;
import com.wm.lang.ns.NSName;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

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
	
	@Override
	public FlowElement getFlowElement() {
		FlowMapInvoke flowMapInvoke = new FlowMapInvoke(null);
		
		flowMapInvoke.setService(NSName.create(serviceName));
		
		List<FlowElementExpression> mapExpressions = input.getMapExpressions();
		FlowMap flowMapInput = new FlowMap(null);
		if(mapExpressions.size()>0) {
			FlowGenerator.generateFlow(mapExpressions,flowMapInput);
		}
		flowMapInvoke.setInputMap(flowMapInput);
		
		mapExpressions = output.getMapExpressions();
		FlowMap flowMapOutput = new FlowMap(null);
		if(mapExpressions.size()>0) {
			FlowGenerator.generateFlow(mapExpressions,flowMapOutput);
		}
		flowMapInvoke.setOutputMap(flowMapOutput);
		
		
		return flowMapInvoke;
	}
}
