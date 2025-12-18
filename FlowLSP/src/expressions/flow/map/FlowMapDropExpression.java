package expressions.flow.map;

import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowMapDelete;

public class FlowMapDropExpression extends FlowMapExpression{
	
	String fieldName;
	
	public FlowMapDropExpression(String fieldName) {
		super();
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}
	
	@Override
	public FlowElement getFlowElement() {
		FlowMapDelete mapDelete = new FlowMapDelete(null);
		mapDelete.setField(fieldName, 1, 0);
		return mapDelete;
	}
	
}
