package expressions.map;

import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;

public class FlowMapElementExpression extends FlowElementExpression {
	List<FlowMapExpression> expressions;

	public FlowMapElementExpression() {
		expressions = new ArrayList<FlowMapExpression>();
	}

	public void addMapExpression(FlowMapExpression expression){
		expressions.add(expression);
	}
}
