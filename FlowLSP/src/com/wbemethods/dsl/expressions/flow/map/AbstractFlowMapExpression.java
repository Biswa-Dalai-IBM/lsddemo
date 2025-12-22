package com.wbemethods.dsl.expressions.flow.map;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.MapSignature;
import com.wbemethods.dsl.expressions.ParameterDeclaration;
import com.wbemethods.dsl.expressions.app.FlowGenerator;
import com.webmethods.dsl.serverjars.utils.NSRecordUtils;
import com.wm.app.b2b.server.ns.Namespace;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.flow.FlowMapCopy;
import com.wm.lang.flow.FlowMapDelete;
import com.wm.lang.flow.FlowMapInvoke;
import com.wm.lang.flow.FlowMapSet;
import com.wm.lang.ns.NSRecord;
import com.wm.util.Values;
import com.wm.util.coder.IDataJSONCoder;
import com.wm.util.coder.InvalidDatatypeException;

public abstract class AbstractFlowMapExpression extends FlowElementExpression {
	List<FlowElementExpression> expressions;
	MapSignature mapSignature;

	public AbstractFlowMapExpression() {
		expressions = new ArrayList<FlowElementExpression>();
	}

	public void addMapExpression(FlowMapExpression expression) {
		expressions.add(expression);
	}

	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}

	public List<FlowMapExpression> getMapExpressions() {
		return expressions.stream().filter(e -> e instanceof FlowMapExpression).map(e -> (FlowMapExpression) e)
				.collect(Collectors.toList());
	}

	public boolean hasExpressions() {
		return expressions != null && !expressions.isEmpty();
	}

	public void setMapSignature(MapSignature mapSignature) {
		this.mapSignature = mapSignature;
	}

	public MapSignature getMapSignature() {
		return mapSignature;
	}

	public boolean hasMapSignature() {
		return mapSignature != null;
	}

	@Override
	public FlowElement getFlowElement() {
		FlowMap flowMap = new FlowMap(null);

		// Set schema info from mapSource/mapTarget if available

		List<FlowElementExpression> expressions2 = getExpressions();
		FlowGenerator.generateFlow(expressions2, flowMap);
		if (hasMapSignature()) {
			NSRecord sourceRecord = buildMapSourceRecord(mapSignature);
			NSRecord targetRecord = buildMapTargetRecord(mapSignature);
			flowMap.setSchemaInfo(sourceRecord, targetRecord);
		}
		return flowMap;
	}

	@Override
	public void updateExpression(FlowElement element) {
		convertFlowMap((FlowMap) element);

	}

	/**
	 * Build NSRecord from mapSource parameters
	 */
	private NSRecord buildMapSourceRecord(MapSignature mapSignature) {
		NSRecord sourceRecord = new NSRecord(Namespace.current());

		if (mapSignature.hasSourceParameters()) {
			for (ParameterDeclaration param : mapSignature.getSourceParameters()) {
				buildParameter(sourceRecord, param);
			}
		}

		return sourceRecord;
	}

	/**
	 * Build NSRecord from mapTarget parameters
	 */
	private NSRecord buildMapTargetRecord(MapSignature mapSignature) {
		NSRecord targetRecord = new NSRecord(Namespace.current());

		if (mapSignature.hasTargetParameters()) {
			for (ParameterDeclaration param : mapSignature.getTargetParameters()) {
				buildParameter(targetRecord, param);
			}
		}

		return targetRecord;
	}

	/**
	 * Get NSRecord for mapSource
	 */
	public NSRecord getMapSourceRecord() {
		if (!hasMapSignature()) {
			return new NSRecord(Namespace.current());
		}

		NSRecord sourceRecord = new NSRecord(Namespace.current());
		if (mapSignature.hasSourceParameters()) {
			for (ParameterDeclaration param : mapSignature.getSourceParameters()) {
				buildParameter(sourceRecord, param);
			}
		}

		String sourceIdentifier = mapSignature.getSourceIdentifier();
		if (sourceIdentifier != null && !sourceIdentifier.isEmpty() && !sourceIdentifier.equals("pipeline")) {
			sourceRecord.setName(sourceIdentifier);
		}
		return sourceRecord;
	}

	/**
	 * Get NSRecord for mapTarget
	 */
	public NSRecord getMapTargetRecord() {
		if (!hasMapSignature()) {
			return new NSRecord(Namespace.current());
		}

		NSRecord targetRecord = new NSRecord(Namespace.current());
		if (mapSignature.hasTargetParameters()) {
			for (ParameterDeclaration param : mapSignature.getTargetParameters()) {
				buildParameter(targetRecord, param);
			}
		}

		String targetIdentifier = mapSignature.getTargetIdentifier();
		if (targetIdentifier != null && !targetIdentifier.isEmpty() && !targetIdentifier.equals("pipeline")) {
			targetRecord.setName(targetIdentifier);
		}
		return targetRecord;
	}

	/**
	 * Build a parameter (field, record, or recordList) and add it to the parent
	 * record Same logic as FlowGenerator.buildParameter()
	 */
	private void buildParameter(NSRecord parent, ParameterDeclaration param) {
		if (param.isField()) {
			// Simple field
			NSRecordUtils.addFieldWithDimension(parent, param.getName(), param.getDataType(), param.getDimension());
		} else if (param.isRecord()) {
			// Record (not array)
			NSRecord nestedRecord = NSRecordUtils.addRecordField(parent, param.getName(), false);
			// Add children to nested record
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					buildParameter(nestedRecord, child);
				}
			}
		} else if (param.isRecordList()) {
			// RecordList (array of records)
			NSRecord nestedRecord = NSRecordUtils.addRecordField(parent, param.getName(), true);
			// Add children to nested record
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					buildParameter(nestedRecord, child);
				}
			}
		}
	}

	/**
	 * Convert FlowMap to MapIOExprssion
	 */
	public void convertFlowMap(FlowMap flowMap) {
		// Convert map operations
		FlowElement[] children = flowMap.getNodes();
		if (children != null) {
			for (FlowElement child : children) {
				FlowElementExpression mapExpr = convertMapOperation(child);
				if (mapExpr != null) {
					addMapExpression((FlowMapExpression) mapExpr);
				}
			}
		}
		IData asData = flowMap.getAsData();
		IDataCursor ic = asData.getCursor();
		Values target = Values.use(IDataUtil.getIData(ic, FlowMap.KEY_TARGET));
		Values source = Values.use(IDataUtil.getIData(ic, FlowMap.KEY_SOURCE));
		
		NSRecord targetRec = target != null ? NSRecord.createRecord(Namespace.current(), target) : null;
		NSRecord sourceRec = source != null ? NSRecord.createRecord(Namespace.current(), source) : null;
        mapSignature = new MapSignature();
        mapSignature.updateSignature(sourceRec, targetRec);
	}

	/**
	 * Convert map operation (copy, set, drop, invoke)
	 */
	private FlowElementExpression convertMapOperation(FlowElement element) {
		if (element instanceof FlowMapCopy) {
			return convertMapCopy((FlowMapCopy) element);
		} else if (element instanceof FlowMapSet) {
			return convertMapSet((FlowMapSet) element);
		} else if (element instanceof FlowMapDelete) {
			return convertMapDelete((FlowMapDelete) element);
		} else if (element instanceof FlowMapInvoke) {
			return convertMapInvoke((FlowMapInvoke) element);
		}
		return null;
	}

	/**
	 * Convert MapCopy to FlowMapCopyExpression
	 */
	private FlowMapCopyExpression convertMapCopy(FlowMapCopy mapCopy) {
		IData data = mapCopy.getAsData();
		IDataCursor cursor = data.getCursor();

		String from = IDataUtil.getString(cursor, "from");
		String to = IDataUtil.getString(cursor, "to");
		cursor.destroy();

		if (from != null && to != null) {
			return new FlowMapCopyExpression(calculatePath(from), calculatePath(to));
		}

		return null;
	}

	/**
	 * Convert MapSet to FlowMapSetExpression
	 */
	private FlowMapSetExpression convertMapSet(FlowMapSet mapSet) {
		IData data = mapSet.getAsData();
		IDataCursor cursor = data.getCursor();
		String field = IDataUtil.getString(cursor, "field");
		Object value = IDataUtil.get(cursor, "data");
		if(value instanceof IData) {
			IData iData = (IData) value;
			value = converIData2Json(cursor, iData);
		}else if(value instanceof IData[]) {
			IData[] datas = (IData[])value;
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < datas.length; i++) {
				if (i > 0) sb.append(", ");
				String text = converIData2Json(cursor, datas[i]);
				sb.append(text);
			}
			sb.append("]");
			value = sb.toString();
		}else if( value instanceof String[]) {
			String[] arr = (String[]) value;
			value = convertStringArrayToLiteral(arr);
		}else if( value instanceof String[][]) {
			String[][] arr = (String[][]) value;
			value = convert2DStringArrayToLiteral(arr);
		}

		if (field != null && value != null) {
			FlowMapSetExpression expression = new FlowMapSetExpression(calculatePath(field), value);
			return expression;
		}

		return null;
	}

	private String converIData2Json(IDataCursor cursor, IData iData) {
		IDataJSONCoder coder = new IDataJSONCoder();
		String jsonText = null;
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			coder.encode(outputStream,iData);
			jsonText = outputStream.toString();
		} catch (InvalidDatatypeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		cursor.destroy();
		return jsonText;
	}

	public static String calculatePath(String xPath) {
		String path="";
		String[] tokens = xPath.split("/");
		for (String t : tokens) {
			if(t.isEmpty()) {
				continue;
			}
			String[] params = t.split(";");
			if(path.isEmpty()) {
				path=path.concat(params[0]);
			}else {
				path=path.concat("/").concat(params[0]);
			}
		}
		return path;
	}

	/**
	 * Convert MapDelete to FlowMapDropExpression
	 */
	private FlowMapDropExpression convertMapDelete(FlowMapDelete mapDelete) {
		IData data = mapDelete.getAsData();
		IDataCursor cursor = data.getCursor();

		String field = IDataUtil.getString(cursor, "field");
		cursor.destroy();

		if (field != null) {
			return new FlowMapDropExpression(calculatePath(field));
		}

		return null;
	}

	/**
	 * Convert MapInvoke to FlowMapInvokeExpression
	 */
	private FlowMapInvokeExpression convertMapInvoke(FlowMapInvoke mapInvoke) {
		IData data = mapInvoke.getAsData();
		IDataCursor cursor = data.getCursor();

		String service = IDataUtil.getString(cursor, "service");
		cursor.destroy();

		if (service != null) {
			return new FlowMapInvokeExpression(service, null, null);
		}

		return null;
	}


	/**
	 * Convert 1D String array to array literal format
	 */
	private String convertStringArrayToLiteral(String[] arr) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) sb.append(", ");
			sb.append("\"").append(escapeString(arr[i])).append("\"");
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Convert 2D String array to nested array literal format
	 */
	private String convert2DStringArrayToLiteral(String[][] arr) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) sb.append(", ");
			// Convert each row to an array
			sb.append("[");
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) sb.append(", ");
				sb.append("\"").append(escapeString(arr[i][j])).append("\"");
			}
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Escape special characters in strings
	 */
	private String escapeString(String str) {
		if (str == null) return "";
		return str.replace("\\", "\\\\")
				  .replace("\"", "\\\"")
				  .replace("\n", "\\n")
				  .replace("\r", "\\r")
				  .replace("\t", "\\t");
	}
}
