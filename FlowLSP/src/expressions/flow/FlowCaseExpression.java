package expressions.flow;

import java.util.List;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowCaseExpression extends FlowContainerExpression {

	private String caseValue;
	
	public void setCaseValue(String caseValue) {
		this.caseValue = caseValue;
	}
	
	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setCaseValue(caseValue);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}
}
