package expressions.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import expressions.FlowElementExpression;
import expressions.FlowProgram;
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
import expressions.flow.map.FlowMapSetExpression;
import expressions.flow.map.MapIOExprssion;

/**
 * Enhanced Flow Generator that creates webMethods flow.xml and node.ndf files
 * Updated to match actual webMethods flow.xml format
 */
public class WebMethodsFlowGenerator {
    
    private int nodeIdCounter = 0;
    private StringBuilder flowXml;
    private StringBuilder nodeNdf;
    private String serviceName;
    private String outputDir;
    
    public WebMethodsFlowGenerator(String outputDir) {
        this.outputDir = outputDir;
    }
    
    public void generateFlow(FlowProgram program, String serviceName) {
        this.serviceName = serviceName;
        this.nodeIdCounter = 0;
        this.flowXml = new StringBuilder();
        this.nodeNdf = new StringBuilder();
        
        // Generate flow.xml
        generateFlowXml(program);
        
        // Generate node.ndf
        generateNodeNdf(program);
        
        // Write files
        writeFiles(serviceName);
    }
    
    private void generateFlowXml(FlowProgram program) {
        flowXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n");
        flowXml.append("<FLOW VERSION=\"3.2\" CLEANUP=\"true\">\n\n");
        flowXml.append("  <!-- nodes -->\n\n");
        
        List<FlowElementExpression> expressions = program.getExpressions();
        for (FlowElementExpression expr : expressions) {
            generateStepXml(expr, 0);
        }
        
        flowXml.append("</FLOW>\n");
    }
    
