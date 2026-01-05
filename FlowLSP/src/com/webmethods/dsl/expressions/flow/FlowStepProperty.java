package com.webmethods.dsl.expressions.flow;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;

public class FlowStepProperty extends FlowElementExpression {

	String key;
	String value;

	public FlowStepProperty(String key, String value) {
		super();
		this.key = key;
		this.value = value;
		if(value!=null && value.startsWith("\"") && value.endsWith("\"")) {
			this.value=value.substring(1, value.length()-1);
		}
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		return null;
	}

	@Override
	public void updateExpression(FlowElement element) {

	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendLine(key + ": " + value + ";");
	}
	
	public boolean hasValue() {
		return value!=null && !value.isBlank();
	}

	@Override
	public String getOutlineNodeName() {
		return key;
	}
}
