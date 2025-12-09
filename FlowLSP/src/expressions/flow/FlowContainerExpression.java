package expressions.flow;

import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;

public class FlowContainerExpression extends FlowElementExpression {
	
	List<FlowStepProperty> properties;
	List<FlowElementExpression> expressions;
	
	public FlowContainerExpression() {
		properties = new ArrayList<FlowStepProperty>();
		expressions = new ArrayList<FlowElementExpression>();
	}

	public void addChild(FlowElementExpression expression) {
		expressions.add(expression);
	}
	
	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}
	
	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}
	
	public boolean hasExpressions() {
		return expressions != null && !expressions.isEmpty();
	}
	
	public boolean hasProperties() {
		return properties != null && !properties.isEmpty();
	}
	
	public FlowStepProperty getProperty(String key) {
		if (properties == null) return null;
		return properties.stream()
				.filter(p -> p.getKey().equals(key))
				.findFirst()
				.orElse(null);
	}
	
	public String getPropertyValue(String key) {
		FlowStepProperty prop = getProperty(key);
		return prop != null ? prop.getValue() : null;
	}
}
