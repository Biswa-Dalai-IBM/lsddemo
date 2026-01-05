package com.webmethods.dsl.expressions.flow.map;

import com.webmethods.dsl.expressions.NSFieldTypeMapper;
import com.webmethods.dsl.expressions.ParameterDeclaration;
import com.webmethods.dsl.expressions.VariableResolver;
import com.webmethods.dsl.expressions.flow.NSRecordUtils;
import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSRecordRef;
import com.wm.lang.ns.Namespace;

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
	public static String buildNSFieldPath(Namespace namespace ,String path, VariableResolver variableResolver) {
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
		for (int i = 0; i <parts.length; i++) {
			if (previous == null) {
				// Leaf field - get type information
				int dimension = NSField.DIM_SCALAR; // Default
				String docRef = null;
				String paramType = null;
				String dataType = "String";
				if (variableResolver != null) {
					ParameterDeclaration param = variableResolver.resolveVariable(namespace,parts[i]);
					if (param != null) {
						paramType = param.getType();
						dimension = NSFieldTypeMapper.getNSFieldDimension(param);
						if(param.hasDocumentReference()) {
							docRef = param.getDocumentReference();
						}
						dataType = param.getDataType();
					}
					
				}
				if(docRef!=null) {
					previous= new NSRecordRef(namespace,parts[i],NSName.create(docRef),dimension);
				}else {
					if(paramType!=null && paramType.equals("record")) {
						previous = new NSRecord(namespace, parts[i], dimension);
					}else {
						previous = NSRecordUtils.createField(namespace, parts[i], dataType, dimension);
					}
				}
				previous.setParent(new NSRecord(null));
				nsPath = previous.getPath();
			} else {
				// Parent record - get dimension
				int recordDimension = NSField.DIM_SCALAR; // Default

				String docRef = null;
				String paramType = null;
				String dataType = "String";
					if(i<parts.length) {
						paramType="record";
					}
				if (variableResolver != null) {
					// Build partial path up to this level
					StringBuilder partialPath = new StringBuilder();
					for (int j = 0; j <= i; j++) {
						if (j > 0)
							partialPath.append("/");
						partialPath.append(parts[j]);
					}
					ParameterDeclaration param = variableResolver.resolveVariable(namespace,partialPath.toString());
					if (param != null) {
						recordDimension = NSFieldTypeMapper.getNSFieldDimension(param);
						if(param.hasDocumentReference()) {
							docRef = param.getDocumentReference();
						}
						paramType=param.getType();
						dataType = param.getDataType();
					}
				}

				NSField nsRecord = null;
				if(docRef!=null) {
					nsRecord= new NSRecordRef(namespace,parts[i],NSName.create(docRef),recordDimension);
				}else {
					if(paramType!=null && paramType.equals("record")) {
						nsRecord = new NSRecord(namespace, parts[i], recordDimension);
					}else {
						nsRecord = NSRecordUtils.createField(namespace, parts[i], dataType, recordDimension);
					}
				}
				if(previous instanceof NSRecordRef) {
					NSRecordRef parentRecord = (NSRecordRef) previous;
					NSRecord unknowRecord = new NSRecord(namespace);
					unknowRecord.addField(nsRecord);
					nsRecord.setParent(unknowRecord);
					parentRecord.addField(unknowRecord);
					unknowRecord.setParent(parentRecord);
					previous = nsRecord;
				}else if(previous instanceof NSRecord) {
					NSRecord parentRecord = (NSRecord) previous;
					parentRecord.addField(nsRecord);
					nsRecord.setParent(parentRecord);
					previous = nsRecord;
				}
				nsPath = nsRecord.getPath();
			}
		}
		return nsPath;
	}

	/**
	 * Build NSField object from a variable path (for leaf field only)
	 * 
	 * @param path             Variable path
	 * @param variableResolver Resolver for type information
	 * @return NSField object, or null if invalid
	 */
	public static NSField buildNSField(Namespace namespace,String path, VariableResolver variableResolver) {
		if (path == null || path.isBlank()) {
			return null;
		}

		String[] parts = path.split("/");
		if (parts.length < 1) {
			return null;
		}

		// Get type information for the leaf field
		//int fieldType = NSField.FIELD_STRING; // Default
		int dimension = NSField.DIM_SCALAR; // Default
		String docRef = null;
		String dataType = "String";
		if (variableResolver != null) {
			ParameterDeclaration param = variableResolver.resolveVariable(namespace,path);
			if (param != null) {
				//fieldType = NSFieldTypeMapper.getNSFieldType(param);
				dimension = NSFieldTypeMapper.getNSFieldDimension(param);
				if(param.hasDocumentReference()) {
					docRef = param.getDocumentReference();
				}
				dataType = param.getDataType();
			}
		}
		if(docRef!=null) {
			return new NSRecordRef(namespace,parts[parts.length - 1],NSName.create(docRef),dimension);
		}
		NSField field = NSRecordUtils.createField(namespace, parts[parts.length - 1], dataType, dimension);
		return field;
	}
}

// Made with Bob
