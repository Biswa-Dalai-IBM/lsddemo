package com.webmethods.dsl.expressions.flow.map;

import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.VariableResolver;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapCopy;
import com.wm.lang.ns.Namespace;

/**
 * Represents a MAP COPY operation (from -> to)
 */
public class FlowMapCopyExpression extends FlowMapExpression {

	private String from;
	private String to;
	private VariableResolver variableResolver;

	public FlowMapCopyExpression(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public FlowMapCopyExpression(String from, String to, VariableResolver variableResolver) {
		super();
		this.from = from;
		this.to = to;
		this.variableResolver = variableResolver;
	}

	public void setVariableResolver(VariableResolver variableResolver) {
		this.variableResolver = variableResolver;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		FlowMapCopy mapCopy = new FlowMapCopy(null);
		mapCopy.setMapFrom(NSFieldPathBuilder.buildNSFieldPath(namespace,from, variableResolver));
		mapCopy.setMapTo(NSFieldPathBuilder.buildNSFieldPath(namespace,to, variableResolver));
		return mapCopy;
	}

	@Override
	public void generateText(FlowTextContext context) {
		context.appendLine("copy " + from + " -> " + to + ";");
	}

	@Override
	public String getOutlineNodeName() {
		return "COPY";
	}
}
