package expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.FlowServiceBaseVisitor;
import antlr.FlowServiceParser;
import antlr.FlowServiceParser.BranchPropertyContext;
import antlr.FlowServiceParser.BranchStepContext;
import antlr.FlowServiceParser.CatchPropertyContext;
import antlr.FlowServiceParser.CatchStepContext;
import antlr.FlowServiceParser.DropStepContext;
import antlr.FlowServiceParser.ExitPropertyContext;
import antlr.FlowServiceParser.ExitStepContext;
import antlr.FlowServiceParser.FinallyPropertyContext;
import antlr.FlowServiceParser.FinallyStepContext;
import antlr.FlowServiceParser.InvokePropertyContext;
import antlr.FlowServiceParser.InvokeStepContext;
import antlr.FlowServiceParser.LoopPropertyContext;
import antlr.FlowServiceParser.LoopStepContext;
import antlr.FlowServiceParser.MapStepContext;
import antlr.FlowServiceParser.MappingBlockContext;
import antlr.FlowServiceParser.MappingCopyEntryContext;
import antlr.FlowServiceParser.MappingSetEntryContext;
import antlr.FlowServiceParser.RepeatPropertyContext;
import antlr.FlowServiceParser.RepeatStepContext;
import antlr.FlowServiceParser.SequencePropertyContext;
import antlr.FlowServiceParser.SequenceStepContext;
import antlr.FlowServiceParser.StepContext;
import antlr.FlowServiceParser.StepPropertyContext;
import antlr.FlowServiceParser.TransformStepContext;
import antlr.FlowServiceParser.TryPropertyContext;
import antlr.FlowServiceParser.TryStepContext;
import expressions.flow.FlowBranchExpression;
import expressions.flow.FlowCatchExpression;
import expressions.flow.FlowExitExpression;
import expressions.flow.FlowFinallyExpression;
import expressions.flow.FlowInvokeExpression;
import expressions.flow.FlowLoopExpression;
import expressions.flow.FlowRepeatExpression;
import expressions.flow.FlowSequenceExpression;
import expressions.flow.FlowStepProperty;
import expressions.flow.FlowTryExpression;
import expressions.flow.map.FlowMapCopyExpression;
import expressions.flow.map.FlowMapDropExpression;
import expressions.flow.map.FlowMapElementExpression;
import expressions.flow.map.FlowMapExpression;
import expressions.flow.map.FlowMapInvokeExpression;
import expressions.flow.map.FlowMapSetExpression;
import expressions.flow.map.MapIOExprssion;

public class AntlrToExpression extends FlowServiceBaseVisitor<FlowElementExpression>{

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
		}

		return null; 
	}

	@Override
	public FlowElementExpression visitStepProperty(StepPropertyContext ctx) {
		String key = ctx.getChild(0).getText();
		String value = ctx.getChild(2).getText();

		return new FlowStepProperty(key, value);
	}

	@Override
	public FlowElementExpression visitMapStep(MapStepContext ctx) {

		FlowMapElementExpression mapElementExpression = new FlowMapElementExpression();

		for (FlowServiceParser.StepPropertyContext propCtx : ctx.stepProperty()) {
			mapElementExpression.addProperty((FlowStepProperty) visitStepProperty(propCtx));
		}

		
		for (ParseTree child : ctx.children) {
			if (child instanceof FlowServiceParser.MappingCopyEntryContext copyCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitMappingCopyEntry(copyCtx));
			} else if (child instanceof FlowServiceParser.MappingSetEntryContext setCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitMappingSetEntry(setCtx));
			}else if (child instanceof FlowServiceParser.DropStepContext setCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitDropStep(setCtx));
			}else if (child instanceof FlowServiceParser.TransformStepContext setCtx) {
				mapElementExpression.addMapExpression((FlowMapExpression) visitTransformStep(setCtx));
			}
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

		MapIOExprssion input =null;
		MapIOExprssion output =null;
		for (FlowServiceParser.MappingBlockContext blockCtx : ctx.mappingBlock()) {
			MapIOExprssion visitMappingBlock = (MapIOExprssion) visitMappingBlock(blockCtx);
			if(visitMappingBlock.isInput()) {
				input = visitMappingBlock;
			}else {
				output = visitMappingBlock;
			}
		}

		FlowElementExpression transformStep = new FlowMapInvokeExpression(qualifiedServiceName,input,output);

		return transformStep;
	}

	@Override
	public FlowElementExpression visitDropStep(DropStepContext ctx) {

		List<String> path = new ArrayList<>();
		path.add(ctx.ID().get(0).getText()); 

		for (int i = 1; i < ctx.ID().size(); i++) {
			path.add(ctx.ID(i).getText());
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

		MapIOExprssion input =null;
		MapIOExprssion output =null;
		for (FlowServiceParser.MappingBlockContext blockCtx : ctx.mappingBlock()) {
			MapIOExprssion visitMappingBlock = (MapIOExprssion) visitMappingBlock(blockCtx);
			if(visitMappingBlock.isInput()) {
				input = visitMappingBlock;
			}else {
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

		for (ParseTree child : ctx.children) {
			if (child instanceof FlowServiceParser.MappingCopyEntryContext copyCtx) {
				blockExpr.addMapExpression(visitMappingCopyEntry(copyCtx));
			} else if (child instanceof FlowServiceParser.MappingSetEntryContext setCtx) {
				blockExpr.addMapExpression(visitMappingSetEntry(setCtx));
			}
		}

		return blockExpr;
	}

	@Override
	public FlowElementExpression visitMappingCopyEntry(MappingCopyEntryContext ctx) {
		List<String> sourcePath = new ArrayList<>();
		List<String> targetPath = new ArrayList<>();

		int arrowIndex = -1;
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i).getText().equals("->")) {
				arrowIndex = i;
				break;
			}
		}

		if (arrowIndex == -1) {
			throw new IllegalArgumentException("Missing '->' in Map copy step");
		}

		for (int i = 0; i < arrowIndex; i++) {
			ParseTree child = ctx.getChild(i);
			if (child instanceof TerminalNode && ((TerminalNode) child).getSymbol().getType() == FlowServiceParser.ID) {
				sourcePath.add(child.getText());
			}
		}

		for (int i = arrowIndex + 1; i < ctx.getChildCount(); i++) {
			ParseTree child = ctx.getChild(i);
			if (child instanceof TerminalNode && ((TerminalNode) child).getSymbol().getType() == FlowServiceParser.ID) {
				targetPath.add(child.getText());
			}
		}

		String sPath = sourcePath.stream().collect(Collectors.joining("/"));
		String tPath = targetPath.stream().collect(Collectors.joining("/"));

		FlowElementExpression expr = new FlowMapCopyExpression(sPath,tPath);

		return expr;
	}

	@Override
	public FlowElementExpression visitMappingSetEntry(MappingSetEntryContext ctx) {
		List<String> path = new ArrayList<>();
		path.add(ctx.ID().get(0).getText()); 

		for (int i = 1; i < ctx.ID().size(); i++) {
			path.add(ctx.ID(i).getText());
		}

		String fieldPath = path.stream().collect(Collectors.joining("/"));
		String valueText = ctx.value().getText();

		FlowElementExpression expr = new FlowMapSetExpression(fieldPath,valueText);

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

}
