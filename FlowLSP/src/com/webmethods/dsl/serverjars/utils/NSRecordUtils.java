package com.webmethods.dsl.serverjars.utils;

import com.wm.lang.ns.NSField;
import com.wm.lang.ns.NSRecord;
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

	/**
	 * Add a field with specific dimension (0=scalar, 1=1D array, 2=2D array, etc.)
	 */
	public static void addFieldWithDimension(NSRecord parent, String fieldName, String type, int dimension) {

		if (type.equals("String")) {
			parent.addField(
					new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_STRING, dimension));
		} else if (type.equals("Integer")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_INTEGER);
			parent.addField(field);
		} else if (type.equals("Float")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_FLOAT);
			parent.addField(field);
		} else if (type.equals("Double")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_DOUBLE);
			parent.addField(field);
		} else if (type.equals("Boolean")) {
			NSField field = new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT,
					dimension);
			field.setJavaWrapperType(JavaWrapperType.JAVA_TYPE_BOOLEAN);
			parent.addField(field);
		} else if (type.equals("Object")) {
			parent.addField(
					new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_OBJECT, dimension));
		} else if (type.equals("Document")) {
			parent.addField(
					new NSField(parent.getNamespace(), NSRecord.TYPE, fieldName, NSField.FIELD_RECORD, dimension));
		}
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
}
