package com.webmethods.dsl.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.webmethods.dsl.antlr.FlowServiceBaseVisitor;
import com.webmethods.dsl.antlr.FlowServiceParser;
import com.webmethods.dsl.antlr.FlowServiceParser.BranchPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.BranchStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.CaseBlockContext;
import com.webmethods.dsl.antlr.FlowServiceParser.CatchPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.CatchStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.DoUntilPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.DoUntilStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.DropStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.ElseBlockContext;
import com.webmethods.dsl.antlr.FlowServiceParser.ElseIfBlockContext;
import com.webmethods.dsl.antlr.FlowServiceParser.ExitPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.ExitStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.FinallyPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.FinallyStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.IfThenStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.InvokePropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.InvokeStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.LoopPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.LoopStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.MapStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.MappingBlockContext;
import com.webmethods.dsl.antlr.FlowServiceParser.MappingCopyEntryContext;
import com.webmethods.dsl.antlr.FlowServiceParser.MappingSetEntryContext;
import com.webmethods.dsl.antlr.FlowServiceParser.ParameterDeclarationContext;
import com.webmethods.dsl.antlr.FlowServiceParser.RepeatPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.RepeatStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.SequencePropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.SequenceStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.StepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.StepPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.SwitchCaseStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.TransformStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.TryPropertyContext;
import com.webmethods.dsl.antlr.FlowServiceParser.TryStepContext;
import com.webmethods.dsl.antlr.FlowServiceParser.WhileStepContext;
import com.webmethods.dsl.expressions.flow.FlowBranchExpression;
import com.webmethods.dsl.expressions.flow.FlowCaseExpression;
import com.webmethods.dsl.expressions.flow.FlowCatchExpression;
import com.webmethods.dsl.expressions.flow.FlowDoUntilExpression;
import com.webmethods.dsl.expressions.flow.FlowElseExpression;
import com.webmethods.dsl.expressions.flow.FlowElseIfExpression;
import com.webmethods.dsl.expressions.flow.FlowExitExpression;
import com.webmethods.dsl.expressions.flow.FlowFinallyExpression;
import com.webmethods.dsl.expressions.flow.FlowIfThenElseExpression;
import com.webmethods.dsl.expressions.flow.FlowInvokeExpression;
import com.webmethods.dsl.expressions.flow.FlowLoopExpression;
import com.webmethods.dsl.expressions.flow.FlowRepeatExpression;
import com.webmethods.dsl.expressions.flow.FlowSequenceExpression;
import com.webmethods.dsl.expressions.flow.FlowStepProperty;
import com.webmethods.dsl.expressions.flow.FlowSwitchExpression;
import com.webmethods.dsl.expressions.flow.FlowTryExpression;
import com.webmethods.dsl.expressions.flow.FlowWhileExpression;
import com.webmethods.dsl.expressions.flow.map.FlowMapCopyExpression;
import com.webmethods.dsl.expressions.flow.map.FlowMapDropExpression;
import com.webmethods.dsl.expressions.flow.map.FlowMapElementExpression;
import com.webmethods.dsl.expressions.flow.map.FlowMapExpression;
import com.webmethods.dsl.expressions.flow.map.FlowMapInvokeExpression;
import com.webmethods.dsl.expressions.flow.map.FlowMapSetExpression;
import com.webmethods.dsl.expressions.flow.map.MapIOExprssion;

public class AntlrToExpression extends FlowServiceBaseVisitor<IFlowExpression> {

	private ScopeManager scopeManager;

	public AntlrToExpression() {
		this.scopeManager = new ScopeManager();
	}

	public AntlrToExpression(ScopeManager scopeManager) {
		this.scopeManager = scopeManager;
	}

	public ScopeManager getScopeManager() {
		return scopeManager;
	}

	public void setScopeManager(ScopeManager scopeManager) {
		this.scopeManager = scopeManager;
	}

