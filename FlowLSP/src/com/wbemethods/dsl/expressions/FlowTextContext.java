package com.wbemethods.dsl.expressions;

/**
 * Context for flow text generation. Provides methods for formatting and
 * indentation.
 */
public class FlowTextContext {

	private StringBuilder output;
	private int indentLevel;
	private static final String INDENT = "    ";

	public FlowTextContext() {
		this.output = new StringBuilder();
		this.indentLevel = 0;
	}

	/**
	 * Append text without newline or indentation
	 */
	public void append(String text) {
		output.append(text);
	}

	/**
	 * Append line with proper indentation
	 */
	public void appendLine(String line) {
		for (int i = 0; i < indentLevel; i++) {
			output.append(INDENT);
		}
		output.append(line).append("\n");
	}

	/**
	 * Append text with current indentation (no newline)
	 */
	public void appendIndented(String text) {
		for (int i = 0; i < indentLevel; i++) {
			output.append(INDENT);
		}
		output.append(text);
	}

	/**
	 * Increase indentation level
	 */
	public void increaseIndent() {
		indentLevel++;
	}

	/**
	 * Decrease indentation level
	 */
	public void decreaseIndent() {
		if (indentLevel > 0) {
			indentLevel--;
		}
	}

	/**
	 * Get current indentation level
	 */
	public int getIndentLevel() {
		return indentLevel;
	}

	/**
	 * Set indentation level
	 */
	public void setIndentLevel(int level) {
		this.indentLevel = Math.max(0, level);
	}

	/**
	 * Get the generated text
	 */
	public String getText() {
		return output.toString();
	}

	/**
	 * Clear the output
	 */
	public void clear() {
		output = new StringBuilder();
		indentLevel = 0;
	}
}

// Made with Bob
