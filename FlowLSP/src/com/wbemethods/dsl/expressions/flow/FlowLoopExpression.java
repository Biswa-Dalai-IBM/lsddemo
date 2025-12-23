package com.wbemethods.dsl.expressions.flow;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowTextContext;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowLoop;

public class FlowLoopExpression extends FlowContainerExpression {

	@Override
	public void addFlowElement(FlowElement parent) {
		IData iData = IDataFactory.create();

		FlowStepProperty property = getProperty("inputArray");
		if (property != null) {
			IDataUtil.put(iData.getCursor(), FlowLoop.KEY_LOOP_INARRAY, property.value);
		}

		property = getProperty("outputArray");
		if (property != null) {
			IDataUtil.put(iData.getCursor(), FlowLoop.KEY_LOOP_OUTARRAY, property.value);
		}
		FlowLoop flowLoop = new FlowLoop(iData);

		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowLoop);
		parent.addNode(flowLoop);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowLoop flowLoop = (FlowLoop) element;
		addProperty(new FlowStepProperty("inputArray", flowLoop.getInArray()));
		addProperty(new FlowStepProperty("outputArray", flowLoop.getOutArray()));
		super.updateExpression(element);
	}
	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("LOOP {");
		context.append("\n");
		context.increaseIndent();

		// Generate loop properties
		generateLoopProperties(context);

		// Generate child steps
		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("};");
		context.append("\n");
	}

	/**
	 * Generate loop properties (inputArray, outputArray)
	 */
	private void generateLoopProperties(FlowTextContext context) {
		// Generate inputArray property
		FlowStepProperty inputArrayProp = getProperty("inputArray");
		if (inputArrayProp != null) {
			context.appendIndented("inputArray: \"" + inputArrayProp.getValue() + "\";");
			context.append("\n");
		}

		// Generate outputArray property
		FlowStepProperty outputArrayProp = getProperty("inputArray");
		if (outputArrayProp != null) {
			context.appendIndented("outputArray: \"" + outputArrayProp.getValue() + "\";");
			context.append("\n");
		}

		// Generate common step properties (comment, label, timeout, scope)
		generateStepProperties(context);
	}


}
