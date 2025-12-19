package com.wbemethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wm.lang.flow.FlowElement;

/**
 * Base class for flow expressions that can contain child expressions. Inherits
 * property handling from FlowElementExpression.
 */
public class FlowContainerExpression extends FlowElementExpression {

	private List<FlowElementExpression> expressions;

	public FlowContainerExpression() {
		super(); // Initialize parent's properties list
		expressions = new ArrayList<FlowElementExpression>();
	}

	public void addChild(FlowElementExpression expression) {
		if (expression instanceof FlowElseIfExpression) {
			FlowElementExpression last = expressions.get(expressions.size() - 1);
			if (last instanceof FlowIfThenElseExpression) {
				FlowIfThenElseExpression flowIfThenElseExpression = (FlowIfThenElseExpression) last;
				flowIfThenElseExpression.addElseIfExpressions((FlowElseIfExpression) expression);
			}
		}
		if (expression instanceof FlowElseExpression) {
			FlowElementExpression last = expressions.get(expressions.size() - 1);
			if (last instanceof FlowIfThenElseExpression) {
				FlowIfThenElseExpression flowIfThenElseExpression = (FlowIfThenElseExpression) last;
				flowIfThenElseExpression.setElseExpression((FlowElseExpression) expression);
			}
		}

		if (expression instanceof FlowCatchExpression) {
			FlowElementExpression last = expressions.get(expressions.size() - 1);
			if (last instanceof FlowTryExpression) {
				FlowTryExpression tryExpression = (FlowTryExpression) last;
				tryExpression.addCatchExpressions((FlowCatchExpression) expression);
			}
		}

		if (expression instanceof FlowFinallyExpression) {
			FlowElementExpression last = expressions.get(expressions.size() - 1);
			if (last instanceof FlowTryExpression) {
				FlowTryExpression tryExpression = (FlowTryExpression) last;
				tryExpression.setFinallyExpression((FlowFinallyExpression) expression);
			}
		}
		expressions.add(expression);
	}

	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}

	public boolean hasExpressions() {
		return expressions != null && !expressions.isEmpty();
	}

	/**
	 * Get a property by key (inherited from FlowElementExpression)
	 */
	public FlowStepProperty getProperty(String key) {
		List<FlowStepProperty> props = getProperties();
		if (props == null)
			return null;
		return props.stream().filter(p -> p.getKey().equals(key)).findFirst().orElse(null);
	}

	/**
	 * Get property value by key (inherited from FlowElementExpression)
	 */
	public String getPropertyValue(String key) {
		FlowStepProperty prop = getProperty(key);
		return prop != null ? prop.getValue() : null;
	}

	@Override
	public FlowElement getFlowElement() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFlowElement(FlowElement parent) {

	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowElement[] nodes = element.getNodes();
		for (FlowElement flowElement : nodes) {
			FlowElementExpression expression = convertFlowElement(flowElement);
			if (expression != null) {
				addChild(expression);
			}
		}
	}
}
