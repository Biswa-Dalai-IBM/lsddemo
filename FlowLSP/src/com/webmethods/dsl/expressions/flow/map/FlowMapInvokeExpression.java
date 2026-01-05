package com.webmethods.dsl.expressions.flow.map;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.flow.FlowContainerExpression;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.flow.FlowMapInvoke;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.Namespace;

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
	public FlowElement getFlowElement(Namespace namespace) {
		FlowMapInvoke flowMapInvoke = new FlowMapInvoke(null);

		flowMapInvoke.setService(NSName.create(serviceName));

		List<FlowMapExpression> mapExpressions = input.getMapExpressions();
		FlowMap flowMapInput = new FlowMap(null);
		if (mapExpressions.size() > 0) {
			loadChildren(namespace,mapExpressions, flowMapInput);
		}
		flowMapInput.setParent(flowMapInvoke);
		flowMapInvoke.setInputMap(flowMapInput);
		mapExpressions = output.getMapExpressions();
		FlowMap flowMapOutput = new FlowMap(null);
		if (mapExpressions.size() > 0) {
			loadChildren(namespace,mapExpressions, flowMapOutput);
		}
		flowMapOutput.setParent(flowMapInvoke);
		flowMapInvoke.setOutputMap(flowMapOutput);

		return flowMapInvoke;
	}

	private void loadChildren(Namespace namespace,List<FlowMapExpression> expressions, FlowElement element) {
		for (FlowElementExpression expression : expressions) {
			if (expression instanceof FlowContainerExpression) {
				FlowContainerExpression containerExpression = (FlowContainerExpression) expression;
				containerExpression.addFlowElement(namespace,element);
			} else {
				FlowElement childElement = expression.getFlowElement(namespace);
				if (childElement != null) {
					childElement.setParent(element);
					element.addNode(childElement);
				}
			}
		}
	}
	
	@Override
	public void updateExpression(FlowElement element) {
		FlowMapInvoke flowInvoke = (FlowMapInvoke) element;
		NSName service = flowInvoke.getService();
		serviceName = service.getFullName();

		FlowMap inputMap = flowInvoke.getInputMap();
		if (inputMap != null) {
			input = new MapIOExprssion();
			input.setInput(true);
			input.updateExpression(inputMap);
		}

		FlowMap outputMap = flowInvoke.getOutputMap();
		if (outputMap != null) {
			output = new MapIOExprssion();
			output.setInput(false);
			output.updateExpression(outputMap);
		}
	}
	
	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("TRANSFORM " + serviceName);

		if (input != null  || output != null || hasProperties()) {
			context.append(" {\n");
			context.increaseIndent();

			generateStepProperties(context);

			if (input != null && input.hasExpressions()) {
				context.appendIndented("input {\n");
				context.increaseIndent();
				input.generateText(context);
				context.decreaseIndent();
				context.appendLine("}");
			}

			if (output != null && output.hasExpressions()) {
				context.appendIndented("output {\n");
				context.increaseIndent();
				output.generateText(context);
				context.decreaseIndent();
				context.appendLine("}");
			}

			context.decreaseIndent();
			context.appendIndented("};\n");
		} else {
			context.append(";\n");
		}
	}
	@Override
	public String getOutlineNodeName() {
		return "TRANSFORM";
	}
}
