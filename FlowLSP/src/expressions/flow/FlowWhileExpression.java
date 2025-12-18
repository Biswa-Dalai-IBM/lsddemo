package expressions.flow;

import java.util.List;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowWhile;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowWhileExpression extends FlowContainerExpression {
	
	private String condition;

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@Override
	public void addFlowElement(FlowElement parent) {
		
		
		FlowWhile flowWhile = new FlowWhile(null);
		flowWhile.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowWhile);
		parent.addNode(flowWhile);
	}
}
