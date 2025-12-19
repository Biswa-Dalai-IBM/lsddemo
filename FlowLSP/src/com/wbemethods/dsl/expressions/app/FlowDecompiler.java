package com.wbemethods.dsl.expressions.app;

import java.io.File;

import com.wbemethods.dsl.expressions.FlowProgram;
import com.wbemethods.dsl.expressions.FlowServiceSignature;
import com.webmethods.dsl.serverjars.utils.FlowUtils;
import com.wm.app.b2b.server.FlowSvcImpl;
import com.wm.lang.flow.FlowRoot;
import com.wm.lang.ns.NSSignature;

/**
 * Decompiles flow.xml and node.ndf files into FlowProgram and generates .flow
 * DSL text
 */
public class FlowDecompiler {

	/**
	 * Load flow service from directory and generate .flow file
	 * 
	 * @param flowDirectory Directory containing flow.xml and node.ndf (e.g.,
	 *                      FlowLSP/flow-sample/doUntilService)
	 * @param packageName   Package name (e.g., "test")
	 * @param nsname        Namespace name (e.g., "test:fs1")
	 * @param outputFile    Output .flow file
	 */
	public void decompileFlow(File flowDirectory, String packageName, String nsname, File outputFile) {
		try {
			// Load flow service using FlowUtils
			FlowSvcImpl flowSvc = FlowUtils.loadFlowService(flowDirectory, packageName, nsname);

			if (flowSvc == null) {
				System.err.println("Failed to load flow service from: " + flowDirectory);
				return;
			}

			// Get FlowRoot and NSSignature
			FlowRoot flowRoot = flowSvc.getFlowRoot();
			NSSignature signature = flowSvc.getSignature();

			// Convert to FlowProgram
			FlowProgram program = convertToFlowProgram(flowRoot, signature, nsname);

			// Generate .flow file
			FlowTextGenerator generator = new FlowTextGenerator();
			generator.generateFlowFile(program, outputFile);

			System.out.println("Successfully decompiled flow to: " + outputFile.getAbsolutePath());

		} catch (Exception e) {
			System.err.println("Error decompiling flow: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Convert FlowRoot and NSSignature to FlowProgram
	 */
	private FlowProgram convertToFlowProgram(FlowRoot flowRoot, NSSignature signature, String nsname) {
		FlowProgram program = new FlowProgram();

		// Set service name from nsname (e.g., "test:fs1" -> "fs1")
		String serviceName = nsname.contains(":") ? nsname.substring(nsname.indexOf(":") + 1) : nsname;
		program.setLabel(serviceName);

		// Convert signature
		if (signature != null) {
			FlowServiceSignature flowSignature = new FlowServiceSignature();
			flowSignature.updateSignature(signature);
			program.setSignature(flowSignature);
		}

		// Convert flow elements
		if (flowRoot != null) {
			program.updateExpression(flowRoot);
		}

		return program;
	}

	/**
	 * Main method for testing
	 */
	public static void main(String[] args) {
		if (args.length < 4) {
			System.err.println("Usage: FlowDecompiler <flowDirectory> <packageName> <nsname> <outputFile>");
			System.err.println("Example: FlowDecompiler FlowLSP/flow-sample/doUntilService test test:fs1 output.flow");
			return;
		}

		File flowDirectory = new File(args[0]);
		String packageName = args[1];
		String nsname = args[2];
		File outputFile = new File(args[3]);

		FlowDecompiler decompiler = new FlowDecompiler();
		decompiler.decompileFlow(flowDirectory, packageName, nsname, outputFile);
	}
}

// Made with Bob
