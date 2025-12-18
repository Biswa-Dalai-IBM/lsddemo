package expressions.flow.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.webmethods.dsl.serverjars.utils.NSRecordUtils;
import com.wm.app.b2b.server.ns.Namespace;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.ns.NSRecord;

import expressions.FlowElementExpression;
import expressions.MapSignature;
import expressions.ParameterDeclaration;
import expressions.app.FlowGenerator;
import expressions.flow.FlowStepProperty;

public class FlowMapElementExpression extends FlowElementExpression {
	List<FlowElementExpression> expressions;
	List<FlowStepProperty> properties;
	MapSignature mapSignature;

	public FlowMapElementExpression() {
		expressions = new ArrayList<FlowElementExpression>();
		properties = new ArrayList<FlowStepProperty>();
	}

	public void addMapExpression(FlowMapExpression expression) {
		expressions.add(expression);
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowElementExpression> getExpressions() {
		return expressions;
	}

	public List<FlowMapExpression> getMapExpressions() {
		return expressions.stream()
				.filter(e -> e instanceof FlowMapExpression)
				.map(e -> (FlowMapExpression) e)
				.collect(Collectors.toList());
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}

	public boolean hasExpressions() {
		return expressions != null && !expressions.isEmpty();
	}

	public boolean hasProperties() {
		return properties != null && !properties.isEmpty();
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
	 * Build a parameter (field, record, or recordList) and add it to the parent record
	 * Same logic as FlowGenerator.buildParameter()
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
}
