package com.webmethods.dsl.expressions.flow;

import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSRecord;
import com.wm.lang.ns.NSRecordRef;
import com.wm.util.JavaWrapperType;

public class NSRecordUtils {

	public static void addField(NSRecord parent, String fieldName, String type) {
		if (type.equals("String")) {
			parent.addField(new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_STRING,
					NSField.DIM_SCALAR));
		} else if (type.equals("record"))
			parent.addField(new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_RECORD,
					NSField.DIM_SCALAR));
		else if (type.equals("String[]"))
			parent.addField(new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_STRING,
					NSField.DIM_ARRAY));
		else if (type.equals("record[]"))
			parent.addField(new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_RECORD,
					NSField.DIM_ARRAY));
		else if (type.equals("Integer")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					NSField.DIM_SCALAR);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_INTEGER);
			parent.addField(field);
		} else if (type.equals("Float")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					NSField.DIM_SCALAR);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_FLOAT);
			parent.addField(field);
		} else if (type.equals("Double")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					NSField.DIM_SCALAR);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_DOUBLE);
			parent.addField(field);
		} else if (type.equals("Boolean")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					NSField.DIM_SCALAR);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_BOOLEAN);
			parent.addField(field);
		} else if (type.equals("Object")) {
			parent.addField(new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					NSField.DIM_SCALAR));
		} else if (type.equals("Document")) {
			parent.addField(new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_RECORD,
					NSField.DIM_SCALAR));
		}
	}

	/**
	 * Add a field with array dimension
	 * @deprecated Use addFieldWithDimension(NSRecord, String, String, int) instead
	 */
	@Deprecated
	public static void addFieldWithDimension(NSRecord parent, String fieldName, String type, boolean isArray) {
		int dimension = isArray ? NSField.DIM_ARRAY : NSField.DIM_SCALAR;
		addFieldWithDimension(parent, fieldName, type, dimension);
	}

	
	public static void addFieldWithDimension(NSRecord parent, String fieldName, String type, int dimension) {
		NSField field = createField(parent.getNamespace(), fieldName, type, dimension);
		if(field!=null) {
			parent.addField(field);
		}
	}
	/**
	 * Add a field with specific dimension (0=scalar, 1=1D array, 2=2D array, etc.)
	 */
	public static NSField createField(com.wm.lang.ns.Namespace namespace, String fieldName, String type, int dimension) {
		NSField field = null;
		if (type==null || type.equals("String")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_STRING, dimension);
		} else if (type.equals("Integer")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_INTEGER);
		} else if (type.equals("Float")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_FLOAT);
		} else if (type.equals("Double")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_DOUBLE);
		} else if (type.equals("Boolean")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_BOOLEAN);
		} else if (type.equals("DateTime")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_DATE);
		} else if (type.equals("Byte")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_BYTE);
		} else if (type.equals("byte[]")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_byte_ARRAY);
		} else if (type.equals("Char")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_CHARACTER);
		} else if (type.equals("Long")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_LONG);
		} else if (type.equals("Short")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_SHORT);
		} else if (type.equals("BigInteger")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_BIG_INTEGER);
		} else if (type.equals("BigDecimal")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_BIG_DECIMAL);
		} else if (type.equals("XOPObject")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_XOP_OBJECT);
		} else if (type.equals("Object")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT, dimension);
		} else if (type.equals("Document")) {
			field = new NSField(namespace, NSRecord.TYPE, fieldName, NSField.FIELD_RECORD, dimension);
		}
		return field;
	}

	/**
	 * Create and add a record field to parent
	 */
	public static NSRecord addRecordField(NSRecord parent, String fieldName, boolean isArray) {
		int dimension = isArray ? NSField.DIM_ARRAY : NSField.DIM_SCALAR;
		NSRecord recordField = new NSRecord(parent.getNamespace(), fieldName, dimension);
		parent.addField(recordField);
		return recordField;
	}
	
	public static NSRecordRef addRecordRefField(NSRecord parent, String fieldName, boolean isArray,String targetName) {
		int dimension = isArray ? NSField.DIM_ARRAY : NSField.DIM_SCALAR;
		NSRecordRef recordField = new NSRecordRef(parent.getNamespace(), fieldName, NSName.create(targetName),dimension);
		parent.addField(recordField);
		return recordField;
	}
}
