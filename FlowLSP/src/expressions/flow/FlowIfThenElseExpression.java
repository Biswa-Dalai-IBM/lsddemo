package expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowIfThenElseExpression extends FlowContainerExpression {
	private String condition;
	
	private List<FlowElseIfExpression> elseIfExpressions;
	private FlowElseExpression elseExpression;
	
	public FlowIfThenElseExpression() {
		elseIfExpressions = new ArrayList<FlowElseIfExpression>();
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.IF);
		flowSequence.setCondition(condition);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
		
		for (FlowElseIfExpression elseIfExpression : elseIfExpressions) {
			elseIfExpression.addFlowElement(parent);
		}
		
		elseExpression.addFlowElement(parent);
		
	}
	
	public void addElseIfExpressions(FlowElseIfExpression expression){
		elseIfExpressions.add(expression);
	}
	
	public void setElseExpression(FlowElseExpression elseExpression) {
		this.elseExpression = elseExpression;
	}
}
