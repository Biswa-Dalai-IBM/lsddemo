package com.webmethods.dsl.expressions.flow.map;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;

public class MapIOExprssion extends AbstractFlowMapExpression {

	boolean isInput;

	public MapIOExprssion() {
		super();
		isInput = false;
	}

	public boolean isInput() {
		return isInput;
	}

	public void setInput(boolean isInput) {
		this.isInput = isInput;
	}

	@Override
	public void generateText(FlowTextContext context) {
		if (hasMapSignature()) {
			getMapSignature().generateText(context);
		}

		if (hasExpressions()) {
			for (FlowElementExpression expr : getMapExpressions()) {
				expr.generateText(context);
			}
		}
	}

}
