package com.webmethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import com.webmethods.dsl.expressions.flow.IONode;
import com.wm.lang.ns.NSRecord;

/**
 * Represents the mapSource/mapTarget signature in a MAP step
 */
public class MapSignature implements IFlowExpression {

	private List<ParameterDeclaration> sourceParameters;
	private List<ParameterDeclaration> targetParameters;
	private String sourceIdentifier; // e.g., "pipeline"
	private String targetIdentifier; // e.g., "addIntsInput"
	private int line;
	private int column;

	public MapSignature() {
		this.sourceParameters = new ArrayList<>();
		this.targetParameters = new ArrayList<>();
	}

	public void addSourceParameter(ParameterDeclaration param) {
		sourceParameters.add(param);
	}

	public void addTargetParameter(ParameterDeclaration param) {
		targetParameters.add(param);
	}

	public List<ParameterDeclaration> getSourceParameters() {
		return sourceParameters;
	}

	public List<ParameterDeclaration> getTargetParameters() {
		return targetParameters;
	}
	
	public IONode getSourceNode(){
		return new IONode("mapSource", sourceParameters);
	}
	
	public IONode getTargetNode(){
		return new IONode("mapTarget", targetParameters);
	}

	public boolean hasSourceParameters() {
		return sourceParameters != null && !sourceParameters.isEmpty();
	}

	public boolean hasTargetParameters() {
		return targetParameters != null && !targetParameters.isEmpty();
	}

	public String getSourceIdentifier() {
		return sourceIdentifier;
	}

	public void setSourceIdentifier(String sourceIdentifier) {
		this.sourceIdentifier = sourceIdentifier;
	}

	public String getTargetIdentifier() {
		return targetIdentifier;
	}

	public void setTargetIdentifier(String targetIdentifier) {
		this.targetIdentifier = targetIdentifier;
	}

	public void updateSignature(NSRecord sourceRecord, NSRecord targetRecord) {
		if (sourceRecord != null && sourceRecord.getFieldCount() > 0) {
			sourceIdentifier=sourceRecord.getName();
			ParameterDeclaration declaration = new ParameterDeclaration();
			List<ParameterDeclaration> inputParams = declaration.loadChildren(sourceRecord);
			for (ParameterDeclaration param : inputParams) {
				addSourceParameter(param);
			}
		}

		if (targetRecord != null && targetRecord.getFieldCount() > 0) {
			targetIdentifier=targetRecord.getName();
			ParameterDeclaration declaration = new ParameterDeclaration();
			List<ParameterDeclaration> outputParams = declaration.loadChildren(targetRecord);
			for (ParameterDeclaration param : outputParams) {
				addTargetParameter(param);
			}
		}
	}
	
	@Override
	public void generateText(FlowTextContext context) {
		if (hasSourceParameters()) {
			context.appendIndented("mapSource");
			if (sourceIdentifier != null && !sourceIdentifier.isEmpty()) {
				context.append("[" + sourceIdentifier + "]");
			}
			context.append(" {\n");
			context.increaseIndent();
			for (ParameterDeclaration param : getSourceParameters()) {
				param.generateText(context);
			}
			context.decreaseIndent();
			context.appendIndented("}\n");
		}

		if (hasTargetParameters()) {
			context.appendIndented("mapTarget");
			if (targetIdentifier != null && !targetIdentifier.isEmpty()) {
				context.append("[" + targetIdentifier + "]");
			}
			context.append(" {\n");
			context.increaseIndent();
			for (ParameterDeclaration param : getTargetParameters()) {
				param.generateText(context);
			}
			context.decreaseIndent();
			context.appendIndented("}\n");
		}
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
		return null;
	}
}

// Made with Bob
