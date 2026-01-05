package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;
import com.wm.lang.ns.Namespace;

public class FlowFinallyExpression extends FlowContainerExpression {

	@Override
	public void addFlowElement(Namespace namespace,FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.FINALLY);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowSequence);
		flowSequence.setParent(parent);
		addFlowProperties(flowSequence);
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
	
	@Override
	public String getOutlineNodeName() {
		return "FINALLY";
	}
}
