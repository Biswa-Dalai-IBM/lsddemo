package com.wbemethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import com.wbemethods.dsl.expressions.flow.FlowStepProperty;
import com.wm.lang.flow.FlowElement;

public class FlowProgram extends FlowElementExpression {

	List<FlowStepProperty> properties;
	List<FlowElementExpression> expressions;
	FlowServiceSignature signature;
	ScopeManager scopeManager;

	public String serviceName;

	public FlowProgram() {
		properties = new ArrayList<FlowStepProperty>();
		expressions = new ArrayList<FlowElementExpression>();
	}

	public void addChild(FlowElementExpression expression) {
		expressions.add(expression);
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public void setLabel(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}

	public void setSignature(FlowServiceSignature signature) {
		this.signature = signature;
	}

	public FlowServiceSignature getSignature() {
		return signature;
	}

	public boolean hasSignature() {
		return signature != null;
	}

	public void setScopeManager(ScopeManager scopeManager) {
		this.scopeManager = scopeManager;
	}

	public ScopeManager getScopeManager() {
		return scopeManager;
	}

	public boolean hasScopeManager() {
		return scopeManager != null;
	}

	@Override
	public FlowElement getFlowElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateExpression(FlowElement element) {
		FlowElement[] children = element.getNodes();
		if (children != null) {
			for (FlowElement child : children) {
				FlowElementExpression expr = convertFlowElement(child);
				if (expr != null) {
					addChild(expr);
				}
			}
		}
	}

}
