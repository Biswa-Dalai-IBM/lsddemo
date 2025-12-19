package com.wbemethods.dsl.expressions.flow;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.flow.map.FlowMapExpression;
import com.wbemethods.dsl.expressions.flow.map.MapIOExprssion;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowInvoke;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.ns.NSName;

public class FlowInvokeExpression extends FlowElementExpression {

	String serviceName;
	MapIOExprssion input;
	MapIOExprssion output;

	public FlowInvokeExpression(String serviceName, MapIOExprssion input, MapIOExprssion output) {
		super();
		this.serviceName = serviceName;
		this.input = input;
		this.output = output;
	}

	public FlowInvokeExpression() {
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
		FlowInvoke flowInvoke = new FlowInvoke(null);
		flowInvoke.setService(NSName.create(serviceName));
		if (input != null) {
			List<FlowMapExpression> mapExpressions = input.getMapExpressions();
			FlowMap flowMapInput = new FlowMap(null);
			if (mapExpressions.size() > 0) {
				loadChildren(mapExpressions, flowMapInput);
			}
			flowInvoke.setInputMap(flowMapInput);
			flowMapInput.setSchemaInfo(input.getMapSourceRecord(), input.getMapTargetRecord());
		}
		if (output != null) {
			List<FlowMapExpression> mapExpressions = output.getMapExpressions();
			FlowMap flowMapOutput = new FlowMap(null);
			if (mapExpressions.size() > 0) {
				loadChildren(mapExpressions, flowMapOutput);
			}
			flowInvoke.setOutputMap(flowMapOutput);
			flowMapOutput.setSchemaInfo(output.getMapSourceRecord(), output.getMapTargetRecord());
		}
		return flowInvoke;
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowInvoke flowInvoke = (FlowInvoke) element;
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

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("INVOKE " + serviceName);

		if (input != null  || output != null || hasProperties()) {
			context.append(" {\n");
			context.increaseIndent();

			if (hasProperties()) {
				for (FlowStepProperty prop : getProperties()) {
					prop.generateText(context);
				}
			}

			if (input != null) {
				context.appendIndented("input {\n");
				context.increaseIndent();
				input.generateText(context);
				context.decreaseIndent();
				context.appendLine("}");
			}

			if (output != null) {
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

}
