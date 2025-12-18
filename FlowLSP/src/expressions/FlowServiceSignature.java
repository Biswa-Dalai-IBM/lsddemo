package expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the signature (input/output) of a Flow service
 */
public class FlowServiceSignature implements IFlowExpression{
	
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
}

// Made with Bob
