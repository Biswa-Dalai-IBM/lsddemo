package expressions.app;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.FlowServiceLexer;
import antlr.FlowServiceParser;
import expressions.AntlrToProgram;
import expressions.FlowProgram;

public class ExpressionApp {

	public static void main(String[] args) throws IOException {
		// Check if using new CLI format
		if (args.length > 0 && args[0].equals("generateFlow")) {
			handleGenerateFlowCommand(args);
		} else if (args.length == 1) {
			// Legacy format: single file argument
			String fileName = args[0];
			FlowServiceParser parser = getParser(fileName);
			ParseTree antlrAST = parser.flowService();
			
			AntlrToProgram program = new AntlrToProgram();
			FlowProgram flowProgram = program.visit(antlrAST);
			FlowGenerator flowGenerator = new FlowGenerator();
			flowGenerator.generateFlow(flowProgram, new File(fileName).getParentFile(), "test", "test:fs1", null);
		} else {
			printUsage();
		}
	}
	
	private static void handleGenerateFlowCommand(String[] args) throws IOException {
		String flowPath = null;
		String installRoot = null;
		String packageName = null;
		String nsname = null;
		
		// Parse command line arguments
		for (int i = 1; i < args.length; i++) {
			if (args[i].equals("--flow") && i + 1 < args.length) {
				flowPath = args[++i];
			} else if (args[i].equals("--installRoot") && i + 1 < args.length) {
				installRoot = args[++i];
			} else if (args[i].equals("--package") && i + 1 < args.length) {
				packageName = args[++i];
			} else if (args[i].equals("--nsname") && i + 1 < args.length) {
				nsname = args[++i];
			}
		}
		
		// Validate required arguments
		if (flowPath == null || packageName == null || nsname == null) {
			System.err.println("Error: Missing required arguments");
			printUsage();
			return;
		}
		
		// Parse the flow file
		FlowServiceParser parser = getParser(flowPath);
		if (parser == null) {
			System.err.println("Error: Failed to parse flow file: " + flowPath);
			return;
		}
		
		ParseTree antlrAST = parser.flowService();
		
		// Generate the flow program
		AntlrToProgram program = new AntlrToProgram();
		FlowProgram flowProgram = program.visit(antlrAST);
		
		// Generate the flow
		FlowGenerator flowGenerator = new FlowGenerator();
		File targetFolder = new File(flowPath).getParentFile();
		flowGenerator.generateFlow(flowProgram, targetFolder, packageName, nsname, installRoot);
		
		System.out.println("Flow generated successfully!");
		System.out.println("  Flow: " + flowPath);
		System.out.println("  Package: " + packageName);
		System.out.println("  NS Name: " + nsname);
		System.out.println("  Target: " + targetFolder.getAbsolutePath());
		if (installRoot != null) {
			System.out.println("  Install Root: " + installRoot);
		}
	}
	
	private static void printUsage() {
		System.err.println("Usage:");
		System.err.println("  generateFlow --flow <flow-path> --package <package-name> --nsname <nsname> [--installRoot <installRoot>]");
		System.err.println();
		System.err.println("Example:");
		System.err.println("  generateFlow --flow C:\\path\\to\\service.flow --installRoot C:\\ESB_BUILDS\\ESB_12012 --package test --nsname test:fs1");
		System.err.println();
		System.err.println("Legacy usage:");
		System.err.println("  <flow-file-path>");
	}
	
	private static FlowServiceParser getParser(String fileName) {
		FlowServiceParser parser = null;
		
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			FlowServiceLexer lexer = new FlowServiceLexer(input);
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			parser = new FlowServiceParser(tokenStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return parser;
	}

}
