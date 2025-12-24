package com.webmethods.dsl.expressions;

/**
 * Base interface for all flow expressions. Implements Visitor pattern for text
 * generation.
 */
public interface IFlowExpression extends FlowTextVisitor {

	/**
	 * Generate flow text for this expression
	 * 
	 * @param context The text generation context
	 */
	@Override
	void generateText(FlowTextContext context);
}
