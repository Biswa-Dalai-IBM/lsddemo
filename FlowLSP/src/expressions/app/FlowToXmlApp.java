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

/**
 * Main application to convert .flow files to webMethods flow.xml and node.ndf
 * 
 * Usage: java FlowToXmlApp <input-flow-file> <output-directory>
 * 
 * Example:
 *   java FlowToXmlApp test-3/sample_simple_test.flow output/SimpleTestService
 */
public class FlowToXmlApp {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FlowToXmlApp <input-flow-file> [output-directory]");
            System.err.println();
            System.err.println("Examples:");
            System.err.println("  java FlowToXmlApp test-3/sample_simple_test.flow");
            System.err.println("  java FlowToXmlApp test-3/sample_simple_test.flow output/SimpleTestService");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputDir = args.length > 1 ? args[1] : deriveOutputDir(inputFile);

        System.out.println("=".repeat(60));
        System.out.println("Flow to XML Generator");
        System.out.println("=".repeat(60));
        System.out.println("Input file:  " + inputFile);
        System.out.println("Output dir:  " + outputDir);
        System.out.println();

        try {
            // Parse the flow file
            FlowServiceParser parser = getParser(inputFile);
            if (parser == null) {
                System.err.println("Failed to create parser for file: " + inputFile);
                System.exit(1);
            }

            ParseTree antlrAST = parser.flowService();

            // Check for syntax errors
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("Syntax errors found in input file. Aborting.");
                System.exit(1);
            }

            // Convert to FlowProgram
            AntlrToProgram programVisitor = new AntlrToProgram();
            FlowProgram flowProgram = programVisitor.visit(antlrAST);

            if (flowProgram == null) {
                System.err.println("Failed to parse flow program");
                System.exit(1);
            }

            // Extract service name
            String serviceName = extractServiceName(inputFile, flowProgram);
            System.out.println("Service name: " + serviceName);
            System.out.println();

            // Generate flow.xml and node.ndf
            WebMethodsFlowGenerator generator = new WebMethodsFlowGenerator(outputDir);
            generator.generateFlow(flowProgram, serviceName);

            System.out.println();
            System.out.println("=".repeat(60));
            System.out.println("Generation completed successfully!");
            System.out.println("=".repeat(60));

        } catch (Exception e) {
            System.err.println("Error processing flow file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static FlowServiceParser getParser(String fileName) {
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            FlowServiceLexer lexer = new FlowServiceLexer(input);

            // Add error listener
            lexer.removeErrorListeners();
            lexer.addErrorListener(new org.antlr.v4.runtime.ConsoleErrorListener());

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            FlowServiceParser parser = new FlowServiceParser(tokenStream);

            // Add error listener
            parser.removeErrorListeners();
            parser.addErrorListener(new org.antlr.v4.runtime.ConsoleErrorListener());

            return parser;

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    private static String extractServiceName(String inputFile, FlowProgram program) {
        // Try to get service name from program
        String serviceName = program.serviceName;
        
        if (serviceName == null || serviceName.isEmpty()) {
            // Derive from filename
            File file = new File(inputFile);
            String fileName = file.getName();
            if (fileName.endsWith(".flow")) {
                serviceName = fileName.substring(0, fileName.length() - 5);
            } else {
                serviceName = fileName;
            }
        }
        
        return serviceName;
    }

    private static String deriveOutputDir(String inputFile) {
        File file = new File(inputFile);
        String fileName = file.getName();
        
        // Remove .flow extension
        if (fileName.endsWith(".flow")) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        
        // Create output directory in "output" folder
        return "output" + File.separator + fileName;
    }

    /**
     * Batch process all .flow files in a directory
     */
    public static void processDirectory(String inputDir, String outputBaseDir) {
        File dir = new File(inputDir);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Invalid directory: " + inputDir);
            return;
        }

        File[] flowFiles = dir.listFiles((d, name) -> name.endsWith(".flow"));
        if (flowFiles == null || flowFiles.length == 0) {
            System.out.println("No .flow files found in: " + inputDir);
            return;
        }

        System.out.println("Found " + flowFiles.length + " flow file(s) to process");
        System.out.println();

        int successCount = 0;
        int failCount = 0;

        for (File flowFile : flowFiles) {
            try {
                String outputDir = outputBaseDir + File.separator + 
                                 flowFile.getName().replace(".flow", "");
                
                System.out.println("Processing: " + flowFile.getName());
                main(new String[]{flowFile.getAbsolutePath(), outputDir});
                successCount++;
                
            } catch (Exception e) {
                System.err.println("Failed to process " + flowFile.getName() + ": " + e.getMessage());
                failCount++;
            }
            System.out.println();
        }

        System.out.println("=".repeat(60));
        System.out.println("Batch processing complete");
        System.out.println("Success: " + successCount + ", Failed: " + failCount);
        System.out.println("=".repeat(60));
    }
}

// Made with Bob
