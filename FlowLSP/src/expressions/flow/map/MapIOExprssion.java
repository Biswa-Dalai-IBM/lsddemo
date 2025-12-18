package expressions.flow.map;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.serverjars.utils.NSRecordUtils;
import com.wm.app.b2b.server.ns.Namespace;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.NSRecord;

import expressions.FlowElementExpression;
import expressions.MapSignature;
import expressions.ParameterDeclaration;

public class MapIOExprssion extends FlowElementExpression {
	
	boolean isInput;
	List<FlowElementExpression> expressions;
	MapSignature mapSignature;
	
	public MapIOExprssion() {
		expressions = new ArrayList<FlowElementExpression>();
		isInput = false;
	}
	
	public void addMapExpression(FlowElementExpression expression) {
		expressions.add(expression);
	}
	
	public boolean isInput() {
		return isInput;
	}
	
	public void setInput(boolean isInput) {
		this.isInput = isInput;
	}
	
	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}
	
	public List<FlowElementExpression> getMapExpressions() {
		return expressions;
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
		if(sourceIdentifier!=null && !sourceIdentifier.isEmpty() && !sourceIdentifier.equals("pipeline")) {
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
		if(targetIdentifier!=null && !targetIdentifier.isEmpty() && !targetIdentifier.equals("pipeline")) {
			targetRecord.setName(targetIdentifier);
		}
		return targetRecord;
	}
	
	/**
	 * Build a parameter (field, record, or recordList) and add it to the parent record
	 */
	private void buildParameter(NSRecord parent, ParameterDeclaration param) {
		if (param.isField()) {
			// Simple field
			NSRecordUtils.addFieldWithDimension(parent, param.getName(), param.getDataType(), param.isArray());
		}
		else if (param.isRecord()) {
			// Record (not array)
			NSRecord nestedRecord = NSRecordUtils.addRecordField(parent, param.getName(), false);
			// Add children to nested record
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					buildParameter(nestedRecord, child);
				}
			}
		}
		else if (param.isRecordList()) {
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

	@Override
	public FlowElement getFlowElement() {
		// TODO Auto-generated method stub
		return null;
	}
}
