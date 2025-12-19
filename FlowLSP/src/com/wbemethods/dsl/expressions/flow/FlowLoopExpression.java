package com.wbemethods.dsl.expressions.flow;

import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
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
}
