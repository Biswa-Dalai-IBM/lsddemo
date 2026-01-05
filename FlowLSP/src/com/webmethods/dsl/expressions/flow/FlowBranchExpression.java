package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowBranch;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;
import com.wm.util.Values;

public class FlowBranchExpression extends FlowContainerExpression {

	private String branchSwitch;
	private String evaluateLabels;

	@Override
	public void addFlowElement(Namespace namespace,FlowElement parent) {
		IData iData = IDataFactory.create();

		FlowStepProperty property = getProperty(FlowBranch.KEY_BRANCH_SWITCH);
		if (property != null) {
			IDataUtil.put(iData.getCursor(), FlowBranch.KEY_BRANCH_SWITCH, property.value);
		}
		
		FlowStepProperty property1 = getProperty("evaluateLabels");
		if (property1 != null) {
			IDataUtil.put(iData.getCursor(), FlowBranch.KEY_ELEMENT_CONDITION, property1.value);
		}
		

		FlowBranch flowBranch = new FlowBranch(iData);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowBranch);
		addFlowProperties(flowBranch);
		flowBranch.setParent(parent);
		parent.addNode(flowBranch);
	}

	@Override
	protected FlowElementExpression convertFlowElement(FlowElement element) {

		return super.convertFlowElement(element);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowBranch flowBranch = (FlowBranch) element;
		branchSwitch = flowBranch.getBranchSwitch();
		Values properties = flowBranch.getValues();

		evaluateLabels = properties
				.getString(FlowElement.KEY_ELEMENT_CONDITION);
		if (evaluateLabels == null || evaluateLabels.trim().length() < 0){
			evaluateLabels = Boolean.FALSE.toString();
		}
		super.updateExpression(element);
	}

	@Override
	public String getOutlineNodeName() {
		return "BRANCH";
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendIndented("BRANCH {");
		context.append("\n");
		context.increaseIndent();

		generateStepProperties(context);
		
		if(branchSwitch!=null && !branchSwitch.isBlank()) {
			context.appendIndented("switch: \"" + branchSwitch + "\";");
			context.append("\n");
		}
		if(evaluateLabels!=null && !evaluateLabels.isBlank() && !evaluateLabels.equals(Boolean.FALSE.toString())) {
			context.appendIndented("evaluateLabels: " + evaluateLabels + ";");
			context.append("\n");
		}

		

		// Generate child steps
		for (FlowElementExpression child : getExpressions()) {
			child.generateText(context);
		}

		context.decreaseIndent();
		context.appendIndented("};");
		context.append("\n");
	}
}
