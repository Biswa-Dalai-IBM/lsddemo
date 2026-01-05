package com.webmethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.flow.FlowContainerExpression;
import com.webmethods.dsl.expressions.flow.FlowStepProperty;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;

public class FlowProgram extends FlowContainerExpression{

	List<FlowStepProperty> properties;
	FlowServiceSignature signature;
	ScopeManager scopeManager;

	public String serviceName;
	public String interfaceName;

	public FlowProgram() {
		super();
		properties = new ArrayList<FlowStepProperty>();
	}


	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public void setLabel(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
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
	public FlowElement getFlowElement(Namespace namespace) {
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
	
	@Override
	public String getOutlineNodeName() {
		return serviceName;
	}
	/**
	 * Generate flow text for the entire service
	 */
	@Override
	public void generateText(FlowTextContext context) {
		if(interfaceName!=null && !interfaceName.isEmpty()) {
			context.appendLine("interface " + interfaceName + ";");
		}
		// Generate service declaration
		String name = serviceName != null ? serviceName : "generatedService";
		context.append("service " + name);
		
		// Generate signature if present
		if (hasSignature()) {
			context.append(" (");
			context.appendLine("");
			context.increaseIndent();
			signature.generateText(context);
			context.decreaseIndent();
			context.append(")");
		}
		
		context.appendLine(" {");
		context.increaseIndent();
		
		// Generate flow steps - each expression generates itself
		List<FlowElementExpression> expressions = getExpressions();
		if (expressions != null && !expressions.isEmpty()) {
			for (FlowElementExpression expr : expressions) {
				expr.generateText(context);
			}
		}
		
		context.decreaseIndent();
		context.appendLine("}");
	}
	
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	
	public String getInterfaceName() {
		return interfaceName;
	}
}
