package com.wbemethods.dsl.expressions;

import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;

/**
 * Resolves variable paths using scope information and creates NSField/NSRecord
 * structures. This class bridges the gap between parsed variable declarations
 * and webMethods IData structures.
 */
public class VariableResolver {

	private ScopeManager scopeManager;

	public VariableResolver(ScopeManager scopeManager) {
		this.scopeManager = scopeManager;
	}

	/**
	 * Resolve a variable path and get its type information
	 * 
	 * @param path Variable path (e.g., "record1/field1" or "field1")
	 * @return ParameterDeclaration with type information, or null if not found
	 */
	public ParameterDeclaration resolveVariable(String path) {
		if (scopeManager == null) {
			return null;
		}
		return scopeManager.lookupVariablePath(path);
	}

	/**
	 * Check if a variable path exists in the current scope
	 * 
	 * @param path Variable path
	 * @return true if the variable exists
	 */
	public boolean variableExists(String path) {
		return resolveVariable(path) != null;
	}

	/**
	 * Get the data type of a variable
	 * 
	 * @param path Variable path
	 * @return Data type string (e.g., "String", "Integer"), or null if not found
	 */
	public String getVariableType(String path) {
		ParameterDeclaration param = resolveVariable(path);
		if (param != null) {
			return param.getDataType();
		}
		return null;
	}

	/**
	 * Check if a variable is an array
	 * 
	 * @param path Variable path
	 * @return true if the variable is an array
	 */
	public boolean isArray(String path) {
		ParameterDeclaration param = resolveVariable(path);
		return param != null && param.isArray();
	}

	/**
	 * Check if a variable is a record
	 * 
	 * @param path Variable path
	 * @return true if the variable is a record
	 */
	public boolean isRecord(String path) {
		ParameterDeclaration param = resolveVariable(path);
		return param != null && param.isRecord();
	}

	/**
	 * Check if a variable is a record list
	 * 
	 * @param path Variable path
	 * @return true if the variable is a record list
	 */
	public boolean isRecordList(String path) {
		ParameterDeclaration param = resolveVariable(path);
		return param != null && param.isRecordList();
	}

	/**
	 * Create an IData structure for a variable path based on its type This can be
	 * used to create NSField/NSRecord structures
	 * 
	 * @param path Variable path
	 * @return IData representing the variable structure, or null if not found
	 */
	public IData createIDataForVariable(String path) {
		ParameterDeclaration param = resolveVariable(path);
		if (param == null) {
			return null;
		}

		return createIDataFromParameter(param);
	}

	/**
	 * Recursively create IData structure from ParameterDeclaration
	 */
	private IData createIDataFromParameter(ParameterDeclaration param) {
		IData data = IDataFactory.create();
		IDataCursor cursor = data.getCursor();

		try {
			// Add type information
			cursor.insertAfter("name", param.getName());
			cursor.insertAfter("type", param.getType());
			cursor.insertAfter("dataType", param.getDataType());
			cursor.insertAfter("dimension", param.getDimension());
			cursor.insertAfter("isArray", param.isArray()); // Keep for backward compatibility

			// Add constraints if any
			if (!param.getConstraints().isEmpty()) {
				cursor.insertAfter("constraints", param.getConstraints().toArray(new String[0]));
			}

			// Add children for records
			if (param.hasChildren()) {
				IData[] children = new IData[param.getChildren().size()];
				for (int i = 0; i < param.getChildren().size(); i++) {
					children[i] = createIDataFromParameter(param.getChildren().get(i));
				}
				cursor.insertAfter("children", children);
			}
		} finally {
			cursor.destroy();
		}

		return data;
	}

	/**
	 * Get detailed information about a variable for debugging
	 * 
	 * @param path Variable path
	 * @return String with variable information
	 */
	public String getVariableInfo(String path) {
		ParameterDeclaration param = resolveVariable(path);
		if (param == null) {
			return "Variable not found: " + path;
		}

		StringBuilder info = new StringBuilder();
		info.append("Variable: ").append(path).append("\n");
		info.append("  Name: ").append(param.getName()).append("\n");
		info.append("  Type: ").append(param.getType()).append("\n");
		info.append("  DataType: ").append(param.getDataType()).append("\n");
		info.append("  Dimension: ").append(param.getDimension()).append("\n");
		info.append("  IsArray: ").append(param.isArray()).append("\n");

		if (!param.getConstraints().isEmpty()) {
			info.append("  Constraints: ").append(param.getConstraints()).append("\n");
		}

		if (param.hasChildren()) {
			info.append("  Children: ").append(param.getChildren().size()).append("\n");
			for (ParameterDeclaration child : param.getChildren()) {
				info.append("    - ").append(child.getName()).append(" (").append(child.getDataType()).append(")\n");
			}
		}

		return info.toString();
	}

	/**
	 * Get the scope manager
	 */
	public ScopeManager getScopeManager() {
		return scopeManager;
	}
}

// Made with Bob
