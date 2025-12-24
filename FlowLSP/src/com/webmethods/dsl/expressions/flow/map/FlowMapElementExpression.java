package com.webmethods.dsl.expressions.flow.map;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.flow.FlowStepProperty;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMap;

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
		convertFlowMap((FlowMap) element);
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("MAP");

		if (hasMapSignature() || hasExpressions()) {
			context.append(" {\n");
			context.increaseIndent();

			generateStepProperties(context);
			if (hasMapSignature()) {
				getMapSignature().generateText(context);
			}

			if (hasExpressions()) {
				for (FlowElementExpression expr : getMapExpressions()) {
					expr.generateText(context);
				}
			}

			context.decreaseIndent();
			context.appendIndented("};\n");
		} else {
			context.append(";\n");
		}
	}

}
