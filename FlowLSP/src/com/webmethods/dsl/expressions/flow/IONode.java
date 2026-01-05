package com.webmethods.dsl.expressions.flow;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import com.webmethods.dsl.expressions.FlowTextContext;
import com.webmethods.dsl.expressions.IFlowExpression;
import com.webmethods.dsl.expressions.ParameterDeclaration;

public class IONode implements IFlowExpression{
	private String name;
	private List<ParameterDeclaration> value;
	private int column;
	private int line;
	
	public IONode(String name) {
		this.name=name;
		value = new ArrayList<ParameterDeclaration>();
	}
	
	public IONode(String name,List<ParameterDeclaration> value ) {
		this.name = name;
		this.value = value;
	}
	
	
	public void addParameter(ParameterDeclaration param) {
		this.value.add(param);
	}
	public String getName() {
		return name;
	}
	
	public List<ParameterDeclaration> getValue() {
		return value;
	}

	public boolean hasParameters() {
		return value != null && !value.isEmpty();
	}
	@Override
	public void generateText(FlowTextContext context) {
		if (hasParameters()) {
			context.appendLine(name+" {");
			context.increaseIndent();
			for (ParameterDeclaration param : value) {
				param.generateText(context);
			}
			context.decreaseIndent();
			context.appendLine("}");
		}
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

	@Override
	public String getOutlineNodeName() {
		return name;
	}
}