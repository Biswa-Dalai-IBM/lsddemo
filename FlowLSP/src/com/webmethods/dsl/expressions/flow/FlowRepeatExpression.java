package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowRetry;

public class FlowRepeatExpression extends FlowContainerExpression {
	@Override
	public void addFlowElement(FlowElement parent) {
		FlowRetry flowRetry = new FlowRetry(null);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowRetry);
		parent.addNode(flowRetry);
	}
}
