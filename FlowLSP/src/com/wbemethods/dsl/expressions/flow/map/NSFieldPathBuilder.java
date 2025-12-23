package com.wbemethods.dsl.expressions.flow.map;

import com.wbemethods.dsl.expressions.NSFieldTypeMapper;
import com.wbemethods.dsl.expressions.ParameterDeclaration;
import com.wbemethods.dsl.expressions.VariableResolver;
import com.webmethods.dsl.serverjars.utils.NSRecordUtils;
import com.wm.app.b2b.server.ns.Namespace;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSRecordRef;

/**
 * Utility class for building NSField paths from variable paths. Handles type
 * resolution and nested record structures.
 */
public class NSFieldPathBuilder {

	/**
	 * Build NSField path string from a variable path
	 * 
	 * @param path             Variable path (e.g., "record1/field1")
	 * @param variableResolver Resolver for type information
	 * @return NSField path string, or null if invalid
	 */
	public static String buildNSFieldPath(String path, VariableResolver variableResolver) {
		if (path == null || path.isBlank()) {
			return null;
		}

		String[] parts = path.split("/");
		if (parts.length < 1) {
			return null;
		}

		NSField previous = null;
		String nsPath = "";

		// Build from leaf to root
		for (int i = parts.length - 1; i >= 0; i--) {
			if (previous == null) {
				// Leaf field - get type information
				int fieldType = NSField.FIELD_STRING; // Default
				int dimension = NSField.DIM_SCALAR; // Default
				String docRef = null;
				String dataType = "String";
				if (variableResolver != null) {
					ParameterDeclaration param = variableResolver.resolveVariable(parts[i]);
					if (param != null) {
						fieldType = NSFieldTypeMapper.getNSFieldType(param);
						dimension = NSFieldTypeMapper.getNSFieldDimension(param);
						if(param.hasDocumentReference()) {
							docRef = param.getDocumentReference();
						}
						dataType = param.getDataType();
					}
					
				}
				if(docRef!=null) {
					previous= new NSRecordRef(Namespace.current(),parts[parts.length - 1],NSName.create(docRef),dimension);
				}else {
					previous = NSRecordUtils.createField(null, parts[i], dataType, dimension);
				}
			} else {
				// Parent record - get dimension
				int recordDimension = NSField.DIM_SCALAR; // Default

				String docRef = null;
				if (variableResolver != null) {
					// Build partial path up to this level
					StringBuilder partialPath = new StringBuilder();
					for (int j = 0; j <= i; j++) {
						if (j > 0)
							partialPath.append("/");
						partialPath.append(parts[j]);
					}
					ParameterDeclaration param = variableResolver.resolveVariable(partialPath.toString());
					if (param != null) {
						recordDimension = NSFieldTypeMapper.getNSFieldDimension(param);
						if(param.hasDocumentReference()) {
							docRef = param.getDocumentReference();
						}
					}
				}

				NSRecord nsRecord = null;
				if(docRef!=null) {
					nsRecord= new NSRecordRef(Namespace.current(),parts[i],NSName.create(docRef),recordDimension);
				}else {
					nsRecord = new NSRecord(Namespace.current(),  parts[i],  recordDimension);
				}
				nsRecord.addField(previous);
				previous.setParent(nsRecord);
				nsPath = previous.getPath() + nsPath;
				previous = nsRecord;
			}
		}

		if (previous != null) {
			previous.setParent(new NSRecord(Namespace.current()));
			nsPath = previous.getPath() + nsPath;
			return nsPath;
		}

		return null;
	}

	/**
	 * Build NSField object from a variable path (for leaf field only)
	 * 
	 * @param path             Variable path
	 * @param variableResolver Resolver for type information
	 * @return NSField object, or null if invalid
	 */
	public static NSField buildNSField(String path, VariableResolver variableResolver) {
		if (path == null || path.isBlank()) {
			return null;
		}

		String[] parts = path.split("/");
		if (parts.length < 1) {
			return null;
		}

		// Get type information for the leaf field
		int fieldType = NSField.FIELD_STRING; // Default
		int dimension = NSField.DIM_SCALAR; // Default
		String docRef = null;
		String dataType = "String";
		if (variableResolver != null) {
			ParameterDeclaration param = variableResolver.resolveVariable(path);
			if (param != null) {
				fieldType = NSFieldTypeMapper.getNSFieldType(param);
				dimension = NSFieldTypeMapper.getNSFieldDimension(param);
				if(param.hasDocumentReference()) {
					docRef = param.getDocumentReference();
				}
				dataType = param.getDataType();
			}
		}
		if(docRef!=null) {
			return new NSRecordRef(Namespace.current(),parts[parts.length - 1],NSName.create(docRef),dimension);
		}
		NSField field = NSRecordUtils.createField(null, parts[parts.length - 1], dataType, dimension);
		return field;
	}
}

// Made with Bob
