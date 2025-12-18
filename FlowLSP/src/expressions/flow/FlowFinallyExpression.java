package expressions.flow;

import java.util.List;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSequence;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowFinallyExpression extends FlowContainerExpression {

	@Override
	public void addFlowElement(FlowElement parent) {
		FlowSequence flowSequence = new FlowSequence(null);
		flowSequence.setForm(FlowSequence.FINALLY);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}
}