	@Override
	public FlowElementExpression visitStep(StepContext ctx) {
		if (ctx.invokeStep() != null) {
			return visitInvokeStep(ctx.invokeStep());
		} else if (ctx.mapStep() != null) {
			return visitMapStep(ctx.mapStep());
		} else if (ctx.loopStep() != null) {
			return visitLoopStep(ctx.loopStep());
		} else if (ctx.sequenceStep() != null) {
			return visitSequenceStep(ctx.sequenceStep());
		} else if (ctx.branchStep() != null) {
			return visitBranchStep(ctx.branchStep());
		} else if (ctx.repeatStep() != null) {
			return visitRepeatStep(ctx.repeatStep());
		} else if (ctx.tryStep() != null) {
			return visitTryStep(ctx.tryStep());
		} else if (ctx.exitStep() != null) {
			return visitExitStep(ctx.exitStep());
		} else if (ctx.doUntilStep() != null) {
			return visitDoUntilStep(ctx.doUntilStep());
		} else if (ctx.switchCaseStep() != null) {
			return visitSwitchCaseStep(ctx.switchCaseStep());
		} else if (ctx.ifThenStep() != null) {
			return visitIfThenStep(ctx.ifThenStep());
		} else if (ctx.whileStep() != null) {
			return visitWhileStep(ctx.whileStep());
		}

		return null;
	}

