package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.webmethods.is.util.IDataMap;
import com.wm.data.IData;
import com.wm.lang.flow.FlowDo;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowUntil;

public class FlowDoUntilExpression extends FlowContainerExpression {

	private String untilCondition;

	public void setUntilCondition(String condition) {
		this.untilCondition = condition;
	}

	public String getUntilCondition() {
		return untilCondition;
	}

	public boolean hasUntilCondition() {
		return untilCondition != null && !untilCondition.isEmpty();
	}

	@Override
	public void addFlowElement(FlowElement parent) {
		int maxIteration = -1;
		FlowStepProperty property = getProperty("maxIteration");
		if (property != null) {
			maxIteration = Integer.parseInt(property.getValue());
		}

		FlowDo flowDo = new FlowDo(null);
		List<FlowElementExpression> expressions2 = getExpressions();
		if (expressions2.size() > 0) {
			FlowGenerator.generateFlow(expressions2, flowDo);
		}
		FlowUntil flowUntil = new FlowUntil(null);
		flowUntil.setCondition(untilCondition);
		flowDo.addNode(flowUntil);
		IData asData = flowDo.getAsData();
		IDataMap dataMap = new IDataMap(asData);
		dataMap.put(FlowDo.KEY_DO_MAX_ITERATIONS, maxIteration);
		flowDo.setFromData(dataMap.getIData());
		parent.addNode(flowDo);
	}
	
	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("DO {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("} UNTIL( "+untilCondition+" );");
		context.append("\n");
	}

}
