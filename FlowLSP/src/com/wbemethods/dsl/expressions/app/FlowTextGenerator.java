package com.wbemethods.dsl.expressions.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.wbemethods.dsl.expressions.FlowElementExpression;
import com.wbemethods.dsl.expressions.FlowProgram;
import com.wbemethods.dsl.expressions.FlowServiceSignature;
import com.wbemethods.dsl.expressions.MapSignature;
import com.wbemethods.dsl.expressions.ParameterDeclaration;
import com.wbemethods.dsl.expressions.flow.FlowBranchExpression;
import com.wbemethods.dsl.expressions.flow.FlowCaseExpression;
import com.wbemethods.dsl.expressions.flow.FlowCatchExpression;
import com.wbemethods.dsl.expressions.flow.FlowContainerExpression;
import com.wbemethods.dsl.expressions.flow.FlowDoUntilExpression;
import com.wbemethods.dsl.expressions.flow.FlowElseExpression;
import com.wbemethods.dsl.expressions.flow.FlowElseIfExpression;
import com.wbemethods.dsl.expressions.flow.FlowExitExpression;
import com.wbemethods.dsl.expressions.flow.FlowFinallyExpression;
import com.wbemethods.dsl.expressions.flow.FlowIfThenElseExpression;
import com.wbemethods.dsl.expressions.flow.FlowInvokeExpression;
import com.wbemethods.dsl.expressions.flow.FlowLoopExpression;
import com.wbemethods.dsl.expressions.flow.FlowRepeatExpression;
import com.wbemethods.dsl.expressions.flow.FlowSequenceExpression;
import com.wbemethods.dsl.expressions.flow.FlowStepProperty;
import com.wbemethods.dsl.expressions.flow.FlowSwitchExpression;
import com.wbemethods.dsl.expressions.flow.FlowTryExpression;
import com.wbemethods.dsl.expressions.flow.FlowWhileExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapCopyExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapDropExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapElementExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapInvokeExpression;
import com.wbemethods.dsl.expressions.flow.map.FlowMapSetExpression;
import com.wbemethods.dsl.expressions.flow.map.MapIOExprssion;

/**
 * Generates .flow DSL text file from FlowProgram based on FlowService.g4
 * grammar
 */
public class FlowTextGenerator {

	private StringBuilder output;
	private int indentLevel;
	private static final String INDENT = "    ";

	public FlowTextGenerator() {
		this.output = new StringBuilder();
		this.indentLevel = 0;
	}

	/**
	 * Generate .flow file from FlowProgram
	 * 
	 * @param program    The flow program
	 * @param outputFile The output .flow file
	 */
	public void generateFlowFile(FlowProgram program, File outputFile) {
		output = new StringBuilder();
		indentLevel = 0;

		// Generate service declaration
		String serviceName = program.serviceName != null ? program.serviceName : "generatedService";
		append("service " + serviceName);

		// Generate signature if present
		if (program.hasSignature()) {
			append(" (");
			appendLine("");
			indentLevel++;
			generateSignature(program.getSignature());
			indentLevel--;
			append(")");
		}

		appendLine(" {");
		indentLevel++;

		// Generate flow steps
		List<FlowElementExpression> expressions = program.getExpressions();
		if (expressions != null && !expressions.isEmpty()) {
			for (FlowElementExpression expr : expressions) {
				generateExpression(expr);
			}
		}

		indentLevel--;
		appendLine("}");

		// Write to file
		writeToFile(outputFile);
	}

	/**
	 * Generate signature (input/output blocks) based on grammar
	 */
	private void generateSignature(FlowServiceSignature signature) {
		// Generate input block
		if (signature.hasInputParameters()) {
			appendLine("input {");
			indentLevel++;
			for (ParameterDeclaration param : signature.getInputParameters()) {
				generateParameterDeclaration(param);
			}
			indentLevel--;
			appendLine("}");
		}

		// Generate output block
		if (signature.hasOutputParameters()) {
			appendLine("output {");
			indentLevel++;
			for (ParameterDeclaration param : signature.getOutputParameters()) {
				generateParameterDeclaration(param);
			}
			indentLevel--;
			appendLine("}");
		}
	}

