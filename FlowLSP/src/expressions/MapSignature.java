package expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the mapSource/mapTarget signature in a MAP step
 */
public class MapSignature implements IFlowExpression {
	
	private List<ParameterDeclaration> sourceParameters;
	private List<ParameterDeclaration> targetParameters;
	private String sourceIdentifier;  // e.g., "pipeline"
	private String targetIdentifier;  // e.g., "addIntsInput"
	
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
}

// Made with Bob
