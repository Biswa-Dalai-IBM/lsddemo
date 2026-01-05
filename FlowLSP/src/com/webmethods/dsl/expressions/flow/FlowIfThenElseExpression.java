package com.webmethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;
import com.wm.lang.ns.Namespace;

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
	public void addFlowElement(Namespace namespace,FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.IF);
		flowSequence.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowSequence);
		parent.addNode(flowSequence);

		for (FlowElseIfExpression elseIfExpression : elseIfExpressions) {
			elseIfExpression.addFlowElement(namespace,parent);
		}
		if(elseExpression!=null) {
			elseExpression.addFlowElement(namespace,parent);
		}

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
		condition = condition.replaceAll("%", "");
		super.updateExpression(element);
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("IF(" + condition + ") {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("}");

		if (elseIfExpressions != null) {
			for (FlowElseIfExpression elseIf : elseIfExpressions) {
				context.append("ELSEIF(" + elseIf.getCondition() + ") {");
				context.append("\n");
				context.increaseIndent();
				for (FlowElementExpression child : elseIf.getExpressions()) {
					child.generateText(context);
				}
				context.decreaseIndent();
				context.appendIndented("}");
			}
		}

		if (elseExpression != null) {
			context.append("ELSE {");
			context.append("\n");
			context.increaseIndent();
			for (FlowElementExpression child : elseExpression.getExpressions()) {
				child.generateText(context);
			}
			context.decreaseIndent();
			context.appendIndented("}");
		}

		context.append(";\n");
	}
	
	@Override
	public String getOutlineNodeName() {
		return "IF ("+condition+")";
	}

}
