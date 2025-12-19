package com.wbemethods.dsl.expressions.flow;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowWhile;

public class FlowWhileExpression extends FlowContainerExpression {

	private String condition;

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	@Override
	public void addFlowElement(FlowElement parent) {

		FlowWhile flowWhile = new FlowWhile(null);
		flowWhile.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowWhile);
		parent.addNode(flowWhile);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowWhile flowWhile = (FlowWhile) element;
		condition = flowWhile.getCondition();
		condition = condition.replaceAll("%", "");
		super.updateExpression(element);
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("WHILE(" + condition + ") {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("};\n");
	}
}
