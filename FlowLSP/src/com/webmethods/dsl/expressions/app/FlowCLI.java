package com.webmethods.dsl.expressions.app;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.webmethods.dsl.antlr.FlowServiceLexer;
import com.webmethods.dsl.antlr.FlowServiceParser;
import com.webmethods.dsl.expressions.AntlrToProgram;
import com.webmethods.dsl.expressions.FlowProgram;

/**
 * Command-line interface for Flow DSL operations
 * Merges functionality from FlowDecompiler and ExpressionApp
 */
public class FlowCLI {

	private static final String VERSION = "1.0.0";

	public static void main(String[] args) {
		if (args.length == 0) {
			printUsage();
			return;
		}

		String command = args[0].toLowerCase();

		try {
			switch (command) {
				case "decompile":
					handleDecompile(args);
					break;
				case "compile":
				case "generateflow":
					handleCompile(args);
					break;
				case "version":
					printVersion();
					break;
				case "help":
					printUsage();
					break;
				default:
					System.err.println("Unknown command: " + command);
					printUsage();
					System.exit(1);
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Handle decompile command: flow.xml/node.ndf -> .flow DSL
	 */
	private static void handleDecompile(String[] args) {
		if (args.length < 5) {
			System.err.println("Usage: FlowCLI decompile <flowDirectory> <packageName> <nsname> <outputFile>");
			System.err.println("Example: FlowCLI decompile flow-sample/doUntilService test test:fs1 output.flow");
			System.exit(1);
		}

		File flowDirectory = new File(args[1]);
		String packageName = args[2];
		String nsname = args[3];
		File outputFile = new File(args[4]);

		if (!flowDirectory.exists() || !flowDirectory.isDirectory()) {
			System.err.println("Error: Flow directory does not exist: " + flowDirectory);
			System.exit(1);
		}

		System.out.println("Decompiling flow service...");
		System.out.println("  Source: " + flowDirectory.getAbsolutePath());
		System.out.println("  Package: " + packageName);
		System.out.println("  NS Name: " + nsname);
		System.out.println("  Output: " + outputFile.getAbsolutePath());

		FlowDecompiler decompiler = new FlowDecompiler();
		decompiler.decompileFlow(flowDirectory, packageName, nsname, outputFile);
	}

	/**
	 * Handle compile command: .flow DSL -> flow.xml/node.ndf
	 * Supports both new format and legacy ExpressionApp format
	 */
	private static void handleCompile(String[] args) throws IOException {
		String flowPath = null;
		String installRoot = null;
		String packageName = null;
		String nsname = null;
		File targetFolder = null;

		// Check if using new CLI format or legacy ExpressionApp format
		if (args.length >= 5 && !args[1].startsWith("--")) {
			// New format: compile <flowFile> <targetFolder> <packageName> <nsname> [installRoot]
			flowPath = args[1];
			targetFolder = new File(args[2]);
			packageName = args[3];
			nsname = args[4];
			installRoot = args.length > 5 ? args[5] : null;
		} else {
			// Legacy format: generateFlow --flow <path> --package <name> --nsname <name> [--installRoot <path>]
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
		}

		// Validate required arguments
		if (flowPath == null || packageName == null || nsname == null) {
			System.err.println("Error: Missing required arguments");
			System.err.println();
			System.err.println("Usage (new format):");
			System.err.println("  FlowCLI compile <flowFile> <targetFolder> <packageName> <nsname> [installRoot]");
			System.err.println();
			System.err.println("Usage (legacy format):");
			System.err.println("  FlowCLI generateFlow --flow <flowPath> --package <packageName> --nsname <nsname> [--installRoot <installRoot>]");
			System.err.println();
			System.err.println("Examples:");
			System.err.println("  FlowCLI compile input.flow output test test:fs1");
			System.err.println("  FlowCLI generateFlow --flow input.flow --package test --nsname test:fs1");
			System.exit(1);
		}

		File flowFile = new File(flowPath);
		if (!flowFile.exists()) {
			System.err.println("Error: Flow file does not exist: " + flowFile);
			System.exit(1);
		}

		// If targetFolder not set (legacy format), use parent directory of flow file
		if (targetFolder == null) {
			targetFolder = flowFile.getParentFile();
		}

		System.out.println("Compiling flow service...");
		System.out.println("  Source: " + flowFile.getAbsolutePath());
		System.out.println("  Target: " + targetFolder.getAbsolutePath());
		System.out.println("  Package: " + packageName);
		System.out.println("  NS Name: " + nsname);
		if (installRoot != null) {
			System.out.println("  Install Root: " + installRoot);
		}

		// Parse the .flow file using ANTLR (ExpressionApp approach)
		FlowServiceParser parser = getParser(flowPath);
		if (parser == null) {
			System.err.println("Error: Failed to parse flow file: " + flowPath);
			System.exit(1);
		}

		ParseTree antlrAST = parser.flowService();

		// Convert ANTLR AST to FlowProgram
		AntlrToProgram program = new AntlrToProgram();
		FlowProgram flowProgram = program.visit(antlrAST);

		// Generate flow.xml and node.ndf
		FlowGenerator flowGenerator = new FlowGenerator();
		flowGenerator.generateFlow(flowProgram, targetFolder, packageName, nsname, installRoot);

		System.out.println("Successfully compiled flow to: " + targetFolder.getAbsolutePath());
	}

	/**
	 * Get ANTLR parser for a flow file (from ExpressionApp)
	 */
	private static FlowServiceParser getParser(String fileName) {
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			FlowServiceLexer lexer = new FlowServiceLexer(input);
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			return new FlowServiceParser(tokenStream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Print version information
	 */
	private static void printVersion() {
		System.out.println("Flow DSL CLI - Version " + VERSION);
		System.out.println("A tool for compiling and decompiling webMethods Flow services");
		System.out.println("Merges functionality from FlowDecompiler and ExpressionApp");
	}

	/**
	 * Print usage information
	 */
	private static void printUsage() {
		System.out.println("Flow DSL CLI - Version " + VERSION);
		System.out.println();
		System.out.println("Usage: FlowCLI <command> [options]");
		System.out.println();
		System.out.println("Commands:");
		System.out.println("  decompile    Convert flow.xml/node.ndf to .flow DSL");
		System.out.println("  compile      Convert .flow DSL to flow.xml/node.ndf");
		System.out.println("  generateFlow Legacy alias for compile command");
		System.out.println("  version      Show version information");
		System.out.println("  help         Show this help message");
		System.out.println();
		System.out.println("Decompile Usage:");
		System.out.println("  FlowCLI decompile <flowDirectory> <packageName> <nsname> <outputFile>");
		System.out.println();
		System.out.println("  Example:");
		System.out.println("    FlowCLI decompile flow-sample/doUntilService test test:fs1 output.flow");
		System.out.println();
		System.out.println("Compile Usage (New Format):");
		System.out.println("  FlowCLI compile <flowFile> <targetFolder> <packageName> <nsname> [installRoot]");
		System.out.println();
		System.out.println("  Examples:");
		System.out.println("    FlowCLI compile input.flow output test test:fs1");
		System.out.println("    FlowCLI compile input.flow output test test:fs1 /opt/softwareag");
		System.out.println();
		System.out.println("Compile Usage (Legacy Format - ExpressionApp compatible):");
		System.out.println("  FlowCLI generateFlow --flow <flowPath> --package <packageName> --nsname <nsname> [--installRoot <installRoot>]");
		System.out.println();
		System.out.println("  Example:");
		System.out.println("    FlowCLI generateFlow --flow input.flow --package test --nsname test:fs1 --installRoot /opt/softwareag");
		System.out.println();
	}
}

// Made with Bob
