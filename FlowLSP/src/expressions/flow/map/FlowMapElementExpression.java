package expressions.flow.map;

import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;
import expressions.flow.FlowStepProperty;

public class FlowMapElementExpression extends FlowElementExpression {
	List<FlowElementExpression> expressions;
	List<FlowStepProperty> properties;
	public FlowMapElementExpression() {
		expressions = new ArrayList<FlowElementExpression>();
		properties = new ArrayList<FlowStepProperty>();
	}

	public void addMapExpression(FlowMapExpression expression){
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
	
	
}
