package expressions.app;

import java.io.File;

/**
 * Batch processor for converting multiple .flow files to webMethods XML format
 * 
 * Usage: java BatchProcessFlows <input-directory> [output-base-directory]
 * 
 * Example:
 *   java BatchProcessFlows test-3 output
 */
public class BatchProcessFlows {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java BatchProcessFlows <input-directory> [output-base-directory]");
            System.err.println();
            System.err.println("Examples:");
            System.err.println("  java BatchProcessFlows test-3");
            System.err.println("  java BatchProcessFlows test-3 output");
            System.exit(1);
        }

        String inputDir = args[0];
        String outputBaseDir = args.length > 1 ? args[1] : "output";

        System.out.println("=".repeat(70));
        System.out.println("Batch Flow to XML Generator");
        System.out.println("=".repeat(70));
        System.out.println("Input directory:  " + inputDir);
        System.out.println("Output base dir:  " + outputBaseDir);
        System.out.println();

        File dir = new File(inputDir);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Error: Invalid directory: " + inputDir);
            System.exit(1);
        }

        File[] flowFiles = dir.listFiles((d, name) -> name.endsWith(".flow"));
        if (flowFiles == null || flowFiles.length == 0) {
            System.out.println("No .flow files found in: " + inputDir);
            System.exit(0);
        }

        System.out.println("Found " + flowFiles.length + " flow file(s) to process");
        System.out.println("=".repeat(70));
        System.out.println();

        int successCount = 0;
        int failCount = 0;

        for (int i = 0; i < flowFiles.length; i++) {
            File flowFile = flowFiles[i];
            
            System.out.println("[" + (i + 1) + "/" + flowFiles.length + "] Processing: " + flowFile.getName());
            System.out.println("-".repeat(70));
            
            try {
                String fileName = flowFile.getName().replace(".flow", "");
                String outputDir = outputBaseDir + File.separator + fileName;
                
                // Call FlowToXmlApp for each file
                FlowToXmlApp.main(new String[]{flowFile.getAbsolutePath(), outputDir});
                
                successCount++;
                System.out.println("✓ Success");
                
            } catch (Exception e) {
                System.err.println("✗ Failed: " + e.getMessage());
                e.printStackTrace();
                failCount++;
            }
            
            System.out.println();
        }

        System.out.println("=".repeat(70));
        System.out.println("Batch Processing Summary");
        System.out.println("=".repeat(70));
        System.out.println("Total files:    " + flowFiles.length);
        System.out.println("Successful:     " + successCount + " ✓");
        System.out.println("Failed:         " + failCount + (failCount > 0 ? " ✗" : ""));
        System.out.println("Success rate:   " + String.format("%.1f%%", (successCount * 100.0 / flowFiles.length)));
        System.out.println("=".repeat(70));
        
        if (failCount > 0) {
            System.exit(1);
        }
    }
}

// Made with Bob
