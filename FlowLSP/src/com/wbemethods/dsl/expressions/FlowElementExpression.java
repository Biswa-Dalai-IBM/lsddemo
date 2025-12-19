package com.wbemethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.flow.FlowStepProperty;
import com.wm.lang.flow.FlowElement;

public abstract class FlowElementExpression implements IFlowExpression {
	List<FlowStepProperty> properties;

	public abstract FlowElement getFlowElement();

	public abstract void updateExpression(FlowElement element);

	public FlowElementExpression() {
		properties = new ArrayList<FlowStepProperty>();
	}

	/**
	 * Convert FlowElement to FlowElementExpression using Factory Pattern
	 * 
	 * @param element The FlowElement to convert
	 * @return The corresponding FlowElementExpression, or null if not supported
	 */
	protected FlowElementExpression convertFlowElement(FlowElement element) {
		return FlowExpressionFactory.createExpression(element);
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}

}
