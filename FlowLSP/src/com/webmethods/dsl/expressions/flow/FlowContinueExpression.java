package com.webmethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.wm.lang.flow.FlowContinue;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;

public class FlowContinueExpression extends FlowElementExpression {
	List<FlowStepProperty> properties;

	public FlowContinueExpression() {
		properties = new ArrayList<FlowStepProperty>();
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}

	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		FlowContinue flowContinue = new FlowContinue(null);
		addFlowProperties(flowContinue);
		return flowContinue;
	}

	@Override
	public void updateExpression(FlowElement element) {

	}

	@Override
	public void generateText(FlowTextContext context) {
		FlowStepProperty property = getProperty("comment");
		if(property==null || !property.hasValue()) {
			context.appendIndented("CONTINUE;");
			context.append("\n");
		}else {
			context.appendIndented("CONTINUE {");
			context.append("\n");
			context.increaseIndent();
			generateStepProperties(context);
			context.decreaseIndent();
			context.appendIndented("};");
			context.append("\n");
		}}

	@Override
	public String getOutlineNodeName() {
		return "CONTINUE";
	}
}
