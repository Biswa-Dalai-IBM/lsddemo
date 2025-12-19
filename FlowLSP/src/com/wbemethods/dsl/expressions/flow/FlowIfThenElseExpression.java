package com.wbemethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

public class FlowIfThenElseExpression extends FlowContainerExpression {
	private String condition;

	private List<FlowElseIfExpression> elseIfExpressions;
	private FlowElseExpression elseExpression;

	public FlowIfThenElseExpression() {
		elseIfExpressions = new ArrayList<FlowElseIfExpression>();
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.IF);
		flowSequence.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);

		for (FlowElseIfExpression elseIfExpression : elseIfExpressions) {
			elseIfExpression.addFlowElement(parent);
		}

		elseExpression.addFlowElement(parent);

	}

	public void addElseIfExpressions(FlowElseIfExpression expression) {
		elseIfExpressions.add(expression);
	}

	public void setElseExpression(FlowElseExpression elseExpression) {
		this.elseExpression = elseExpression;
	}

	public FlowElseExpression getElseExpression() {
		return elseExpression;
	}

	public List<FlowElseIfExpression> getElseIfExpressions() {
		return elseIfExpressions;
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowSequence flowSequence = (FlowSequence) element;
		condition = flowSequence.getCondition();
		super.updateExpression(element);
	}
}