    private void generateStepXml(FlowElementExpression expr, int indent) {
        String indentStr = "  ".repeat(indent);
        
        if (expr instanceof FlowTryExpression) {
            // Handle TRY block - children will include CATCH and FINALLY
            FlowTryExpression tryExpr = (FlowTryExpression) expr;
            
            // Generate TRY block
            flowXml.append(indentStr).append("<SEQUENCE TIMEOUT=\"\" EXIT-ON=\"FAILURE\" FORM=\"TRY\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            // Process children - separate TRY steps from CATCH/FINALLY
            List<FlowElementExpression> trySteps = new ArrayList<>();
            List<FlowCatchExpression> catchBlocks = new ArrayList<>();
            FlowFinallyExpression finallyBlock = null;
            
            for (FlowElementExpression child : tryExpr.getExpressions()) {
                if (child instanceof FlowCatchExpression) {
                    catchBlocks.add((FlowCatchExpression) child);
                } else if (child instanceof FlowFinallyExpression) {
                    finallyBlock = (FlowFinallyExpression) child;
                } else {
                    trySteps.add(child);
                }
            }
            
            // Add TRY block steps
            for (FlowElementExpression child : trySteps) {
                generateStepXml(child, indent + 1);
            }
            
            flowXml.append(indentStr).append("</SEQUENCE>\n\n");
            
            // Generate CATCH blocks
            for (FlowCatchExpression catchExpr : catchBlocks) {
                flowXml.append(indentStr).append("<SEQUENCE TIMEOUT=\"\" EXIT-ON=\"FAILURE\" FORM=\"CATCH\">\n");
                flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
                flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
                
                for (FlowElementExpression child : catchExpr.getExpressions()) {
                    generateStepXml(child, indent + 1);
                }
                
                flowXml.append(indentStr).append("</SEQUENCE>\n\n");
            }
            
            // Generate FINALLY block if present
            if (finallyBlock != null) {
                flowXml.append(indentStr).append("<SEQUENCE TIMEOUT=\"\" EXIT-ON=\"FAILURE\" FORM=\"FINALLY\">\n");
                flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
                flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
                
                for (FlowElementExpression child : finallyBlock.getExpressions()) {
                    generateStepXml(child, indent + 1);
                }
                
                flowXml.append(indentStr).append("</SEQUENCE>\n");
            }
            
        } else if (expr instanceof FlowSequenceExpression) {
            FlowSequenceExpression seqExpr = (FlowSequenceExpression) expr;
            
            flowXml.append(indentStr).append("<SEQUENCE TIMEOUT=\"\" EXIT-ON=\"FAILURE\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            // Add child steps
            for (FlowElementExpression child : seqExpr.getExpressions()) {
                generateStepXml(child, indent + 1);
            }
            
            flowXml.append(indentStr).append("</SEQUENCE>\n\n");
            
        } else if (expr instanceof FlowInvokeExpression) {
            FlowInvokeExpression invokeExpr = (FlowInvokeExpression) expr;
            String timeout = getPropertyValue(invokeExpr.getProperties(), "timeout", "");
            String validateIn = getPropertyValue(invokeExpr.getProperties(), "validateInput", "$none");
            String validateOut = getPropertyValue(invokeExpr.getProperties(), "validateOutput", "$none");
            
            flowXml.append(indentStr).append("<INVOKE TIMEOUT=\"").append(timeout).append("\" ");
            flowXml.append("SERVICE=\"").append(escapeXml(invokeExpr.getServiceName())).append("\" ");
            flowXml.append("VALIDATE-IN=\"").append(validateIn).append("\" ");
            flowXml.append("VALIDATE-OUT=\"").append(validateOut).append("\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            // Add input mapping
            if (invokeExpr.getInput() != null) {
                generateMapBlockXml(invokeExpr.getInput(), "INPUT", indent + 1);
            }
            
            // Add output mapping
            if (invokeExpr.getOutput() != null) {
                generateMapBlockXml(invokeExpr.getOutput(), "OUTPUT", indent + 1);
            }
            
            flowXml.append(indentStr).append("</INVOKE>\n");
            
        } else if (expr instanceof FlowMapElementExpression) {
            FlowMapElementExpression mapExpr = (FlowMapElementExpression) expr;
            String timeout = getPropertyValue(mapExpr.getProperties(), "timeout", "");
            
            flowXml.append(indentStr).append("<MAP TIMEOUT=\"").append(timeout).append("\" MODE=\"STANDALONE\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n");
            
            // Generate MAPTARGET and MAPSOURCE (simplified - would need actual pipeline data)
            flowXml.append(indentStr).append("  <MAPTARGET>\n\n");
            flowXml.append(indentStr).append("<Values version=\"2.0\">\n");
            flowXml.append(indentStr).append("  <record name=\"xml\" javaclass=\"com.wm.util.Values\">\n");
            flowXml.append(indentStr).append("    <value name=\"node_type\">record</value>\n");
            flowXml.append(indentStr).append("    <value name=\"modifiable\">true</value>\n");
            flowXml.append(indentStr).append("  </record>\n");
            flowXml.append(indentStr).append("</Values>\n");
            flowXml.append(indentStr).append("</MAPTARGET>\n");
            
            flowXml.append(indentStr).append("  <MAPSOURCE>\n\n");
            flowXml.append(indentStr).append("<Values version=\"2.0\">\n");
            flowXml.append(indentStr).append("  <record name=\"xml\" javaclass=\"com.wm.util.Values\">\n");
            flowXml.append(indentStr).append("    <value name=\"node_type\">record</value>\n");
            flowXml.append(indentStr).append("    <value name=\"modifiable\">true</value>\n");
            flowXml.append(indentStr).append("  </record>\n");
            flowXml.append(indentStr).append("</Values>\n");
            flowXml.append(indentStr).append("</MAPSOURCE>\n\n");
            
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            // Add map operations
            for (FlowElementExpression mapOp : mapExpr.getExpressions()) {
                generateMapOperationXml((FlowMapExpression) mapOp, indent + 1);
            }
            
            flowXml.append(indentStr).append("</MAP>\n");
            
        } else if (expr instanceof FlowLoopExpression) {
            FlowLoopExpression loopExpr = (FlowLoopExpression) expr;
            flowXml.append(indentStr).append("<LOOP TIMEOUT=\"\" EXIT-ON=\"FAILURE\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            for (FlowElementExpression child : loopExpr.getExpressions()) {
                generateStepXml(child, indent + 1);
            }
            
            flowXml.append(indentStr).append("</LOOP>\n\n");
            
        } else if (expr instanceof FlowBranchExpression) {
            FlowBranchExpression branchExpr = (FlowBranchExpression) expr;
            flowXml.append(indentStr).append("<BRANCH TIMEOUT=\"\" EXIT-ON=\"FAILURE\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            for (FlowElementExpression child : branchExpr.getExpressions()) {
                generateStepXml(child, indent + 1);
            }
            
            flowXml.append(indentStr).append("</BRANCH>\n\n");
            
        } else if (expr instanceof FlowRepeatExpression) {
            FlowRepeatExpression repeatExpr = (FlowRepeatExpression) expr;
            flowXml.append(indentStr).append("<REPEAT TIMEOUT=\"\" EXIT-ON=\"FAILURE\">\n");
            flowXml.append(indentStr).append("  <COMMENT></COMMENT>\n\n");
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
            
            for (FlowElementExpression child : repeatExpr.getExpressions()) {
                generateStepXml(child, indent + 1);
            }
            
            flowXml.append(indentStr).append("</REPEAT>\n\n");
            
        } else if (expr instanceof FlowExitExpression) {
            FlowExitExpression exitExpr = (FlowExitExpression) expr;
            String from = getPropertyValue(exitExpr.getProperties(), "from", "");
            String signal = getPropertyValue(exitExpr.getProperties(), "signal", "");
            
            flowXml.append(indentStr).append("<EXIT");
            if (!from.isEmpty()) {
                flowXml.append(" FROM=\"").append(from).append("\"");
            }
            if (!signal.isEmpty()) {
                flowXml.append(" SIGNAL=\"").append(signal).append("\"");
            }
            flowXml.append("/>\n");
        }
    }
    
    private void generateMapBlockXml(MapIOExprssion mapping, String mode, int indent) {
        String indentStr = "  ".repeat(indent);
        
        // Check if mapping has any expressions
        if (mapping == null || mapping.getExpressions().isEmpty()) {
            // Empty MAP block
            flowXml.append(indentStr).append("<MAP MODE=\"").append(mode).append("\">\n");
            flowXml.append(indentStr).append("</MAP>\n\n");
            return;
        }
        
        flowXml.append(indentStr).append("<MAP MODE=\"").append(mode).append("\">\n");
        
        // Generate MAPTARGET and MAPSOURCE only for INPUT mode
        if (mode.equals("INPUT")) {
            flowXml.append(indentStr).append("  <MAPTARGET>\n\n");
            flowXml.append(indentStr).append("<Values version=\"2.0\">\n");
            flowXml.append(indentStr).append("  <record name=\"xml\" javaclass=\"com.wm.util.Values\">\n");
            flowXml.append(indentStr).append("    <value name=\"node_type\">record</value>\n");
            flowXml.append(indentStr).append("    <value name=\"modifiable\">true</value>\n");
            flowXml.append(indentStr).append("  </record>\n");
            flowXml.append(indentStr).append("</Values>\n");
            flowXml.append(indentStr).append("</MAPTARGET>\n");
            
            flowXml.append(indentStr).append("  <MAPSOURCE>\n\n");
            flowXml.append(indentStr).append("<Values version=\"2.0\">\n");
            flowXml.append(indentStr).append("  <record name=\"xml\" javaclass=\"com.wm.util.Values\">\n");
            flowXml.append(indentStr).append("    <value name=\"node_type\">record</value>\n");
            flowXml.append(indentStr).append("    <value name=\"modifiable\">true</value>\n");
            flowXml.append(indentStr).append("  </record>\n");
            flowXml.append(indentStr).append("</Values>\n");
            flowXml.append(indentStr).append("</MAPSOURCE>\n\n");
            
            flowXml.append(indentStr).append("  <!-- nodes -->\n\n");
        }
        
        for (FlowElementExpression mapExpr : mapping.getExpressions()) {
            if (mapExpr instanceof FlowMapCopyExpression) {
                FlowMapCopyExpression copyExpr = (FlowMapCopyExpression) mapExpr;
                String from = copyExpr.getFrom() != null ? copyExpr.getFrom() : "";
                String to = copyExpr.getTo() != null ? copyExpr.getTo() : "";
                flowXml.append(indentStr).append("<MAPCOPY FROM=\"").append(escapeXml(from))
                       .append("\" TO=\"").append(escapeXml(to)).append("\">\n");
                flowXml.append(indentStr).append("</MAPCOPY>\n\n");
            }
        }
        
        flowXml.append(indentStr).append("</MAP>\n\n");
    }
    
    private void generateMapOperationXml(FlowMapExpression mapOp, int indent) {
        String indentStr = "  ".repeat(indent);
        
        if (mapOp instanceof FlowMapCopyExpression) {
            FlowMapCopyExpression copyExpr = (FlowMapCopyExpression) mapOp;
            flowXml.append(indentStr).append("<MAPCOPY FROM=\"").append(escapeXml(copyExpr.getFrom()))
                   .append("\" TO=\"").append(escapeXml(copyExpr.getTo())).append("\">\n");
            flowXml.append(indentStr).append("</MAPCOPY>\n\n");
            
        } else if (mapOp instanceof FlowMapSetExpression) {
            FlowMapSetExpression setExpr = (FlowMapSetExpression) mapOp;
            flowXml.append(indentStr).append("<MAPSET NAME=\"Setter\" OVERWRITE=\"true\" VARIABLES=\"false\" GLOBALVARIABLES=\"false\" FIELD=\"")
                   .append(escapeXml(setExpr.getFieldPath())).append("\">\n");
            flowXml.append(indentStr).append("  <DATA ENCODING=\"XMLValues\" I18N=\"true\">\n\n");
            flowXml.append(indentStr).append("<Values version=\"2.0\">\n");
            flowXml.append(indentStr).append("  <value name=\"xml\">").append(escapeXml(setExpr.getValue())).append("</value>\n");
            flowXml.append(indentStr).append("</Values>\n");
            flowXml.append(indentStr).append("</DATA>\n");
            flowXml.append(indentStr).append("</MAPSET>\n\n");
            
        } else if (mapOp instanceof FlowMapDropExpression) {
            FlowMapDropExpression dropExpr = (FlowMapDropExpression) mapOp;
            flowXml.append(indentStr).append("<MAPDELETE FIELD=\"").append(escapeXml(dropExpr.getFieldName())).append("\">\n");
            flowXml.append(indentStr).append("</MAPDELETE>\n\n");
        }
    }
    
    private String getPropertyValue(List<FlowStepProperty> properties, String key, String defaultValue) {
        for (FlowStepProperty prop : properties) {
            if (prop.getKey().equals(key)) {
                String value = prop.getValue();
                // Remove quotes from string literals
                if (value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                }
                return value;
            }
        }
        return defaultValue;
    }
    
    private void generateNodeNdf(FlowProgram program) {
        nodeNdf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n");
        nodeNdf.append("<Values version=\"2.0\">\n");
        nodeNdf.append("  <value name=\"svc_type\">flow</value>\n");
        nodeNdf.append("  <value name=\"svc_subtype\">default</value>\n");
        nodeNdf.append("  <value name=\"svc_sigtype\">java 3.5</value>\n");
        
        // Add service signature
        nodeNdf.append("  <record name=\"svc_sig\" javaclass=\"com.wm.util.Values\">\n");
        
        // Input signature
        nodeNdf.append("    <record name=\"sig_in\" javaclass=\"com.wm.util.Values\">\n");
        nodeNdf.append("      <value name=\"node_type\">record</value>\n");
        nodeNdf.append("      <value name=\"node_subtype\">unknown</value>\n");
        nodeNdf.append("      <value name=\"is_public\">false</value>\n");
        nodeNdf.append("      <value name=\"field_type\">record</value>\n");
        nodeNdf.append("      <value name=\"field_dim\">0</value>\n");
        nodeNdf.append("      <value name=\"wrapper_type\">IData</value>\n");
        nodeNdf.append("      <value name=\"nillable\">true</value>\n");
        nodeNdf.append("      <value name=\"form_qualified\">false</value>\n");
        nodeNdf.append("      <value name=\"is_global\">false</value>\n");
        nodeNdf.append("      <array name=\"rec_fields\" type=\"record\" depth=\"1\">\n");
        nodeNdf.append("      </array>\n");
        nodeNdf.append("      <value name=\"modifiable\">true</value>\n");
        nodeNdf.append("    </record>\n");
        
        // Output signature
        nodeNdf.append("    <record name=\"sig_out\" javaclass=\"com.wm.util.Values\">\n");
        nodeNdf.append("      <value name=\"node_type\">record</value>\n");
        nodeNdf.append("      <value name=\"node_subtype\">unknown</value>\n");
        nodeNdf.append("      <value name=\"is_public\">false</value>\n");
        nodeNdf.append("      <value name=\"field_type\">record</value>\n");
        nodeNdf.append("      <value name=\"field_dim\">0</value>\n");
        nodeNdf.append("      <value name=\"wrapper_type\">IData</value>\n");
        nodeNdf.append("      <value name=\"nillable\">true</value>\n");
        nodeNdf.append("      <value name=\"form_qualified\">false</value>\n");
        nodeNdf.append("      <value name=\"is_global\">false</value>\n");
        nodeNdf.append("      <array name=\"rec_fields\" type=\"record\" depth=\"1\">\n");
        nodeNdf.append("      </array>\n");
        nodeNdf.append("      <value name=\"modifiable\">true</value>\n");
        nodeNdf.append("    </record>\n");
        nodeNdf.append("  </record>\n");
        
        // Service properties
        nodeNdf.append("  <value name=\"node_comment\"></value>\n");
        nodeNdf.append("  <value name=\"stateless\">yes</value>\n");
        nodeNdf.append("  <value name=\"caching\">no</value>\n");
        nodeNdf.append("  <value name=\"prefetch\">no</value>\n");
        nodeNdf.append("  <value name=\"cache_ttl\">15</value>\n");
        nodeNdf.append("  <value name=\"prefetch_level\">1</value>\n");
        nodeNdf.append("  <value name=\"audit_level\">off</value>\n");
        nodeNdf.append("  <value name=\"check_internal_acls\">no</value>\n");
        nodeNdf.append("  <value name=\"icontext_policy\">$null</value>\n");
        nodeNdf.append("  <value name=\"system_service\">no</value>\n");
        nodeNdf.append("  <value name=\"retry_max\">0</value>\n");
        nodeNdf.append("  <value name=\"retry_interval\">0</value>\n");
        nodeNdf.append("  <value name=\"svc_in_validator_options\">none</value>\n");
        nodeNdf.append("  <value name=\"svc_out_validator_options\">none</value>\n");
        nodeNdf.append("  <value name=\"auditoption\">0</value>\n");
        nodeNdf.append("  <null name=\"auditfields_input\"/>\n");
        nodeNdf.append("  <null name=\"auditfields_output\"/>\n");
        
        // Audit settings
        nodeNdf.append("  <record name=\"auditsettings\" javaclass=\"com.wm.util.Values\">\n");
        nodeNdf.append("    <value name=\"document_data\">0</value>\n");
        nodeNdf.append("    <value name=\"startExecution\">false</value>\n");
        nodeNdf.append("    <value name=\"stopExecution\">false</value>\n");
        nodeNdf.append("    <value name=\"onError\">true</value>\n");
        nodeNdf.append("  </record>\n");
        
        // Circuit breaker settings
        nodeNdf.append("  <record name=\"circuitbreakersettings\" javaclass=\"com.wm.util.Values\">\n");
        nodeNdf.append("    <value name=\"enabled\">false</value>\n");
        nodeNdf.append("    <value name=\"failureEvent\">1</value>\n");
        nodeNdf.append("    <value name=\"timeoutPeriod\">60</value>\n");
        nodeNdf.append("    <value name=\"failureThreshold\">5</value>\n");
        nodeNdf.append("    <value name=\"failurePeriod\">60</value>\n");
        nodeNdf.append("    <value name=\"openAction\">1</value>\n");
        nodeNdf.append("    <value name=\"serviceToInvoke\"></value>\n");
        nodeNdf.append("    <value name=\"resetPeriod\">300</value>\n");
        nodeNdf.append("    <value name=\"cancelThreadOnTimeout\">false</value>\n");
        nodeNdf.append("  </record>\n");
        
        // Concurrent request limit settings
        nodeNdf.append("  <record name=\"concurrentrequestlimitsettings\" javaclass=\"com.wm.util.Values\">\n");
        nodeNdf.append("    <value name=\"maxConcurrentRequests\">20</value>\n");
        nodeNdf.append("    <value name=\"concurrentRequestLimitEnabled\">false</value>\n");
        nodeNdf.append("  </record>\n");
        
        // Allowed HTTP methods
        nodeNdf.append("  <array name=\"allowedHTTPMethods\" type=\"value\" depth=\"1\">\n");
        nodeNdf.append("    <value>TRACE</value>\n");
        nodeNdf.append("    <value>HEAD</value>\n");
        nodeNdf.append("    <value>DELETE</value>\n");
        nodeNdf.append("    <value>POST</value>\n");
        nodeNdf.append("    <value>GET</value>\n");
        nodeNdf.append("    <value>OPTIONS</value>\n");
        nodeNdf.append("    <value>PUT</value>\n");
        nodeNdf.append("    <value>PATCH</value>\n");
        nodeNdf.append("  </array>\n");
        
        nodeNdf.append("  <value name=\"pipeline_option\">1</value>\n");
        nodeNdf.append("  <null name=\"originURI\"/>\n");
        nodeNdf.append("  <value name=\"modifiable\">true</value>\n");
        nodeNdf.append("  <value name=\"is_public\">false</value>\n");
        nodeNdf.append("</Values>\n");
    }
    
    private String getPackageName(String serviceName) {
        int lastDot = serviceName.lastIndexOf('.');
        if (lastDot > 0) {
            return serviceName.substring(0, lastDot);
        }
        return "default";
    }
    
    private void writeFiles(String serviceName) {
        try {
            // Create output directory
            File dir = new File(outputDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            // Write flow.xml
            File flowFile = new File(dir, "flow.xml");
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(flowFile), StandardCharsets.UTF_8)) {
                writer.write(flowXml.toString());
            }
            System.out.println("Generated: " + flowFile.getAbsolutePath());
            
            // Write node.ndf
            File nodeFile = new File(dir, "node.ndf");
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(nodeFile), StandardCharsets.UTF_8)) {
                writer.write(nodeNdf.toString());
            }
            System.out.println("Generated: " + nodeFile.getAbsolutePath());
            
        } catch (IOException e) {
            System.err.println("Error writing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private String escapeXml(String text) {
        if (text == null) return "";
        return text.replace("&", "&")
                   .replace("<", "<")
                   .replace(">", ">")
                   .replace("\"", "\"")
                   .replace("'", "'");
    }
}

// Made with Bob
