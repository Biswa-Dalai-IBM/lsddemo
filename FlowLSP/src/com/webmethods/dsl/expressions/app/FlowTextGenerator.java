package com.webmethods.dsl.expressions.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.webmethods.dsl.expressions.FlowProgram;
import com.webmethods.dsl.expressions.FlowTextContext;

/**
 * Generates .flow DSL text file from FlowProgram using Visitor Pattern.
 * 
 * This class has been refactored to use the Visitor Pattern where each
 * expression generates its own text representation via generateText().
 * 
 * Benefits:
 * - Single Responsibility: Each expression knows how to format itself
 * - Open/Closed Principle: New expressions don't require changes here
 * - Reduced complexity: From 600+ lines to ~50 lines
 * - Better maintainability: Logic is distributed to appropriate classes
 * 
 * @author Bob (Refactored with Visitor Pattern)
 */
public class FlowTextGenerator {

	/**
	 * Generate .flow file from FlowProgram using Visitor Pattern
	 * 
	 * @param program    The flow program
	 * @param outputFile The output .flow file
	 */
	public void generateFlowFile(FlowProgram program, File outputFile) {
		// Create context for text generation
		FlowTextContext context = new FlowTextContext();
		
		// Delegate to FlowProgram to generate its text
		// FlowProgram will recursively call generateText() on all children
		program.generateText(context);
		
		// Write to file
		writeToFile(outputFile, context.getText());
	}
	
	/**
	 * Write generated text to file
	 * 
	 * @param file The output file
	 * @param content The generated content
	 */
	private void writeToFile(File file, String content) {
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(content);
			System.out.println("Flow file generated: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Error writing flow file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

// Made with Bob
