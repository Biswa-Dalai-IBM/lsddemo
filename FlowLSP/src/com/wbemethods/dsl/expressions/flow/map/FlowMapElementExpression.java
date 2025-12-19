package com.wbemethods.dsl.expressions.flow.map;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.flow.FlowStepProperty;
import com.wm.lang.flow.FlowElement;

public class FlowMapElementExpression extends AbstractFlowMapExpression {
	List<FlowStepProperty> properties;

	public FlowMapElementExpression() {
		super();
		properties = new ArrayList<FlowStepProperty>();
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}

	public boolean hasProperties() {
		return properties != null && !properties.isEmpty();
	}

	@Override
	public void updateExpression(FlowElement element) {
		// TODO Auto-generated method stub

	}
}