	@Override
	public FlowElementExpression visitWhileStep(WhileStepContext ctx) {
		FlowWhileExpression expression = new FlowWhileExpression();
		String condition = processExpression(ctx.expression());
		expression.setCondition(condition);
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			expression.addChild(visitStep(stepCtx));
		}
		return expression;
	}

	@Override
	public FlowElementExpression visitIfThenStep(IfThenStepContext ctx) {
		FlowIfThenElseExpression expression = new FlowIfThenElseExpression();
		String condition = processExpression(ctx.expression());
		expression.setCondition(condition);
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			expression.addChild(visitStep(stepCtx));
		}
		for (ElseIfBlockContext stepCtx : ctx.elseIfBlock()) {
			expression.addElseIfExpressions((FlowElseIfExpression) visitElseIfBlock(stepCtx));
		}
		if (ctx.elseBlock() != null) {
			expression.setElseExpression((FlowElseExpression) visitElseBlock(ctx.elseBlock()));
		}
		return expression;
	}

	@Override
	public FlowElementExpression visitElseIfBlock(ElseIfBlockContext ctx) {
		FlowElseIfExpression expression = new FlowElseIfExpression();
		String condition = processExpression(ctx.expression());
		expression.setCondition(condition);
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			expression.addChild(visitStep(stepCtx));
		}
		return expression;
	}

	@Override
	public FlowElementExpression visitElseBlock(ElseBlockContext ctx) {
		FlowElseExpression expression = new FlowElseExpression();
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			expression.addChild(visitStep(stepCtx));
		}
		return expression;
	}

	@Override
	public FlowElementExpression visitSwitchCaseStep(SwitchCaseStepContext ctx) {
		FlowSwitchExpression flowSwitchExpression = new FlowSwitchExpression();
		String text = ctx.expression().getText();
		flowSwitchExpression.setSwitchKey(text);
		for (CaseBlockContext caseCtx : ctx.caseBlock()) {
			flowSwitchExpression.addChild(visitCaseBlock(caseCtx));
		}
		return flowSwitchExpression;
	}

	@Override
	public FlowElementExpression visitCaseBlock(CaseBlockContext ctx) {
		FlowCaseExpression caseExpression = new FlowCaseExpression();
		caseExpression.setCaseValue(ctx.value().getText());
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			caseExpression.addChild(visitStep(stepCtx));
		}
		return caseExpression;
	}

	@Override
	public FlowElementExpression visitStepProperty(StepPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();

		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitDoUntilStep(DoUntilStepContext ctx) {
		FlowDoUntilExpression doUntilExpression = new FlowDoUntilExpression();

		// Add properties (e.g., maxIteration)
		for (FlowServiceParser.DoUntilPropertyContext propCtx : ctx.doUntilProperty()) {
			doUntilExpression.addProperty(visitDoUntilProperty(propCtx));
		}

		// Add child steps
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			doUntilExpression.addChild(visitStep(stepCtx));
		}

		// Extract and set the UNTIL condition expression
		// Grammar: 'DO' '{' doUntilProperty* step* '}' 'UNTIL' '(' expression ')' ';'
		if (ctx.expression() != null) {
			String untilCondition = processExpression(ctx.expression());
			doUntilExpression.setUntilCondition(untilCondition);
		}

		return doUntilExpression;
	}

	@Override
	public FlowStepProperty visitDoUntilProperty(DoUntilPropertyContext ctx) {

		String text = ctx.getText();
		text = text.replace(";", "");
		String[] split = text.split(":");
		return new FlowStepProperty(split[0], split[1]);
	}

	/**
	 * Process an expression and add % prefix to variable references. Handles all
	 * scenarios: - x1/y1==5 -> %x1/y1% ==5 - x1==8 -> %x1% ==8 - x1==y1 -> %x1%
	 * ==%y1% - x1/y1&&p1/q1 -> %x1/y1% &&%p1/q1%
	 */
	private String processExpression(FlowServiceParser.ExpressionContext ctx) {
		StringBuilder result = new StringBuilder();

		// Process all primary expressions and binary operators in sequence
		List<FlowServiceParser.PrimaryExpressionContext> primaries = ctx.primaryExpression();
		List<FlowServiceParser.BinaryOperatorContext> operators = ctx.binaryOperator();

		for (int i = 0; i < primaries.size(); i++) {
			// Process primary expression
			String primaryText = processPrimaryExpression(primaries.get(i));
			result.append(primaryText);

			// Add operator if exists
			if (i < operators.size()) {
				result.append("").append(operators.get(i).getText()).append("");
			}
		}

		return result.toString();
	}

	/**
	 * Process a primary expression and add % prefix to variable references.
	 */
	private String processPrimaryExpression(FlowServiceParser.PrimaryExpressionContext ctx) {
		// Check if it's a variable reference
		if (ctx.variableRef() != null) {
			return "%" + ctx.variableRef().getText() + "%";
		}

		// Check if it's a literal (number, string, boolean, null)
		if (ctx.literal() != null) {
			return ctx.literal().getText();
		}

		// Check if it's a parenthesized expression
		if (ctx.expression() != null) {
			return "(" + processExpression(ctx.expression()) + ")";
		}

		// Check if it's a unary operation
		if (ctx.unaryOperator() != null) {
			return ctx.unaryOperator().getText() + processPrimaryExpression(ctx.primaryExpression());
		}

		// Check if it's a service reference (ID ('.' ID)* ':' ID)
		if (ctx.ID() != null && ctx.ID().size() > 0) {
			return ctx.getText(); // Service references don't need % prefix
		}

		// Default: return as-is
		return ctx.getText();
	}

	@Override
	public FlowElementExpression visitMapStep(MapStepContext ctx) {

		FlowMapElementExpression mapElementExpression = new FlowMapElementExpression();
		MapSignature mapSignature = new MapSignature();

		// Enter a new scope for this MAP step
		if (scopeManager != null) {
			scopeManager.enterScope("MAP");
		}

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			mapElementExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		// Process mapSignatureBlock (mapSource/mapTarget) to add variables to scope and
		// collect signature
		for (ParseTree child : ctx.children) {
			if (child instanceof FlowServiceParser.MapSignatureBlockContext mapSigCtx) {
				MapSignature blockSignature = visitMapSignatureBlock(mapSigCtx);
				// Merge into main mapSignature
				if (blockSignature.hasSourceParameters()) {
					for (ParameterDeclaration param : blockSignature.getSourceParameters()) {
						mapSignature.addSourceParameter(param);
					}
					// Copy source identifier if present
					if (blockSignature.getSourceIdentifier() != null) {
						mapSignature.setSourceIdentifier(blockSignature.getSourceIdentifier());
					}
				}
				if (blockSignature.hasTargetParameters()) {
					for (ParameterDeclaration param : blockSignature.getTargetParameters()) {
						mapSignature.addTargetParameter(param);
					}
					// Copy target identifier if present
					if (blockSignature.getTargetIdentifier() != null) {
						mapSignature.setTargetIdentifier(blockSignature.getTargetIdentifier());
					}
				}
			}
		}

		// Set the collected mapSignature on the expression
		if (mapSignature.hasSourceParameters() || mapSignature.hasTargetParameters()) {
			mapElementExpression.setMapSignature(mapSignature);
		}

		// Process mapping expressions (copy, set, drop, transform)
		for (ParseTree child : ctx.children) {
			if (child instanceof FlowServiceParser.MappingCopyEntryContext copyCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitMappingCopyEntry(copyCtx));
			} else if (child instanceof FlowServiceParser.MappingSetEntryContext setCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitMappingSetEntry(setCtx));
			} else if (child instanceof FlowServiceParser.DropStepContext setCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitDropStep(setCtx));
			} else if (child instanceof FlowServiceParser.TransformStepContext setCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitTransformStep(setCtx));
			}
		}

		// Exit the MAP scope
		if (scopeManager != null) {
			scopeManager.exitScope();
		}

		return mapElementExpression;
	}

	@Override
	public FlowElementExpression visitTransformStep(TransformStepContext ctx) {
		StringBuilder serviceNameBuilder = new StringBuilder();

		List<TerminalNode> ids = ctx.qualifiedServiceName().ID();
		int idCount = ids.size();

		for (int i = 0; i < idCount - 1; i++) {
			serviceNameBuilder.append(ids.get(i).getText());
			if (i < idCount - 2) {
				serviceNameBuilder.append('.');
			} else {
				serviceNameBuilder.append(':');
			}
		}
		serviceNameBuilder.append(ids.get(idCount - 1).getText());

		String qualifiedServiceName = serviceNameBuilder.toString();

		MapIOExprssion input = null;
		MapIOExprssion output = null;
		for (FlowServiceParser.MappingBlockContext blockCtx : ctx.mappingBlock()) {
			MapIOExprssion visitMappingBlock = (MapIOExprssion) visitMappingBlock(blockCtx);
			if (visitMappingBlock.isInput()) {
				input = visitMappingBlock;
			} else {
				output = visitMappingBlock;
			}
		}

		FlowElementExpression transformStep = new FlowMapInvokeExpression(qualifiedServiceName, input, output);

		return transformStep;
	}

	@Override
	public FlowElementExpression visitDropStep(DropStepContext ctx) {

		List<String> path = new ArrayList<>();
		path.add(ctx.identifier().get(0).getText());

		for (int i = 1; i < ctx.identifier().size(); i++) {
			path.add(ctx.identifier(i).getText());
		}

		String fieldPath = path.stream().collect(Collectors.joining("/"));

		FlowElementExpression expr = new FlowMapDropExpression(fieldPath);

		return expr;

	}

	@Override
	public FlowElementExpression visitInvokeStep(InvokeStepContext ctx) {
		FlowInvokeExpression step = new FlowInvokeExpression();

		List<TerminalNode> ids = ctx.qualifiedServiceName().ID();
		StringBuilder serviceName = new StringBuilder();
		for (int i = 0; i < ids.size() - 1; i++) {
			serviceName.append(ids.get(i).getText());
			if (i < ids.size() - 2) {
				serviceName.append('.');
			} else {
				serviceName.append(':');
			}
		}
		serviceName.append(ids.get(ids.size() - 1).getText());
		step.setServiceName(serviceName.toString());

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			step.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.InvokePropertyContext propCtx : ctx.invokeProperty()) {
			step.addProperty((FlowStepProperty) visitInvokeProperty(propCtx));
		}

		MapIOExprssion input = null;
		MapIOExprssion output = null;
		for (FlowServiceParser.MappingBlockContext blockCtx : ctx.mappingBlock()) {
			MapIOExprssion visitMappingBlock = (MapIOExprssion) visitMappingBlock(blockCtx);
			if (visitMappingBlock.isInput()) {
				input = visitMappingBlock;
			} else {
				output = visitMappingBlock;
			}
		}
		step.setInput(input);
		step.setOutput(output);
		return step;
	}

	@Override
	public FlowElementExpression visitMappingBlock(MappingBlockContext ctx) {
		boolean isInput = ctx.getStart().getText().equals("input");

		MapIOExprssion blockExpr = new MapIOExprssion();
		blockExpr.setInput(isInput);
		MapSignature mapSignature = new MapSignature();

		// Enter a new scope for this mapping block
		if (scopeManager != null) {
			scopeManager.enterScope(isInput ? "INVOKE_INPUT" : "INVOKE_OUTPUT");
		}

		// Process mapSignatureBlock (mapSource/mapTarget) to add variables to scope and
		// collect signature
		for (ParseTree child : ctx.children) {
			if (child instanceof FlowServiceParser.MapSignatureBlockContext mapSigCtx) {
				MapSignature blockSignature = visitMapSignatureBlock(mapSigCtx);
				// Merge into main mapSignature
				if (blockSignature.hasSourceParameters()) {
					for (ParameterDeclaration param : blockSignature.getSourceParameters()) {
						mapSignature.addSourceParameter(param);
					}
					// Copy source identifier if present
					if (blockSignature.getSourceIdentifier() != null) {
						mapSignature.setSourceIdentifier(blockSignature.getSourceIdentifier());
					}
				}
				if (blockSignature.hasTargetParameters()) {
					for (ParameterDeclaration param : blockSignature.getTargetParameters()) {
						mapSignature.addTargetParameter(param);
					}
					// Copy target identifier if present
					if (blockSignature.getTargetIdentifier() != null) {
						mapSignature.setTargetIdentifier(blockSignature.getTargetIdentifier());
					}
				}
			}
		}

		// Set the collected mapSignature on the expression
		if (mapSignature.hasSourceParameters() || mapSignature.hasTargetParameters()) {
			blockExpr.setMapSignature(mapSignature);
		}

		// Process mapping expressions (copy, set)
		for (ParseTree child : ctx.children) {
			if (child instanceof FlowServiceParser.MappingCopyEntryContext copyCtx) {
				blockExpr.addMapExpression((FlowMapExpression) visitMappingCopyEntry(copyCtx));
			} else if (child instanceof FlowServiceParser.MappingSetEntryContext setCtx) {
				blockExpr.addMapExpression((FlowMapExpression) visitMappingSetEntry(setCtx));
			}
		}

		// Exit the mapping block scope
		if (scopeManager != null) {
			scopeManager.exitScope();
		}

		return blockExpr;
	}

	@Override
	public FlowElementExpression visitMappingCopyEntry(MappingCopyEntryContext ctx) {
		// Grammar: 'copy' variableRef '->' variableRef ';'
		// ctx.variableRef(0) is the source
		// ctx.variableRef(1) is the target

		if (ctx.variableRef() == null || ctx.variableRef().size() < 2) {
			throw new IllegalArgumentException("Invalid copy statement: missing source or target variableRef");
		}

		String sourcePath = buildVariableRefPath(ctx.variableRef(0));
		String targetPath = buildVariableRefPath(ctx.variableRef(1));

		// Create VariableResolver from ScopeManager
		VariableResolver resolver = null;
		if (scopeManager != null) {
			resolver = new VariableResolver(scopeManager);
		}

		FlowElementExpression expr = new FlowMapCopyExpression(sourcePath, targetPath, resolver);

		return expr;
	}

	/**
	 * Helper method to build the full path from a variableRef context. Handles both
	 * SPECIAL_VAR and identifier paths.
	 */
	private String buildVariableRefPath(FlowServiceParser.VariableRefContext varRefCtx) {
		List<String> pathParts = new ArrayList<>();

		// Check if it starts with SPECIAL_VAR (e.g., $error, $last)
		if (varRefCtx.SPECIAL_VAR() != null) {
			pathParts.add(varRefCtx.SPECIAL_VAR().getText());
		}

		// Add all identifier parts
		for (FlowServiceParser.IdentifierContext idCtx : varRefCtx.identifier()) {
			pathParts.add(idCtx.getText());
		}

		return pathParts.stream().collect(Collectors.joining("/"));
	}

	@Override
	public FlowElementExpression visitMappingSetEntry(MappingSetEntryContext ctx) {
		List<String> path = new ArrayList<>();
		path.add(ctx.identifier().get(0).getText());

		for (int i = 1; i < ctx.identifier().size(); i++) {
			path.add(ctx.identifier(i).getText());
		}

		String fieldPath = path.stream().collect(Collectors.joining("/"));
		String valueText;
		
		// Handle different value types
		if (ctx.value().arrayLiteral() != null) {
			// Handle array literal: ["abc", "xyz"]
			valueText = ctx.value().arrayLiteral().getText();
		} else if (ctx.value().jsonObject() != null) {
			// Handle JSON object: {"key": "value", ...}
			valueText = ctx.value().jsonObject().getText();
		} else {
			// Handle simple values (INT, STRING_LITERAL, BOOL, expression)
			valueText = ctx.value().getText();
		}

		// Create VariableResolver from ScopeManager
		VariableResolver resolver = null;
		if (scopeManager != null) {
			resolver = new VariableResolver(scopeManager);
		}

		FlowMapSetExpression expr = new FlowMapSetExpression(fieldPath, valueText, resolver);
		return expr;
	}

	@Override
	public FlowElementExpression visitInvokeProperty(InvokePropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitLoopStep(LoopStepContext ctx) {
		FlowLoopExpression loopExpression = new FlowLoopExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			loopExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.LoopPropertyContext propCtx : ctx.loopProperty()) {
			loopExpression.addProperty((FlowStepProperty) visitLoopProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			loopExpression.addChild(visitStep(stepCtx));
		}

		return loopExpression;
	}

	@Override
	public FlowElementExpression visitLoopProperty(LoopPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitSequenceStep(SequenceStepContext ctx) {
		FlowSequenceExpression sequenceExpression = new FlowSequenceExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			sequenceExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.SequencePropertyContext propCtx : ctx.sequenceProperty()) {
			sequenceExpression.addProperty((FlowStepProperty) visitSequenceProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			sequenceExpression.addChild(visitStep(stepCtx));
		}

		return sequenceExpression;
	}

	@Override
	public FlowElementExpression visitSequenceProperty(SequencePropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitTryStep(TryStepContext ctx) {
		FlowTryExpression tryExpression = new FlowTryExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			tryExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.TryPropertyContext propCtx : ctx.tryProperty()) {
			tryExpression.addProperty((FlowStepProperty) visitTryProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			tryExpression.addChild(visitStep(stepCtx));
		}
		for (FlowServiceParser.CatchStepContext stepCtx : ctx.catchStep()) {
			tryExpression.addCatchExpressions((FlowCatchExpression) visitCatchStep(stepCtx));
		}
		FinallyStepContext finallyStep = ctx.finallyStep();
		if (finallyStep != null) {
			tryExpression.setFinallyExpression((FlowFinallyExpression) visitFinallyStep(finallyStep));
		}
		return tryExpression;
	}

	@Override
	public FlowElementExpression visitTryProperty(TryPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitCatchStep(CatchStepContext ctx) {
		FlowCatchExpression catchExpression = new FlowCatchExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			catchExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.CatchPropertyContext propCtx : ctx.catchProperty()) {
			catchExpression.addProperty((FlowStepProperty) visitCatchProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			catchExpression.addChild(visitStep(stepCtx));
		}
		return catchExpression;
	}

	@Override
	public FlowElementExpression visitCatchProperty(CatchPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitFinallyStep(FinallyStepContext ctx) {
		FlowFinallyExpression finallyExpression = new FlowFinallyExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			finallyExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.FinallyPropertyContext propCtx : ctx.finallyProperty()) {
			finallyExpression.addProperty((FlowStepProperty) visitFinallyProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			finallyExpression.addChild(visitStep(stepCtx));
		}
		return finallyExpression;
	}

	@Override
	public FlowElementExpression visitFinallyProperty(FinallyPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitBranchStep(BranchStepContext ctx) {

		FlowBranchExpression branchExpression = new FlowBranchExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			branchExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.BranchPropertyContext propCtx : ctx.branchProperty()) {
			branchExpression.addProperty((FlowStepProperty) visitBranchProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			branchExpression.addChild(visitStep(stepCtx));
		}

		return branchExpression;
	}

	@Override
	public FlowElementExpression visitBranchProperty(BranchPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitRepeatStep(RepeatStepContext ctx) {
		FlowRepeatExpression repeatExpression = new FlowRepeatExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			repeatExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		for (FlowServiceParser.RepeatPropertyContext propCtx : ctx.repeatProperty()) {
			repeatExpression.addProperty((FlowStepProperty) visitRepeatProperty(propCtx));
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			repeatExpression.addChild(visitStep(stepCtx));
		}

		return repeatExpression;
	}

	@Override
	public FlowElementExpression visitRepeatProperty(RepeatPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitExitStep(ExitStepContext ctx) {
		FlowExitExpression exitExpression = new FlowExitExpression();

		for (FlowServiceParser.ExitPropertyContext propCtx : ctx.exitProperty()) {
			exitExpression.addProperty((FlowStepProperty) visitExitProperty(propCtx));
		}

		return exitExpression;

	}

	@Override
	public FlowElementExpression visitExitProperty(ExitPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();
		return new FlowStepProperty(key, value);
	}

	// ========== Service Signature Visitor Methods ==========

	@Override
	public FlowElementExpression visitFlowService(FlowServiceParser.FlowServiceContext ctx) {
		FlowProgram program = new FlowProgram();

		// Set service name
		if (ctx.ID() != null) {
			program.setLabel(ctx.ID().getText());
		}

		// Process signature if present
		if (ctx.signature() != null) {
			FlowServiceSignature signature = (FlowServiceSignature) visitSignature(ctx.signature());
			program.setSignature(signature);
		}

		// Process steps
		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			FlowElementExpression stepExpr = visitStep(stepCtx);
			if (stepExpr != null) {
				program.addChild(stepExpr);
			}
		}

		return program;
	}

	@Override
	public FlowServiceSignature visitSignature(FlowServiceParser.SignatureContext ctx) {
		FlowServiceSignature signature = new FlowServiceSignature();

		// Process all signature blocks (input/output)
		for (FlowServiceParser.SignatureBlockContext blockCtx : ctx.signatureBlock()) {
			visitSignatureBlock(blockCtx, signature);
		}

		return signature;
	}

	/**
	 * Process a signature block (input or output) and add parameters to the
	 * signature
	 */
	private void visitSignatureBlock(FlowServiceParser.SignatureBlockContext ctx, FlowServiceSignature signature) {
		boolean isInput = ctx.getStart().getText().equals("input");

		// Process all parameter declarations in this block
		for (FlowServiceParser.ParameterDeclarationContext paramCtx : ctx.parameterDeclaration()) {
			ParameterDeclaration param = processParameterDeclaration(paramCtx);
			if (param != null) {
				if (isInput) {
					signature.addInputParameter(param);
				} else {
					signature.addOutputParameter(param);
				}
			}
		}
	}

	/**
	 * Visit a parameter declaration (field, record, or recordList)
	 */
	private ParameterDeclaration processParameterDeclaration(ParameterDeclarationContext ctx) {

		if (ctx.fieldDeclaration() != null) {
			return processFieldDeclaration(ctx.fieldDeclaration());
		} else if (ctx.recordDeclaration() != null) {
			return processRecordDeclaration(ctx.recordDeclaration());
		} else if (ctx.recordListDeclaration() != null) {
			return processRecordListDeclaration(ctx.recordListDeclaration());
		}

		return null;
	}

	/**
	 * Visit a field declaration Grammar: dataType ('[' ']')? identifier
	 * constraints? ';'
	 */
	private ParameterDeclaration processFieldDeclaration(FlowServiceParser.FieldDeclarationContext ctx) {

		String name = ctx.identifier().getText();
		ParameterDeclaration param = new ParameterDeclaration(name, "field");

		// Set data type
		if (ctx.dataType() != null) {
			param.setDataType(ctx.dataType().getText());
		}

		// Count array dimensions (e.g., [] = 1D, [][] = 2D)
		int dimension = 0;
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i).getText().equals("[")) {
				dimension++;
			}
		}
		param.setDimension(dimension);

		// Process constraints
		if (ctx.constraints() != null) {
			processConstraints(ctx.constraints(), param);
		}

		return param;
	}

	/**
	 * Visit a record declaration Grammar: 'record' identifier '{'
	 * parameterDeclaration* '}' constraints? ';'
	 */
	private ParameterDeclaration processRecordDeclaration(FlowServiceParser.RecordDeclarationContext ctx) {

		String name = ctx.identifier().getText();
		ParameterDeclaration param = new ParameterDeclaration(name, "record");

		// Process document reference if present
		if (ctx.documentReference() != null) {
			String docRef = ctx.documentReference().qualifiedDocumentName().getText();
			param.setDocumentReference(docRef);
		}

		// Process child parameters
		for (FlowServiceParser.ParameterDeclarationContext childCtx : ctx.parameterDeclaration()) {
			ParameterDeclaration childParam = processParameterDeclaration(childCtx);
			if (childParam != null) {
				param.addChild(childParam);
			}
		}

		// Process constraints
		if (ctx.constraints() != null) {
			processConstraints(ctx.constraints(), param);
		}

		return param;
	}

	/**
	 * Visit a recordList declaration Grammar: 'recordList' identifier '{'
	 * parameterDeclaration* '}' constraints? ';'
	 */
	private ParameterDeclaration processRecordListDeclaration(FlowServiceParser.RecordListDeclarationContext ctx) {

		String name = ctx.identifier().getText();
		ParameterDeclaration param = new ParameterDeclaration(name, "recordList");

		// Process document reference if present
		if (ctx.documentReference() != null) {
			String docRef = ctx.documentReference().qualifiedDocumentName().getText();
			param.setDocumentReference(docRef);
		}

		// Process child parameters
		for (FlowServiceParser.ParameterDeclarationContext childCtx : ctx.parameterDeclaration()) {
			ParameterDeclaration childParam = processParameterDeclaration(childCtx);
			if (childParam != null) {
				param.addChild(childParam);
			}
		}

		// Process constraints
		if (ctx.constraints() != null) {
			processConstraints(ctx.constraints(), param);
		}

		return param;
	}

	/**
	 * Process constraints and add them to the parameter
	 */
	private void processConstraints(FlowServiceParser.ConstraintsContext ctx, ParameterDeclaration param) {

		for (FlowServiceParser.ConstraintContext constraintCtx : ctx.constraint()) {
			String constraintText = constraintCtx.getText();
			param.addConstraint(constraintText);
		}
	}

	/**
	 * Visit a mapSignatureBlock (mapSource or mapTarget) Adds variables to the
	 * current scope
	 */
	@Override
	public MapSignature visitMapSignatureBlock(FlowServiceParser.MapSignatureBlockContext ctx) {
		MapSignature mapSignature = new MapSignature();

		boolean isSource = ctx.getStart().getText().equals("mapSource");

		// Extract the identifier from brackets if present
		// Grammar: 'mapSource' ('[' identifier ']')? '{' parameterDeclaration* '}'
		if (ctx.identifier() != null) {
			String identifier = ctx.identifier().getText();
			if (isSource) {
				mapSignature.setSourceIdentifier(identifier);
			} else {
				mapSignature.setTargetIdentifier(identifier);
			}
		}

		// Process all parameter declarations in this block
		for (FlowServiceParser.ParameterDeclarationContext paramCtx : ctx.parameterDeclaration()) {
			ParameterDeclaration param = processParameterDeclaration(paramCtx);
			if (param != null) {
				if (isSource) {
					mapSignature.addSourceParameter(param);
				} else {
					mapSignature.addTargetParameter(param);
				}

				// Add to current scope for variable resolution
				if (scopeManager != null) {
					scopeManager.addVariable(param);
				}
			}
		}

		return mapSignature;
	}

}
