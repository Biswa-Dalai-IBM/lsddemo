package expressions;

import java.util.ArrayList;
import java.util.List;

import antlr.FlowServiceBaseVisitor;
import antlr.FlowServiceParser;
import antlr.FlowServiceParser.FlowServiceContext;

public class AntlrToProgram extends FlowServiceBaseVisitor<FlowProgram>{

	@Override
	public FlowProgram visitFlowService(FlowServiceContext ctx) {
		AntlrToExpression antlrToExpression = new AntlrToExpression();
		FlowProgram service = new FlowProgram();
	    service.setLabel(ctx.ID().getText()); // Using label for service name here

	    List<FlowElementExpression> children = new ArrayList<>();
	    for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
	    	service.addChild(antlrToExpression.visitStep(stepCtx));
	    }
	   

	    return service;
	    
	}
}
