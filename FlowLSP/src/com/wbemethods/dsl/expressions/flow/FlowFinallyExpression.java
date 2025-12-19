package com.wbemethods.dsl.expressions.flow;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

public class FlowFinallyExpression extends FlowContainerExpression {

	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.FINALLY);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.append("FINALLY {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("}");
	}
}
