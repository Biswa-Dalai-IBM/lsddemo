package expressions.flow;

import java.util.List;

import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSwitch;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowSwitchExpression extends FlowContainerExpression {

	private String switchKey;
	
	public void setSwitchKey(String switchKey) {
		this.switchKey = switchKey;
	}
	
	@Override
	public void addFlowElement(FlowElement parent) {
		IData iData = IDataFactory.create();
		IDataUtil.put(iData.getCursor(), FlowSwitch.KEY_SWITCH_KEY, switchKey);
		FlowSwitch flowSequence = new FlowSwitch(iData);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(expressions, flowSequence);
		parent.addNode(flowSequence);
	}
}