	/**
	 * Generate parameter declaration based on grammar
	 */
	private void generateParameterDeclaration(ParameterDeclaration param) {
		if (param.isField()) {
			// fieldDeclaration: dataType ('[' ']')? identifier constraints? ';'
			String arrayStr = param.isArray() ? "[] " : " ";
			appendLine(param.getDataType() + arrayStr + param.getName() + ";");
		} else if (param.isRecord()) {
			// recordDeclaration: 'record' identifier '{' parameterDeclaration* '}'
			// constraints? ';'
			appendLine("record " + param.getName() + " {");
			indentLevel++;
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					generateParameterDeclaration(child);
				}
			}
			indentLevel--;
			appendLine("};");
		} else if (param.isRecordList()) {
			// recordListDeclaration: 'recordList' identifier '{' parameterDeclaration* '}'
			// constraints? ';'
			appendLine("recordList " + param.getName() + " {");
			indentLevel++;
			if (param.hasChildren()) {
				for (ParameterDeclaration child : param.getChildren()) {
					generateParameterDeclaration(child);
				}
			}
			indentLevel--;
			appendLine("};");
		}
	}

	/**
	 * Generate expression based on type
	 */
	private void generateExpression(FlowElementExpression expr) {
		if (expr instanceof FlowInvokeExpression) {
			generateInvokeStep((FlowInvokeExpression) expr);
		} else if (expr instanceof FlowMapElementExpression) {
			generateMapStep((FlowMapElementExpression) expr);
		} else if (expr instanceof FlowLoopExpression) {
			generateLoopStep((FlowLoopExpression) expr);
		} else if (expr instanceof FlowSequenceExpression) {
			generateSequenceStep((FlowSequenceExpression) expr);
		} else if (expr instanceof FlowBranchExpression) {
			generateBranchStep((FlowBranchExpression) expr);
		} else if (expr instanceof FlowRepeatExpression) {
			generateRepeatStep((FlowRepeatExpression) expr);
		} else if (expr instanceof FlowTryExpression) {
			generateTryStep((FlowTryExpression) expr);
		} else if (expr instanceof FlowExitExpression) {
			generateExitStep((FlowExitExpression) expr);
		} else if (expr instanceof FlowDoUntilExpression) {
			generateDoUntilStep((FlowDoUntilExpression) expr);
		} else if (expr instanceof FlowIfThenElseExpression) {
			generateIfThenStep((FlowIfThenElseExpression) expr);
		} else if (expr instanceof FlowSwitchExpression) {
			generateSwitchCaseStep((FlowSwitchExpression) expr);
		} else if (expr instanceof FlowWhileExpression) {
			generateWhileStep((FlowWhileExpression) expr);
		}
	}

	/**
	 * Generate INVOKE step based on grammar
	 */
	private void generateInvokeStep(FlowInvokeExpression expr) {
		append("INVOKE " + expr.getServiceName());

		MapIOExprssion input = expr.getInput();
		MapIOExprssion output = expr.getOutput();
		List<FlowStepProperty> properties = expr.getProperties();

		if ((input != null && input.hasMapSignature()) || (output != null && output.hasMapSignature())
				|| (properties != null && !properties.isEmpty())) {
			appendLine(" {");
			indentLevel++;

			// Generate properties
			if (properties != null) {
				for (FlowStepProperty prop : properties) {
					generateStepProperty(prop);
				}
			}

			// Generate input mapping block
			if (input != null && input.hasMapSignature()) {
				generateMappingBlock(input, true);
			}

			// Generate output mapping block
			if (output != null && output.hasMapSignature()) {
				generateMappingBlock(output, false);
			}

			indentLevel--;
			appendLine("};");
		} else {
			appendLine(";");
		}
	}

	/**
	 * Generate mapping block (input/output) for INVOKE
	 */
	private void generateMappingBlock(MapIOExprssion mapIO, boolean isInput) {
		String blockName = isInput ? "input" : "output";
		appendLine(blockName + " {");
		indentLevel++;

		// Generate mapSignature if present
		if (mapIO.getMapSignature() != null) {
			generateMapSignatureBlock(mapIO.getMapSignature(), isInput);
		}

		// Generate mapping expressions
		List<FlowMapExpression> mapExpressions = mapIO.getMapExpressions();
		if (mapExpressions != null) {
			for (FlowElementExpression mapExpr : mapExpressions) {
				generateMapExpression(mapExpr);
			}
		}

		indentLevel--;
		appendLine("}");
	}

	/**
	 * Generate mapSignatureBlock based on grammar
	 */
	private void generateMapSignatureBlock(MapSignature mapSig, boolean forInput) {
		// For input block, generate mapSource
		if (forInput && mapSig.hasSourceParameters()) {
			append("mapSource");
			if (mapSig.getSourceIdentifier() != null) {
				append("[" + mapSig.getSourceIdentifier() + "]");
			}
			appendLine("{");
			indentLevel++;
			for (ParameterDeclaration param : mapSig.getSourceParameters()) {
				generateParameterDeclaration(param);
			}
			indentLevel--;
			appendLine("}");
		}

		// For output block or input block, generate mapTarget
		if (mapSig.hasTargetParameters()) {
			append("mapTarget");
			if (mapSig.getTargetIdentifier() != null) {
				append("[" + mapSig.getTargetIdentifier() + "]");
			}
			appendLine("{");
			indentLevel++;
			for (ParameterDeclaration param : mapSig.getTargetParameters()) {
				generateParameterDeclaration(param);
			}
			indentLevel--;
			appendLine("}");
		}
	}

	/**
	 * Generate MAP step based on grammar
	 */
	private void generateMapStep(FlowMapElementExpression expr) {
		append("MAP");

		List<FlowMapExpression> mapExpressions = expr.getMapExpressions();
		MapSignature mapSignature = expr.getMapSignature();
		List<FlowStepProperty> properties = expr.getProperties();

		if ((mapExpressions != null && !mapExpressions.isEmpty()) || mapSignature != null
				|| (properties != null && !properties.isEmpty())) {
			appendLine(" {");
			indentLevel++;

			// Generate properties
			if (properties != null) {
				for (FlowStepProperty prop : properties) {
					generateStepProperty(prop);
				}
			}

			// Generate mapSignature
			if (mapSignature != null) {
				if (mapSignature.hasSourceParameters()) {
					append("mapSource");
					if (mapSignature.getSourceIdentifier() != null) {
						append("[" + mapSignature.getSourceIdentifier() + "]");
					}
					appendLine("{");
					indentLevel++;
					for (ParameterDeclaration param : mapSignature.getSourceParameters()) {
						generateParameterDeclaration(param);
					}
					indentLevel--;
					appendLine("}");
				}
				if (mapSignature.hasTargetParameters()) {
					append("mapTarget");
					if (mapSignature.getTargetIdentifier() != null) {
						append("[" + mapSignature.getTargetIdentifier() + "]");
					}
					appendLine("{");
					indentLevel++;
					for (ParameterDeclaration param : mapSignature.getTargetParameters()) {
						generateParameterDeclaration(param);
					}
					indentLevel--;
					appendLine("}");
				}
			}

			// Generate mapping expressions
			if (mapExpressions != null) {
				for (FlowElementExpression mapExpr : mapExpressions) {
					generateMapExpression(mapExpr);
				}
			}

			indentLevel--;
			appendLine("};");
		} else {
			appendLine(";");
		}
	}

	/**
	 * Generate map expression (copy, set, drop, transform)
	 */
	private void generateMapExpression(FlowElementExpression expr) {
		if (expr instanceof FlowMapCopyExpression) {
			FlowMapCopyExpression copyExpr = (FlowMapCopyExpression) expr;
			appendLine("copy " + copyExpr.getFrom() + " -> " + copyExpr.getTo() + ";");
		} else if (expr instanceof FlowMapSetExpression) {
			FlowMapSetExpression setExpr = (FlowMapSetExpression) expr;
			appendLine("set " + setExpr.getFieldPath() + " = " + setExpr.getValue() + ";");
		} else if (expr instanceof FlowMapDropExpression) {
			FlowMapDropExpression dropExpr = (FlowMapDropExpression) expr;
			appendLine("drop " + dropExpr.getFieldName() + ";");
		} else if (expr instanceof FlowMapInvokeExpression) {
			FlowMapInvokeExpression invokeExpr = (FlowMapInvokeExpression) expr;
			appendLine("TRANSFORM " + invokeExpr.getServiceName() + ";");
		}
	}

	/**
	 * Generate LOOP step
	 */
	private void generateLoopStep(FlowLoopExpression expr) {
		appendLine("LOOP {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		appendLine("};");
	}

	/**
	 * Generate SEQUENCE step
	 */
	private void generateSequenceStep(FlowSequenceExpression expr) {
		appendLine("SEQUENCE {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		appendLine("};");
	}

	/**
	 * Generate BRANCH step
	 */
	private void generateBranchStep(FlowBranchExpression expr) {
		appendLine("BRANCH {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		appendLine("};");
	}

	/**
	 * Generate REPEAT step
	 */
	private void generateRepeatStep(FlowRepeatExpression expr) {
		appendLine("REPEAT {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		appendLine("};");
	}

	/**
	 * Generate TRY step
	 */
	private void generateTryStep(FlowTryExpression expr) {
		appendLine("TRY {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		append("}");

		// Generate CATCH blocks
		List<FlowCatchExpression> catchExpressions = expr.getCatchExpressions();
		if (catchExpressions != null) {
			for (FlowCatchExpression catchExpr : catchExpressions) {
				appendLine(" CATCH {");
				indentLevel++;
				generateContainerContent(catchExpr);
				indentLevel--;
				append("}");
			}
		}

		// Generate FINALLY block
		FlowFinallyExpression finallyExpr = expr.getFinallyExpression();
		if (finallyExpr != null) {
			appendLine(" FINALLY {");
			indentLevel++;
			generateContainerContent(finallyExpr);
			indentLevel--;
			append("}");
		}

		appendLine(";");
	}

	/**
	 * Generate EXIT step
	 */
	private void generateExitStep(FlowExitExpression expr) {
		List<FlowStepProperty> properties = expr.getProperties();
		if (properties != null && !properties.isEmpty()) {
			appendLine("EXIT {");
			indentLevel++;
			for (FlowStepProperty prop : properties) {
				generateStepProperty(prop);
			}
			indentLevel--;
			appendLine("};");
		} else {
			appendLine("EXIT;");
		}
	}

	/**
	 * Generate DO UNTIL step
	 */
	private void generateDoUntilStep(FlowDoUntilExpression expr) {
		appendLine("DO {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		appendLine("} UNTIL (" + expr.getUntilCondition() + ");");
	}

	/**
	 * Generate IF THEN ELSE step
	 */
	private void generateIfThenStep(FlowIfThenElseExpression expr) {
		appendLine("IF (" + expr.getCondition() + ") {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		append("}");

		// Generate ELSEIF blocks
		List<FlowElseIfExpression> elseIfExpressions = expr.getElseIfExpressions();
		if (elseIfExpressions != null) {
			for (FlowElseIfExpression elseIfExpr : elseIfExpressions) {
				appendLine(" ELSEIF (" + elseIfExpr.getCondition() + ") {");
				indentLevel++;
				generateContainerContent(elseIfExpr);
				indentLevel--;
				append("}");
			}
		}

		// Generate ELSE block
		FlowElseExpression elseExpr = expr.getElseExpression();
		if (elseExpr != null) {
			appendLine(" ELSE {");
			indentLevel++;
			generateContainerContent(elseExpr);
			indentLevel--;
			append("}");
		}

		appendLine(";");
	}

	/**
	 * Generate SWITCH CASE step
	 */
	private void generateSwitchCaseStep(FlowSwitchExpression expr) {
		appendLine("SWITCH (" + expr.getSwitchKey() + ") {");
		indentLevel++;

		List<FlowElementExpression> children = expr.getExpressions();
		if (children != null) {
			for (FlowElementExpression child : children) {
				if (child instanceof FlowCaseExpression) {
					FlowCaseExpression caseExpr = (FlowCaseExpression) child;
					appendLine("CASE " + caseExpr.getCaseValue() + ":");
					indentLevel++;
					generateContainerContent(caseExpr);
					indentLevel--;
				}
			}
		}

		indentLevel--;
		appendLine("};");
	}

	/**
	 * Generate WHILE step
	 */
	private void generateWhileStep(FlowWhileExpression expr) {
		appendLine("WHILE (" + expr.getCondition() + ") {");
		indentLevel++;
		generateContainerContent(expr);
		indentLevel--;
		appendLine("}");
	}

	/**
	 * Generate container content (properties and children)
	 */
	private void generateContainerContent(FlowContainerExpression container) {
		// Generate properties
		List<FlowStepProperty> properties = container.getProperties();
		if (properties != null) {
			for (FlowStepProperty prop : properties) {
				generateStepProperty(prop);
			}
		}

		// Generate children
		List<FlowElementExpression> children = container.getExpressions();
		if (children != null) {
			for (FlowElementExpression child : children) {
				generateExpression(child);
			}
		}
	}

	/**
	 * Generate step property
	 */
	private void generateStepProperty(FlowStepProperty prop) {
		appendLine(prop.getKey() + ": " + prop.getValue() + ";");
	}

	/**
	 * Append text without newline
	 */
	private void append(String text) {
		output.append(text);
	}

	/**
	 * Append line with proper indentation
	 */
	private void appendLine(String line) {
		for (int i = 0; i < indentLevel; i++) {
			output.append(INDENT);
		}
		output.append(line).append("\n");
	}

	/**
	 * Write output to file
	 */
	private void writeToFile(File file) {
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(output.toString());
			System.out.println("Flow file generated: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error writing flow file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

// Made with Bob
