package com.webmethods.dsl.expressions;

import com.webmethods.dsl.antlr.FlowServiceBaseVisitor;
import com.webmethods.dsl.antlr.FlowServiceParser;
import com.webmethods.dsl.antlr.FlowServiceParser.FlowServiceContext;
import com.webmethods.dsl.antlr.FlowServiceParser.InterfaceDeclarationContext;

public class AntlrToProgram extends FlowServiceBaseVisitor<FlowProgram> {

	@Override
	public FlowProgram visitFlowService(FlowServiceContext ctx) {
		// Create scope manager and expression visitor
		ScopeManager scopeManager = new ScopeManager();
		AntlrToExpression antlrToExpression = new AntlrToExpression(scopeManager);

		FlowProgram service = new FlowProgram();
		service.setLabel(ctx.ID().getText()); // Using label for service name here
		InterfaceDeclarationContext interfaceDeclaration = ctx.interfaceDeclaration();
		if(interfaceDeclaration!=null) {
			service.setInterfaceName(interfaceDeclaration.getText());
		}
		
		service.setScopeManager(scopeManager); // Store scope manager for later use

		// Load service signature if present and initialize scope
		if (ctx.signature() != null) {
			FlowServiceSignature signature = antlrToExpression.visitSignature(ctx.signature());
			service.setSignature(signature);

			// Initialize scope manager with service signature
			scopeManager.initializeWithSignature(signature);
		}

		for (FlowServiceParser.StepContext stepCtx : ctx.step()) {
			FlowElementExpression visitStep = antlrToExpression.visitStep(stepCtx);
			service.addChild(visitStep);
		}

		return service;

	}
}
