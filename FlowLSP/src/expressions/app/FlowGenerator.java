package expressions.app;

import java.io.IOException;
import java.util.List;

import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.flow.FlowBranch;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowLoop;
import com.wm.lang.flow.FlowMap;
import com.wm.lang.flow.FlowMapCopy;
import com.wm.lang.flow.FlowMapDelete;
import com.wm.lang.flow.FlowRoot;
import com.wm.lang.flow.FlowSequence;
import com.wm.util.Values;
import com.wm.util.coder.IDataXMLCoder;
import com.wm.util.coder.InvalidDatatypeException;

import expressions.FlowElementExpression;
import expressions.FlowProgram;
import expressions.flow.FlowBranchExpression;
import expressions.flow.FlowLoopExpression;
import expressions.flow.FlowSequenceExpression;
import expressions.flow.map.FlowMapCopyExpression;
import expressions.flow.map.FlowMapDropExpression;
import expressions.flow.map.FlowMapElementExpression;
import expressions.flow.map.FlowMapSetExpression;

public class FlowGenerator {

	public void generateFlow(FlowProgram program) {
		IData iData = IDataFactory.create();
		FlowRoot flowRoot = new FlowRoot(iData);

		List<FlowElementExpression> expressions = program.getExpressions();
		if(expressions.size()>0) {
			generateFlow(expressions,flowRoot);
		}
		IData asData = flowRoot.getAsData();
		IDataXMLCoder coder = new IDataXMLCoder();
		try {
			coder.encode(System.out, asData);
		} catch (InvalidDatatypeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateFlow(List<FlowElementExpression> expressions,FlowElement element) {
		for (FlowElementExpression expression : expressions) {

			if(expression instanceof FlowMapElementExpression) {
				FlowMapElementExpression mapElementExpression = (FlowMapElementExpression)expression;
				IData data = IDataFactory.create();
				FlowMap flowMap = new FlowMap(Values.use(data));
				List<FlowElementExpression> expressions2 = mapElementExpression.getExpressions();
				if(expressions2.size()>0) {
					generateFlow(expressions2,flowMap);
				}
				element.addNode(flowMap);
				
			}else if(expression instanceof FlowSequenceExpression){
				FlowSequenceExpression mapElementExpression = (FlowSequenceExpression)expression;
				IData data = IDataFactory.create();
				FlowSequence flowSequence = new FlowSequence(Values.use(data));
				List<FlowElementExpression> expressions2 = mapElementExpression.getExpressions();
				if(expressions2.size()>0) {
					generateFlow(expressions2,flowSequence);
				}
				element.addNode(flowSequence);
			}else if(expression instanceof FlowBranchExpression){
				FlowBranchExpression mapElementExpression = (FlowBranchExpression)expression;
				IData data = IDataFactory.create();
				FlowBranch flowBranch = new FlowBranch(Values.use(data));
				List<FlowElementExpression> expressions2 = mapElementExpression.getExpressions();
				if(expressions2.size()>0) {
					generateFlow(expressions2,flowBranch);
				}
				element.addNode(flowBranch);
			}else if(expression instanceof FlowLoopExpression){
				FlowLoopExpression mapElementExpression = (FlowLoopExpression)expression;
				IData data = IDataFactory.create();
				FlowLoop flowLoop = new FlowLoop(Values.use(data));
				List<FlowElementExpression> expressions2 = mapElementExpression.getExpressions();
				if(expressions2.size()>0) {
					generateFlow(expressions2,flowLoop);
				}
				element.addNode(flowLoop);
			}else if(expression instanceof FlowMapCopyExpression){
				FlowMapCopyExpression mapCopyExpression = (FlowMapCopyExpression)expression;
				IData data = IDataFactory.create();
				FlowMapCopy mapCopy = new FlowMapCopy(Values.use(data));
				String from = mapCopyExpression.getFrom();
				String to = mapCopyExpression.getTo();
				mapCopy.setMapFrom(from);
				mapCopy.setMapTo(to);
				element.addNode(mapCopy);
			}else if(expression instanceof FlowMapSetExpression){
				FlowMapSetExpression mapSetExpression = (FlowMapSetExpression)expression;
				IData data = IDataFactory.create();
				FlowMapCopy mapCopy = new FlowMapCopy(Values.use(data));
				String path = mapSetExpression.getFieldPath();
				String value = mapSetExpression.getValue();
				
				IData data1 = IDataFactory.create();
				IDataUtil.put(data1.getCursor(), path, value);
				mapCopy.setMapFrom(path);
				mapCopy.setFromData(data1);
				element.addNode(mapCopy);
			}else if(expression instanceof FlowMapDropExpression){
				FlowMapDropExpression mapDropExpression = (FlowMapDropExpression)expression;
				IData data = IDataFactory.create();
				FlowMapDelete mapDelete = new FlowMapDelete(Values.use(data));
				String path = mapDropExpression.getFieldName();
				mapDelete.setField(path);
				element.addNode(mapDelete);
			}

		}

	}
}
