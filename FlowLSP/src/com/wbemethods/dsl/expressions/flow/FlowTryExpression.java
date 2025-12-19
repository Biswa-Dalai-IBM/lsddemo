package com.wbemethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

public class FlowTryExpression extends FlowContainerExpression {
	private List<FlowCatchExpression> catchExpressions;
	private FlowFinallyExpression finallyExpression;

	public FlowTryExpression() {
		catchExpressions = new ArrayList<FlowCatchExpression>();
	}

	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.TRY);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);

		for (FlowCatchExpression catchExpression : catchExpressions) {
			catchExpression.addFlowElement(parent);
		}

		finallyExpression.addFlowElement(parent);
	}

	public List<FlowCatchExpression> getCatchExpressions() {
		return catchExpressions;
	}

	public FlowFinallyExpression getFinallyExpression() {
		return finallyExpression;
	}

	public void addCatchExpressions(FlowCatchExpression expression) {
		catchExpressions.add(expression);
	}

	public void setCatchExpressions(List<FlowCatchExpression> catchExpressions) {
		this.catchExpressions = catchExpressions;
	}

	public void setFinallyExpression(FlowFinallyExpression finallyExpression) {
		this.finallyExpression = finallyExpression;
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("TRY {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("}");

		if (catchExpressions != null && !catchExpressions.isEmpty()) {
			for (FlowCatchExpression catchExpr : catchExpressions) {
				catchExpr.generateText(context);
			}
		}

		if (finallyExpression != null) {
			finallyExpression.generateText(context);
		}

		context.append(";\n");
	}
}
