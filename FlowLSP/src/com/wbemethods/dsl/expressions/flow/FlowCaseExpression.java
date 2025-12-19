package com.wbemethods.dsl.expressions.flow;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

public class FlowCaseExpression extends FlowContainerExpression {

	private String caseValue;

	public void setCaseValue(String caseValue) {
		this.caseValue = caseValue;
	}

	public String getCaseValue() {
		return caseValue;
	}

	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setCaseValue(caseValue);
		flowSequence.setForm(FlowSequence.CASE);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowSequence flowSequence = (FlowSequence) element;
		caseValue = flowSequence.getCaseValue();
		super.updateExpression(element);
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("CASE \"" + caseValue + "\" {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("}\n");
	}
}
