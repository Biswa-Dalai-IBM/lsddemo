package expressions.flow.map;

import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;

public class MapIOExprssion  extends FlowElementExpression{
	
	boolean isInput;

	List<FlowElementExpression> expressions;
	
	public MapIOExprssion() {
		expressions = new ArrayList<FlowElementExpression>();
		isInput=false;
	}
	public void addMapExpression(FlowElementExpression expression){
		expressions.add(expression);
	}
	
	public boolean isInput() {
		return isInput;
	}
	
	public void setInput(boolean isInput) {
		this.isInput = isInput;
	}
}
