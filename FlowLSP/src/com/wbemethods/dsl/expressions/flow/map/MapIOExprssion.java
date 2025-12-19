package com.wbemethods.dsl.expressions.flow.map;

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

}
