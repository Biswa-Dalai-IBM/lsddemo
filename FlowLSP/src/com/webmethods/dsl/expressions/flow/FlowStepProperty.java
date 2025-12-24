package com.webmethods.dsl.expressions.flow;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.wm.lang.flow.FlowElement;

public class FlowStepProperty extends FlowElementExpression {

	String key;
	String value;

	public FlowStepProperty(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public FlowElement getFlowElement() {
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

}
