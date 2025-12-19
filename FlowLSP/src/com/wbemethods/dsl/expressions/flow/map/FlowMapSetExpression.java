package com.wbemethods.dsl.expressions.flow.map;

import com.wbemethods.dsl.expressions.VariableResolver;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapSet;

/**
 * Represents a MAP SET operation (field = value)
 */
public class FlowMapSetExpression extends FlowMapExpression {

	private String fieldPath;
	private String value;
	private VariableResolver variableResolver;

	public FlowMapSetExpression(String fieldPath, String value) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
	}

	public FlowMapSetExpression(String fieldPath, String value, VariableResolver variableResolver) {
		super();
		this.fieldPath = fieldPath;
		this.value = value;
		this.variableResolver = variableResolver;
	}

	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}

	public String getFieldPath() {
		return fieldPath;
	}

	public String getValue() {
		return value;
	}

	@Override
	public FlowElement getFlowElement() {
		FlowMapSet setData = new FlowMapSet(null);
		setData.setField(NSFieldPathBuilder.buildNSFieldPath(fieldPath, variableResolver));
		setData.setVariables(false);
		setData.setOverwrite(true);
		setData.setGlobalVariables(false);
		setData.setName("Setter");
		setData.setInputType(NSFieldPathBuilder.buildNSField(fieldPath, variableResolver));

		IData data = IDataFactory.create();
		IDataUtil.put(data.getCursor(), "xml", value);
		setData.setInput(value);
		return setData;
	}
}
