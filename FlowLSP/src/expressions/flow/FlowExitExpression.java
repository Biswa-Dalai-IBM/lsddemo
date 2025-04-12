package expressions.flow;

import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;

public class FlowExitExpression extends FlowElementExpression {
	List<FlowStepProperty> properties;
	
	public FlowExitExpression() {
		properties=new ArrayList<FlowStepProperty>();
	}
	
	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

}
