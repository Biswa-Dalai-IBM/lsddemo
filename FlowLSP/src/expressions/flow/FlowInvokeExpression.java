package expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowInvoke;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.ns.NSName;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;
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
	
	public List<FlowStepProperty> getProperties() {
		return properties;
	}

	@Override
	public FlowElement getFlowElement() {
		FlowInvoke flowInvoke = new FlowInvoke(null);
		flowInvoke.setService(NSName.create(serviceName));
		if(input!=null) {
			List<FlowElementExpression> mapExpressions = input.getMapExpressions();
			FlowMap flowMapInput = new FlowMap(null);
			if(mapExpressions.size()>0) {
				FlowGenerator.generateFlow(mapExpressions,flowMapInput);
			}
			flowInvoke.setInputMap(flowMapInput);
			flowMapInput.setSchemaInfo(input.getMapSourceRecord(), input.getMapTargetRecord());
		}
		if(output!=null) {
			List<FlowElementExpression> mapExpressions = output.getMapExpressions();
			FlowMap flowMapOutput = new FlowMap(null);
			if(mapExpressions.size()>0) {
				FlowGenerator.generateFlow(mapExpressions,flowMapOutput);
			}
			flowInvoke.setOutputMap(flowMapOutput);
			flowMapOutput.setSchemaInfo(output.getMapSourceRecord(), output.getMapTargetRecord());
		}
		return flowInvoke;
	}
	
}
