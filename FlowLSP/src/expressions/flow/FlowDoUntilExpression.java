package expressions.flow;

import java.util.List;

import com.webmethods.is.metadata.util.IDataMapUtil;
import com.webmethods.is.util.IDataMap;
import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowDo;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowSwitch;
import com.wm.lang.flow.FlowUntil;
import com.wm.util.Values;

import expressions.FlowElementExpression;
import expressions.app.FlowGenerator;

public class FlowDoUntilExpression extends FlowContainerExpression {
	
	private String untilCondition;
	
	public void setUntilCondition(String condition) {
		this.untilCondition = condition;
	}
	
	public String getUntilCondition() {
		return untilCondition;
	}
	
	public boolean hasUntilCondition() {
		return untilCondition != null && !untilCondition.isEmpty();
	}
	
	@Override
	public void addFlowElement(FlowElement parent) {
		int maxIteration=-1;
		FlowStepProperty property = getProperty("maxIteration");
		if(property!=null) {
			maxIteration=Integer.parseInt(property.getValue());
		}
		
		FlowDo flowDo = new FlowDo(null);
		List<FlowElementExpression> expressions2 = getExpressions();
		if(expressions2.size()>0) {
			FlowGenerator.generateFlow(expressions2,flowDo);
		}
		FlowUntil flowUntil = new FlowUntil(null);
		flowUntil.setCondition(untilCondition);
		flowDo.addNode(flowUntil);
		IData asData = flowDo.getAsData();
		IDataMap dataMap = new IDataMap(asData);
		dataMap.put(FlowDo.KEY_DO_MAX_ITERATIONS, maxIteration);
		flowDo.setFromData(dataMap.getIData());
		parent.addNode(flowDo);
	}
}
