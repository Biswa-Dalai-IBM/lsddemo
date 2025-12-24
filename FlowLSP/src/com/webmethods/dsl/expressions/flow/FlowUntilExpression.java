package com.webmethods.dsl.expressions.flow;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.flow.map.AbstractFlowMapExpression;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowExit;
import com.wm.lang.flow.FlowUntil;

public class FlowUntilExpression extends FlowElementExpression {
	String condition;
	public FlowUntilExpression() {
		super();
	}

	@Override
	public FlowElement getFlowElement() {
		return new FlowExit(null);
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowUntil flowUntil = (FlowUntil)element;
		condition = flowUntil.getCondition();
		condition = AbstractFlowMapExpression.calculatePath(condition);
		condition=condition.replaceAll("%", "");
	}

	@Override
	public void generateText(FlowTextContext context) {
		// TODO Auto-generated method stub
	}
	
	public String getCondition() {
		return condition;
	}
}
