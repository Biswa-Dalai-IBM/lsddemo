package expressions.app;

import java.util.List;

import com.wm.data.IData;
import com.wm.data.IDataFactory;
import com.wm.lang.flow.FlowRoot;

import expressions.FlowElementExpression;
import expressions.FlowProgram;

public class FlowGenerator {
	
	public void generateFlow(FlowProgram program) {
		IData iData = IDataFactory.create();
		FlowRoot flowRoot = new FlowRoot(iData);
		
		List<FlowElementExpression> expressions = program.getExpressions();
		for (FlowElementExpression expression : expressions) {
			
		}
		
	}
}
