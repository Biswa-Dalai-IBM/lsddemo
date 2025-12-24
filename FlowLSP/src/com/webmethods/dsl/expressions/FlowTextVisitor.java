package com.webmethods.dsl.expressions;

/**
 * Visitor interface for generating flow text from expressions. Each expression
 * implements this to generate its own text representation.
 */
public interface FlowTextVisitor {

	/**
	 * Generate flow text for this expression
	 * 
	 * @param context The text generation context
	 */
	void generateText(FlowTextContext context);
}

// Made with Bob
