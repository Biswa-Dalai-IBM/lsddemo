package expressions;

import java.util.Stack;

/**
 * Manages the variable scope stack during flow service traversal.
 * Maintains current scope and provides methods to enter/exit scopes.
 */
public class ScopeManager {
	
	private Stack<VariableScope> scopeStack;
	private VariableScope rootScope;
	
	public ScopeManager() {
		this.scopeStack = new Stack<>();
		this.rootScope = new VariableScope("root");
		this.scopeStack.push(rootScope);
	}
	
	/**
	 * Initialize with service signature (input/output parameters)
	 */
	public void initializeWithSignature(FlowServiceSignature signature) {
		if (signature != null) {
			// Add input parameters to root scope
			if (signature.hasInputParameters()) {
				rootScope.addVariables(signature.getInputParameters());
			}
			
			// Add output parameters to root scope
			if (signature.hasOutputParameters()) {
				rootScope.addVariables(signature.getOutputParameters());
			}
		}
	}
	
	/**
	 * Get the current scope
	 */
	public VariableScope getCurrentScope() {
		return scopeStack.peek();
	}
	
	/**
	 * Get the root scope
	 */
	public VariableScope getRootScope() {
		return rootScope;
	}
	
	/**
	 * Enter a new scope (push onto stack)
	 */
	public VariableScope enterScope(String scopeName) {
		VariableScope newScope = getCurrentScope().createChildScope(scopeName);
		scopeStack.push(newScope);
		return newScope;
	}
	
	/**
	 * Exit current scope (pop from stack)
	 */
	public VariableScope exitScope() {
		if (scopeStack.size() > 1) { // Keep root scope
			return scopeStack.pop();
		}
		return null;
	}
	
	/**
	 * Add a variable to the current scope
	 */
	public void addVariable(ParameterDeclaration param) {
		getCurrentScope().addVariable(param);
	}
	
	/**
	 * Add multiple variables to the current scope
	 */
	public void addVariables(java.util.List<ParameterDeclaration> params) {
		getCurrentScope().addVariables(params);
	}
	
	/**
	 * Look up a variable in current scope and parent scopes
	 */
	public ParameterDeclaration lookupVariable(String name) {
		return getCurrentScope().lookupVariable(name);
	}
	
	/**
	 * Look up a variable path (e.g., "record1/field1")
	 */
	public ParameterDeclaration lookupVariablePath(String path) {
		return getCurrentScope().lookupVariablePath(path);
	}
	
	/**
	 * Check if a variable exists
	 */
	public boolean hasVariable(String name) {
		return getCurrentScope().hasVariable(name);
	}
	
	/**
	 * Get current scope depth
	 */
	public int getScopeDepth() {
		return scopeStack.size();
	}
	
	/**
	 * Reset to root scope
	 */
	public void reset() {
		scopeStack.clear();
		scopeStack.push(rootScope);
	}
	
	@Override
	public String toString() {
		return "ScopeManager[depth=" + getScopeDepth() + ", current=" + getCurrentScope() + "]";
	}
}

// Made with Bob
