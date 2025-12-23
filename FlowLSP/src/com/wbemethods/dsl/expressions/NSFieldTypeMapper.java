package com.wbemethods.dsl.expressions;

import com.wm.lang.ns.NSField;
import com.wm.util.JavaWrapperType;

/**
 * Maps Flow service data types to NSField type constants
 */
public class NSFieldTypeMapper {

	/**
	 * Map data type string to NSField type constant
	 * 
	 * @param dataType Data type from ParameterDeclaration (e.g., "String",
	 *                 "Integer")
	 * @return NSField type constant (e.g., NSField.FIELD_STRING)
	 */
	public static int mapDataTypeToNSFieldType(String dataType) {
		if (dataType == null) {
			return NSField.FIELD_OBJECT; // Default
		}

		switch (dataType.toLowerCase()) {
		case "string":
			return NSField.FIELD_STRING;
		case "object":
			return NSField.FIELD_OBJECT;
		case "document":
			return NSField.FIELD_OBJECT; // Document is typically an object
		default:
			return NSField.FIELD_OBJECT; // Default for unknown types
		}
	}

	/**
	 * Map array flag to NSField dimension constant
	 * 
	 * @param isArray Whether the field is an array
	 * @return NSField dimension constant (NSField.DIM_SCALAR or NSField.DIM_ARRAY)
	 */
	public static int mapArrayToDimension(boolean isArray) {
		return isArray ? NSField.DIM_ARRAY : NSField.DIM_SCALAR;
	}

	/**
	 * Get NSField type from ParameterDeclaration
	 * 
	 * @param param ParameterDeclaration with type information
	 * @return NSField type constant
	 */
	public static int getNSFieldType(ParameterDeclaration param) {
		if (param == null) {
			return NSField.FIELD_OBJECT;
		}

		// For records, return FIELD_OBJECT
		if (param.isRecord() || param.isRecordList()) {
			return NSField.FIELD_RECORD;
		}

		return mapDataTypeToNSFieldType(param.getDataType());
	}

	/**
	 * Get NSField dimension from ParameterDeclaration
	 * 
	 * @param param ParameterDeclaration with array information
	 * @return NSField dimension constant
	 */
	public static int getNSFieldDimension(ParameterDeclaration param) {
		if (param == null) {
			return NSField.DIM_SCALAR;
		}

		// RecordList is always an array (1D)
		if (param.isRecordList()) {
			return NSField.DIM_ARRAY;
		}

		// Return the dimension directly
		return param.getDimension();
	}

	/**
	 * Get human-readable type name from NSField type constant
	 * 
	 * @param fieldType NSField type constant
	 * @return Type name string
	 */
	public static String getTypeName(int fieldType, int javaWrapperType) {

		if (fieldType == NSField.FIELD_STRING) {
			return "String";
		}else if (fieldType == NSField.FIELD_RECORD) {
			return "Document";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_INTEGER) {
			return "Integer";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_FLOAT) {
			return "Float";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_DOUBLE) {
			return "Double";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_BOOLEAN) {
			return "Boolean";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_DATE) {
			return "DateTime";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_BIG_DECIMAL) {
			return "BigDecimal";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_BIG_INTEGER) {
			return "BigInteger";
		}  else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_BYTE) {
			return "Byte";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_byte_ARRAY) {
			return "byte[]";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_CHARACTER) {
			return "Char";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_LONG) {
			return "Long";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_SHORT) {
			return "Short";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_XOP_OBJECT) {
			return "XOPObject";
		} else if (fieldType == NSField.FIELD_OBJECT && javaWrapperType == JavaWrapperType.JAVA_TYPE_UNKNOWN) {
			return "Object";
		}  else if (fieldType == NSField.FIELD_OBJECT) {
			return "Object";
		} else {
			return "String";
		}

	}

	/**
	 * Get human-readable dimension name from NSField dimension constant
	 * 
	 * @param dimension NSField dimension constant
	 * @return Dimension name string
	 */
	public static String getDimensionName(int dimension) {
		switch (dimension) {
		case NSField.DIM_SCALAR:
			return "Scalar";
		case NSField.DIM_ARRAY:
			return "Array";
		case NSField.DIM_TABLE:
			return "Table";	
		default:
			return "Unknown";
		}
	}
}

// Made with Bob
