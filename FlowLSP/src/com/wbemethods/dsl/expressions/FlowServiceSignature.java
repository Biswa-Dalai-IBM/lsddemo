package com.wbemethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSSignature;

/**
 * Represents the signature (input/output) of a Flow service
 */
public class FlowServiceSignature implements IFlowExpression {

	private List<ParameterDeclaration> inputParameters;
	private List<ParameterDeclaration> outputParameters;

	public FlowServiceSignature() {
		this.inputParameters = new ArrayList<>();
		this.outputParameters = new ArrayList<>();
	}

	public void addInputParameter(ParameterDeclaration param) {
		inputParameters.add(param);
	}

	public void addOutputParameter(ParameterDeclaration param) {
		outputParameters.add(param);
	}

	public List<ParameterDeclaration> getInputParameters() {
		return inputParameters;
	}

	public List<ParameterDeclaration> getOutputParameters() {
		return outputParameters;
	}

	public boolean hasInputParameters() {
		return inputParameters != null && !inputParameters.isEmpty();
	}

	public boolean hasOutputParameters() {
		return outputParameters != null && !outputParameters.isEmpty();
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

	@Override
	public void generateText(FlowTextContext context) {
		if (hasInputParameters()) {
			context.appendLine("input {");
			context.increaseIndent();
			for (ParameterDeclaration param : getInputParameters()) {
				param.generateText(context);
			}
			context.decreaseIndent();
			context.appendLine("}");
		}

		if (hasOutputParameters()) {
			context.appendLine("output {");
			context.increaseIndent();
			for (ParameterDeclaration param : getOutputParameters()) {
				param.generateText(context);
			}
			context.decreaseIndent();
			context.appendLine("}");
		}
	}

}

// Made with Bob
