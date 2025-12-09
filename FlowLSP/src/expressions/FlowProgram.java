package expressions;

import java.util.ArrayList;
import java.util.List;

import expressions.flow.FlowStepProperty;

public class FlowProgram extends FlowElementExpression{

	List<FlowStepProperty> properties;
	List<FlowElementExpression> expressions;

	public String serviceName;
	public FlowProgram() {
		properties = new ArrayList<FlowStepProperty>();
		expressions = new ArrayList<FlowElementExpression>();
	}

	public void addChild(FlowElementExpression expression) {
		expressions.add(expression);
	}
	
	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public void setLabel(String serviceName) {
		this.serviceName=serviceName;
	}
	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}
}
