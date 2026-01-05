package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSwitch;
import com.wm.lang.ns.Namespace;

public class FlowSwitchExpression extends FlowContainerExpression {

	private String switchKey;

	public void setSwitchKey(String switchKey) {
		this.switchKey = switchKey;
	}

	public String getSwitchKey() {
		return switchKey;
	}

	@Override
	public void addFlowElement(Namespace namespace,FlowElement parent) {
		IData iData = IDataFactory.create();
		IDataUtil.put(iData.getCursor(), FlowSwitch.KEY_SWITCH_KEY, switchKey);
		FlowSwitch flowSequence = new FlowSwitch(iData);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowSequence);
		flowSequence.setParent(parent);
		parent.addNode(flowSequence);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowSwitch flowSwitch = (FlowSwitch) element;
		switchKey = flowSwitch.getSwitchKey();
		super.updateExpression(element);
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("SWITCH(" + switchKey + ") {");
		context.append("\n");
		context.increaseIndent();

		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("};\n");
	}
	
	@Override
	public String getOutlineNodeName() {
		return "SWITCH(" + switchKey + ")";
	}
}
