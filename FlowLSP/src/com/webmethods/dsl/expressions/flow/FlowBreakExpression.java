package com.webmethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.wm.lang.flow.FlowBreak;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;

public class FlowBreakExpression extends FlowElementExpression {
	List<FlowStepProperty> properties;

	public FlowBreakExpression() {
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
		FlowBreak flowBreak = new FlowBreak(null);
		addFlowProperties(flowBreak);
		return flowBreak;
	}


	@Override
	public void generateText(FlowTextContext context) {

		FlowStepProperty property = getProperty("comment");
		if(property==null || !property.hasValue()) {
			context.appendIndented("BREAK;");
			context.append("\n");
		}else {
			context.appendIndented("BREAK {");
			context.append("\n");
			context.increaseIndent();
			generateStepProperties(context);
			context.decreaseIndent();
			context.appendIndented("};");
			context.append("\n");
		}
	
	}
	
	@Override
	public String getOutlineNodeName() {
		return "BREAK";
	}

	@Override
	public void updateExpression(FlowElement element) {
	}
}
