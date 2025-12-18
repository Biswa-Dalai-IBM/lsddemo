package expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages variable scope hierarchy for Flow services.
 * Tracks variables from service signatures and map blocks with their types.
 * Supports nested scopes (outer/inner) for proper variable resolution.
 */
public class VariableScope {
	
	private VariableScope parent; // Parent scope (outer scope)
	private Map<String, ParameterDeclaration> variables; // Variables in this scope
	private String scopeName; // For debugging/identification
	
	public VariableScope(String scopeName) {
		this(scopeName, null);
	}
	
	public VariableScope(String scopeName, VariableScope parent) {
		this.scopeName = scopeName;
		this.parent = parent;
		this.variables = new HashMap<>();
	}
	
	/**
	 * Add a variable to this scope
	 */
	public void addVariable(ParameterDeclaration param) {
		if (param != null && param.getName() != null) {
			variables.put(param.getName(), param);
		}
	}
	
	/**
	 * Add multiple variables from a list
	 */
	public void addVariables(List<ParameterDeclaration> params) {
		if (params != null) {
			for (ParameterDeclaration param : params) {
				addVariable(param);
			}
		}
	}
	
	/**
	 * Look up a variable by name in this scope or parent scopes
	 * Returns the variable declaration with type information
	 */
	public ParameterDeclaration lookupVariable(String name) {
		if (name == null) {
			return null;
		}
		
		// Check current scope
		if (variables.containsKey(name)) {
			return variables.get(name);
		}
		
		// Check parent scope
		if (parent != null) {
			return parent.lookupVariable(name);
		}
		
		return null;
	}
	
	/**
	 * Look up a variable path (e.g., "record1/field1")
	 * Returns the final field declaration with type information
	 */
	public ParameterDeclaration lookupVariablePath(String path) {
		if (path == null || path.isEmpty()) {
			return null;
		}
		
		String[] parts = path.split("/");
		ParameterDeclaration current = lookupVariable(parts[0]);
		
		if (current == null) {
			return null;
		}
		
		// Navigate through the path
		for (int i = 1; i < parts.length; i++) {
			if (!current.hasChildren()) {
				return null; // Path is invalid
			}
			
			// Find child with matching name
			ParameterDeclaration found = null;
			for (ParameterDeclaration child : current.getChildren()) {
				if (parts[i].equals(child.getName())) {
					found = child;
					break;
				}
			}
			
			if (found == null) {
				return null; // Child not found
			}
			
			current = found;
		}
		
		return current;
	}
	
	/**
	 * Check if a variable exists in this scope or parent scopes
	 */
	public boolean hasVariable(String name) {
		return lookupVariable(name) != null;
	}
	
	/**
	 * Get all variables in this scope (not including parent scopes)
	 */
	public Map<String, ParameterDeclaration> getVariables() {
		return new HashMap<>(variables);
	}
	
	/**
	 * Get all variables including parent scopes (ordered from outer to inner)
	 */
	public Map<String, ParameterDeclaration> getAllVariables() {
		Map<String, ParameterDeclaration> allVars = new HashMap<>();
		
		// Start from root scope
		List<VariableScope> scopes = new ArrayList<>();
		VariableScope current = this;
		while (current != null) {
			scopes.add(0, current); // Add at beginning to maintain order
			current = current.parent;
		}
		
		// Add variables from outer to inner (inner scope overrides outer)
		for (VariableScope scope : scopes) {
			allVars.putAll(scope.variables);
		}
		
		return allVars;
	}
	
	/**
	 * Create a child scope
	 */
	public VariableScope createChildScope(String childScopeName) {
		return new VariableScope(childScopeName, this);
	}
	
	/**
	 * Get parent scope
	 */
	public VariableScope getParent() {
		return parent;
	}
	
	/**
	 * Get scope name
	 */
	public String getScopeName() {
		return scopeName;
	}
	
	/**
	 * Get the full scope path (for debugging)
	 */
	public String getScopePath() {
		if (parent == null) {
			return scopeName;
		}
		return parent.getScopePath() + " -> " + scopeName;
	}
	
	@Override
	public String toString() {
		return "VariableScope[" + getScopePath() + ", vars=" + variables.keySet() + "]";
	}
}

// Made with Bob
