package com.webmethods.dsl.expressions.flow.map;

import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.VariableResolver;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapDelete;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.Namespace;

public class FlowMapDropExpression extends FlowMapExpression {

	private String fieldName;
	private VariableResolver variableResolver;
	public FlowMapDropExpression(String fieldName) {
		super();
		this.fieldName = fieldName;
	}
	
	public FlowMapDropExpression(String fieldName,VariableResolver variableResolver) {
		super();
		this.fieldName = fieldName;
		this.variableResolver = variableResolver;
	}

	public String getFieldName() {
		return fieldName;
	}

	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		FlowMapDelete mapDelete = new FlowMapDelete(null);
		NSField nsField = NSFieldPathBuilder.buildNSField(namespace,fieldName, variableResolver);
		mapDelete.setField(fieldName, nsField.getType(), nsField.getDimensions());
		return mapDelete;
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendLine("drop " + fieldName + ";");
	}
	
	@Override
	public String getOutlineNodeName() {
		return "DROP";
	}
}
