package expressions.flow;

import com.wm.lang.flow.FlowElement;

import expressions.FlowElementExpression;

public class FlowStepProperty extends FlowElementExpression{
	
	String key;
	String value;
	
	public FlowStepProperty(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public FlowElement getFlowElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
