package com.webmethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import com.webmethods.dsl.expressions.flow.FlowStepProperty;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.ns.Namespace;

public abstract class FlowElementExpression implements IFlowExpression {
	List<FlowStepProperty> properties;
	private int line;
	private int column;

	
	public abstract FlowElement getFlowElement(Namespace namespace);

	public abstract void updateExpression(FlowElement element);

	public FlowElementExpression() {
		properties = new ArrayList<FlowStepProperty>();
	}

	/**
	 * Convert FlowElement to FlowElementExpression using Factory Pattern
	 * 
	 * @param element The FlowElement to convert
	 * @return The corresponding FlowElementExpression, or null if not supported
	 */
	protected FlowElementExpression convertFlowElement(FlowElement element) {
		return FlowExpressionFactory.createExpression(element);
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}
	
	public boolean hasProperties() {
		if(properties==null || properties.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public void addFlowProperties(FlowElement element){
		FlowStepProperty labelProp = getProperty("label");
		if(labelProp!=null) {
			element.setName(labelProp.getValue());
		}
		
		FlowStepProperty scopeProp = getProperty("scope");
		if(scopeProp!=null) {
			element.setScope(scopeProp.getValue());
		}
		
		FlowStepProperty timeoutProp = getProperty("timeout");
		if(timeoutProp!=null) {
			element.setTimeoutString(timeoutProp.getValue());
		}
		
		FlowStepProperty commentProp = getProperty("comment");
		if(commentProp!=null) {
			element.setComment(commentProp.getValue());
		}
		
		
	}
	/**
	 * Get a property by key (inherited from FlowElementExpression)
	 */
	public FlowStepProperty getProperty(String key) {
		List<FlowStepProperty> props = getProperties();
		if (props == null)
			return null;
		return props.stream().filter(p -> p.getKey().equals(key)).findFirst().orElse(null);
	}

	/**
	 * Get property value by key (inherited from FlowElementExpression)
	 */
	public String getPropertyValue(String key) {
		FlowStepProperty prop = getProperty(key);
		return prop != null ? prop.getValue() : null;
	}
	
	/**
	 * Generate common step properties
	 */
	public void generateStepProperties(FlowTextContext context) {
		// Generate comment property
		FlowStepProperty commentProp = getProperty("comment");
		if (commentProp != null && commentProp.hasValue()) {
			context.appendIndented("comment: \"" + commentProp.getValue() + "\";");
			context.append("\n");
		}

		// Generate label property
		FlowStepProperty labelProp = getProperty("label");
		if (labelProp != null && labelProp.hasValue()) {
			context.appendIndented("label: \"" + labelProp.getValue() + "\";");
			context.append("\n");
		}

		// Generate timeout property
		FlowStepProperty timeoutProp = getProperty("timeout");
		if (timeoutProp != null && timeoutProp.hasValue()) {
			context.appendIndented("timeout: " + timeoutProp.getValue() + ";");
			context.append("\n");
		}

		// Generate scope property
		FlowStepProperty scopeProp = getProperty("scope");
		if (scopeProp != null && scopeProp.hasValue()) {
			context.appendIndented("scope: " + scopeProp.getValue() + ";");
			context.append("\n");
		}
	}

	public void updateStepProperties(FlowElement element) {
		addProperty(new FlowStepProperty("comment", element.getComment()));
		addProperty(new FlowStepProperty("label", element.getName()));
		addProperty(new FlowStepProperty("timeout", element.getTimeoutString()));
		addProperty(new FlowStepProperty("scope", element.getScope()));
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getCharPositionInLine() {
		return column;
	}
	
	@Override
	public void setLocation(Token token) {
		if(token==null) {
			return;
		}
		this.line=token.getLine();
		this.column=token.getCharPositionInLine();
	}
}
