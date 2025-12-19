package com.wbemethods.dsl.expressions.flow.map;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.flow.FlowContainerExpression;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.flow.FlowMapInvoke;
import com.wm.lang.ns.NSName;

public class FlowMapInvokeExpression extends FlowMapExpression {

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

		List<FlowMapExpression> mapExpressions = input.getMapExpressions();
		FlowMap flowMapInput = new FlowMap(null);
		if (mapExpressions.size() > 0) {
			loadChildren(mapExpressions, flowMapInput);
		}
		flowMapInvoke.setInputMap(flowMapInput);

		mapExpressions = output.getMapExpressions();
		FlowMap flowMapOutput = new FlowMap(null);
		if (mapExpressions.size() > 0) {
			loadChildren(mapExpressions, flowMapOutput);
		}
		flowMapInvoke.setOutputMap(flowMapOutput);

		return flowMapInvoke;
	}

	private void loadChildren(List<FlowMapExpression> expressions, FlowElement element) {
		for (FlowElementExpression expression : expressions) {
			if (expression instanceof FlowContainerExpression) {
				FlowContainerExpression containerExpression = (FlowContainerExpression) expression;
				containerExpression.addFlowElement(element);
			} else {
				FlowElement childElement = expression.getFlowElement();
				if (childElement != null) {
					element.addNode(childElement);
				}
			}
		}
	}
}
