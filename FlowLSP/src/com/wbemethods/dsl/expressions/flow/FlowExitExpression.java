package com.wbemethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowExit;

public class FlowExitExpression extends FlowElementExpression {
	List<FlowStepProperty> properties;

	public FlowExitExpression() {
		properties = new ArrayList<FlowStepProperty>();
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}

	@Override
	public FlowElement getFlowElement() {
		return new FlowExit(null);
	}

	@Override
	public void updateExpression(FlowElement element) {
		// TODO Auto-generated method stub

	}
}
