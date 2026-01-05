package com.webmethods.dsl.expressions.flow;

import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.app.FlowGenerator;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowRetry;
import com.wm.lang.ns.Namespace;
import com.wm.util.Values;

public class FlowRepeatExpression extends FlowContainerExpression {
	private String count;
	private String repeatInterval;
	private String repeatOn;
	
	@Override
	public void addFlowElement(Namespace namespace, FlowElement parent) {
		FlowRetry flowRetry = new FlowRetry(null);
		List<FlowElementExpression> expressions = getExpressions();
		FlowGenerator.generateFlow(namespace,expressions, flowRetry);
		
		FlowStepProperty property = getProperty("count");
		if (property != null && property.hasValue()) {
			count = property.getValue();
			flowRetry.setCountString(count);
		}
		
		property = getProperty("repeatInterval");
		if (property != null && property.hasValue()) {
			repeatInterval = property.getValue();
			flowRetry.setBackoffString(repeatInterval);
		}
		
		property = getProperty("repeatOn");
		if (property != null && property.hasValue()) {
			repeatOn = property.getValue();
			flowRetry.setReapeatOn(repeatOn);
		}
		
		addFlowProperties(flowRetry);
		
		flowRetry.setParent(parent);
		parent.addNode(flowRetry);
	}
	
	@Override
	public String getOutlineNodeName() {
		return "REPEAT";
	}
	
	@Override
	public void updateExpression(FlowElement element) {
		super.updateExpression(element);
	}
	@Override
	public void updateStepProperties(FlowElement element) {
		super.updateStepProperties(element);
		if (element != null && element instanceof FlowElement ) {
			Values properties = ((FlowElement)element).getValues();
			count = properties.getString(FlowRetry.KEY_RETRY_MAXCOUNT);
			repeatInterval = properties.getString(FlowRetry.KEY_RETRY_BACKOFF);
			repeatOn = properties.getString(FlowRetry.KEY_RETRY_LOOPON);
		}
	}
	@Override
	public void generateText(FlowTextContext context) {

		context.appendIndented("REPEAT {");
		context.append("\n");
		context.increaseIndent();
		
		generateStepProperties(context);

		if(count!=null && !count.isBlank()) {
			context.appendIndented("count: " + count + ";");
			context.append("\n");
		}
		
		if(repeatInterval!=null && !repeatInterval.isBlank()) {
			context.appendIndented("repeatInterval: " + repeatInterval + ";");
			context.append("\n");
		}
		
		
		if(repeatOn!=null && !repeatOn.isBlank() && !repeatOn.equals(FlowRetry.LOOPON_OPTIONS[0])) {
			context.appendIndented("repeatOn: \"" + repeatOn + "\";");
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
