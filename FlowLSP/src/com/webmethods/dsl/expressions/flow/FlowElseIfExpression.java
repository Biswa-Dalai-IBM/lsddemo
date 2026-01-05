package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;
import com.wm.lang.ns.Namespace;

public class FlowElseIfExpression extends FlowContainerExpression {

	private String condition;

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	@Override
	public void addFlowElement(Namespace namespace,FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.ELSEIF);
		flowSequence.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowSequence);
		flowSequence.setParent(parent);
		addFlowProperties(flowSequence);
		parent.addNode(flowSequence);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowSequence flowSequence = (FlowSequence) element;
		condition = flowSequence.getCondition();
		condition = condition.replaceAll("%", "");
		super.updateExpression(element);
	}
	
	@Override
	public String getOutlineNodeName() {
		return "ELSEIF ("+condition+")";
	}
}
