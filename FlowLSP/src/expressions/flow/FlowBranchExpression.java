package expressions.flow;

import java.util.List;

import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowBranch;
import com.wm.lang.flow.FlowElement;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowBranchExpression extends FlowContainerExpression {

	@Override
	public void addFlowElement(FlowElement parent) {
		IData iData = IDataFactory.create();

		FlowStepProperty property = getProperty(FlowBranch.KEY_BRANCH_SWITCH);
		if(property!=null) {
			IDataUtil.put(iData.getCursor(), FlowBranch.KEY_BRANCH_SWITCH, property.value);
		}

		FlowBranch flowSequence = new FlowBranch(iData);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}
}
