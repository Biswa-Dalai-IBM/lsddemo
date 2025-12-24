package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

public class FlowSequenceExpression extends FlowContainerExpression {

	private int exitOn;
	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}
	
	@Override
	public void updateStepProperties(FlowElement element) {
		super.updateStepProperties(element);
		FlowSequence flowSequence = (FlowSequence) element;
		exitOn = flowSequence.getExitOn();
	}
	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("SEQUENCE {");
		context.append("\n");
		context.increaseIndent();
		
		context.appendIndented("exitOn: \"" + FlowSequence.exitonOptions[exitOn] + "\";");
		context.append("\n");
		
		// Generate child steps
		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("};");
		context.append("\n");
	}

}
