package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.webmethods.is.util.IDataMap;
import com.wm.data.IData;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowWhile;
import com.wm.lang.ns.Namespace;
import com.wm.util.Values;

public class FlowWhileExpression extends FlowContainerExpression {

	private String condition;
	private int maxIteration;

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	@Override
	public void addFlowElement(Namespace namespace,FlowElement parent) {
		int maxIteration = 0;
		FlowStepProperty property = getProperty("maxIteration");
		if (property != null) {
			maxIteration = Integer.parseInt(property.getValue());
		}
		
		FlowWhile flowWhile = new FlowWhile(null);
		flowWhile.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowWhile);
		flowWhile.setParent(parent);
		addFlowProperties(flowWhile);
		IData asData = flowWhile.getAsData();
		IDataMap dataMap = new IDataMap(asData);
		dataMap.put(FlowWhile.KEY_WHILE_MAX_ITERATIONS, maxIteration);
		flowWhile.setFromData(dataMap.getIData());
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
	public void updateStepProperties(FlowElement element) {
		super.updateStepProperties(element);
		if (element != null && element instanceof FlowElement ) {
			Values properties = ((FlowElement)element).getValues();
			maxIteration = properties.getInt(FlowWhile.KEY_WHILE_MAX_ITERATIONS);
		}
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("WHILE(" + condition + ") {");
		context.append("\n");
		context.increaseIndent();
		generateStepProperties(context);
		
		context.appendIndented("maxIteration: " +maxIteration + ";");
		context.append("\n");
		
		
		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("}\n");
	}
	
	@Override
	public String getOutlineNodeName() {
		return "WHILE ("+condition+")";
	}
}
