package com.webmethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import com.webmethods.dsl.expressions.FlowElementExpression;
import com.webmethods.dsl.expressions.FlowTextContext;
import com.wm.lang.flow.FlowElement;
import com.wm.lang.flow.FlowExit;
import com.wm.lang.ns.Namespace;
import com.wm.util.Values;

public class FlowExitExpression extends FlowElementExpression {
	List<FlowStepProperty> properties;
	private String exitFrom;
	private String failureInstance;
	private String failureMessage;
	private String failureName;
	private String signal;

	public FlowExitExpression() {
		properties = new ArrayList<FlowStepProperty>();
	}

	public void addProperty(FlowStepProperty property) {
		properties.add(property);
	}

	public List<FlowStepProperty> getProperties() {
		return properties;
	}

	@Override
	public FlowElement getFlowElement(Namespace namespace) {
		
		FlowStepProperty property = getProperty("exitFrom");
		if (property != null && property.hasValue()) {
			exitFrom = property.getValue();
		}
		
		property = getProperty("signal");
		if (property != null && property.hasValue()) {
			signal = property.getValue();
		}else {
			signal=FlowExit.EXIT_SUCCESS;
		}
		
		Object o[][] = {
	            { FlowExit.KEY_EXIT_FROM,            exitFrom },
	            { FlowExit.KEY_EXIT_SIGNAL,          signal },
	        };
		Values values = new Values(o);
		FlowExit flowExit = new FlowExit(values.getIData());
		
		property = getProperty("failureInstance");
		if (property != null && property.hasValue()) {
			failureInstance = property.getValue();
			flowExit.setFailureInstance(failureInstance);
		}
		
		property = getProperty("failureMessage");
		if (property != null && property.hasValue()) {
			failureMessage = property.getValue();
			flowExit.setFailureMessage(failureMessage);
		}
		
		property = getProperty("failureName");
		if (property != null && property.hasValue()) {
			failureName = property.getValue();
			flowExit.setFailureName(failureName);
		}
		addFlowProperties(flowExit);
		return flowExit;
	}

	@Override
	public void updateExpression(FlowElement element) {

	}

	@Override
	public void updateStepProperties(FlowElement element) {
		super.updateStepProperties(element);
		
		FlowExit flowExit = (FlowExit)element;
		exitFrom = flowExit.getExitFrom();
		failureInstance = flowExit.getFailureInstance();
		failureMessage = flowExit.getFailureMessage();
		failureName = flowExit.getFailureName();
		signal = flowExit.getSignal();
		
	}
	@Override
	public void generateText(FlowTextContext context) {

		context.appendIndented("EXIT {");
		context.append("\n");
		context.increaseIndent();
		generateStepProperties(context);
		
		if(exitFrom!=null && !exitFrom.isBlank()) {
			context.appendIndented("exitFrom: \"" + exitFrom + "\";");
			context.append("\n");
		}
		
		if(signal!=null && !signal.isBlank()) {
			context.appendIndented("signal: \"" + signal + "\";");
			context.append("\n");
		}
		
		if(failureName!=null && !failureName.isBlank()) {
			context.appendIndented("failureName: \"" + failureName + "\";");
			context.append("\n");
		}
		
		if(failureMessage!=null && !failureMessage.isBlank()) {
			context.appendIndented("failureMessage: \"" + failureMessage + "\";");
			context.append("\n");
		}
		
		if(failureInstance!=null && !failureInstance.isBlank()) {
			context.appendIndented("failureInstance: \"" + failureInstance + "\";");
			context.append("\n");
		}

		context.decreaseIndent();
		context.appendIndented("};");
		context.append("\n");
	
	}
	
	@Override
	public String getOutlineNodeName() {
		return "EXIT";
	}
}
