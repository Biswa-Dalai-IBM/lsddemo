package com.webmethods.dsl.expressions;

import java.util.List;

import org.antlr.v4.runtime.Token;

import com.webmethods.dsl.expressions.flow.IONode;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSSignature;

/**
 * Represents the signature (input/output) of a Flow service
 */
public class FlowServiceSignature implements IFlowExpression {
	
	private IONode input;
	private IONode output;
	
	private int line;
	private int column;

	public FlowServiceSignature() {
		this.input = new IONode("input");
		this.output = new IONode("output");
	}

	public void addInputParameter(ParameterDeclaration param) {
		input.addParameter(param);
	}

	public void addOutputParameter(ParameterDeclaration param) {
		output.addParameter(param);
	}

	public List<ParameterDeclaration> getInputParameters() {
		return input.getValue();
	}

	public List<ParameterDeclaration> getOutputParameters() {
		return output.getValue();
	}

	public boolean hasInputParameters() {
		return input.hasParameters();
	}

	public boolean hasOutputParameters() {
		return output.hasParameters();
	}

	public void updateSignature(NSSignature signature) {
		NSRecord inputRecord = signature.getInput();
		if (inputRecord != null && inputRecord.getFieldCount() > 0) {
			ParameterDeclaration declaration = new ParameterDeclaration();
			List<ParameterDeclaration> inputParams = declaration.loadChildren(inputRecord);
			for (ParameterDeclaration param : inputParams) {
				addInputParameter(param);
			}
		}

		// Convert output record
		NSRecord outputRecord = signature.getOutput();
		if (outputRecord != null && outputRecord.getFieldCount() > 0) {
			ParameterDeclaration declaration = new ParameterDeclaration();
			List<ParameterDeclaration> outputParams = declaration.loadChildren(outputRecord);
			for (ParameterDeclaration param : outputParams) {
				addOutputParameter(param);
			}
		}
	}

	public IONode getInput() {
		return input;
	}
	
	public IONode getOutput() {
		return output;
	}
	
	@Override
	public void generateText(FlowTextContext context) {
		input.generateText(context);
		output.generateText(context);
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getCharPositionInLine() {
		return column;
	}
	
	@Override
	public void setLocation(Token token) {
		if(token==null) {
			return;
		}
		this.line=token.getLine();
		this.column=token.getCharPositionInLine();
	}
	
	@Override
	public String getOutlineNodeName() {
		return "Signature";
	}
}

// Made with Bob
