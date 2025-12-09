# Flow to webMethods XML Generator

This tool converts `.flow` files (written in the FlowService DSL) to webMethods-compatible `flow.xml` and `node.ndf` files.

## Overview

The generator parses `.flow` files using ANTLR4 and generates standard webMethods flow service XML files that can be imported into webMethods Integration Server.

## Architecture

```
.flow file → ANTLR Parser → FlowProgram AST → WebMethodsFlowGenerator → flow.xml + node.ndf
```

### Components

1. **FlowService.g4** - ANTLR grammar defining the DSL syntax
2. **FlowServiceLexer/Parser** - Generated ANTLR lexer and parser
3. **AntlrToProgram** - Visitor that converts ANTLR parse tree to FlowProgram
4. **AntlrToExpression** - Visitor that converts individual steps to expressions
5. **WebMethodsFlowGenerator** - Generates webMethods XML format
6. **FlowToXmlApp** - Main application for single file conversion
7. **BatchProcessFlows** - Batch processor for multiple files

## Prerequisites

- Java 8 or higher
- ANTLR 4.x runtime library
- webMethods Java libraries (for FlowElement classes)

## Building

### 1. Generate ANTLR Parser

```bash
cd FlowLSP/src/antlr
antlr4 -visitor -package antlr FlowService.g4
```

This generates:
- `FlowServiceLexer.java`
- `FlowServiceParser.java`
- `FlowServiceBaseVisitor.java`
- `FlowServiceVisitor.java`

### 2. Compile Java Sources

```bash
cd FlowLSP
javac -cp "lib/*:src" src/expressions/**/*.java src/antlr/*.java
```

## Usage

### Single File Conversion

Convert a single `.flow` file to webMethods XML:

```bash
java -cp "lib/*:bin" expressions.app.FlowToXmlApp <input-file> [output-directory]
```

**Examples:**

```bash
# Generate in default output directory
java -cp "lib/*:bin" expressions.app.FlowToXmlApp test-3/sample_simple_test.flow

# Specify custom output directory
java -cp "lib/*:bin" expressions.app.FlowToXmlApp test-3/sample_simple_test.flow output/SimpleTestService
```

**Output:**
```
output/SimpleTestService/
├── flow.xml
└── node.ndf
```

### Batch Processing

Convert all `.flow` files in a directory:

```bash
java -cp "lib/*:bin" expressions.app.BatchProcessFlows <input-directory> [output-base-directory]
```

**Examples:**

```bash
# Process all files in test-3 directory
java -cp "lib/*:bin" expressions.app.BatchProcessFlows test-3

# Specify custom output base directory
java -cp "lib/*:bin" expressions.app.BatchProcessFlows test-3 generated
```

**Output:**
```
output/
├── sample_simple_test/
│   ├── flow.xml
│   └── node.ndf
├── sample_basic_flow/
│   ├── flow.xml
│   └── node.ndf
├── sample_control_flow_test/
│   ├── flow.xml
│   └── node.ndf
└── ...
```

## Generated Files

### flow.xml

Contains the complete flow service definition including:
- Service metadata (name, type, visibility)
- Input/output signature
- Flow steps and their properties
- Mapping operations
- Control flow structures

**Example structure:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Values version="2.0">
  <value name="node_type">interface</value>
  <value name="node_nsName">SimpleTestService</value>
  <record name="sig" javaclass="com.wm.util.Values">
    <record name="input" javaclass="com.wm.util.Values"></record>
    <record name="output" javaclass="com.wm.util.Values"></record>
  </record>
  <array name="flow" type="record" depth="1">
    <!-- Flow steps here -->
  </array>
</Values>
```

### node.ndf

Contains node metadata for the webMethods package structure:
- Node type and subtype
- Package name
- Visibility settings

**Example structure:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Values version="2.0">
  <value name="node_type">interface</value>
  <value name="node_subtype">unknown</value>
  <value name="node_nsName">SimpleTestService</value>
  <value name="node_pkg">default</value>
  <value name="is_public">false</value>
</Values>
```

## Supported Flow Steps

The generator supports all FlowService DSL step types:

### 1. INVOKE
Service invocation with input/output mapping
```
INVOKE com.example:myService {
  comment: "Call external service";
  timeout: 30;
  validateInput: true;
  input {
    copy orderId -> orderNumber;
    set validateStock = true;
  }
  output {
    copy result -> processResult;
  }
};
```

### 2. MAP
Data transformation and mapping
```
MAP {
  comment: "Transform data";
  copy customer/name -> customerName;
  set status = "ACTIVE";
  drop tempVariable;
};
```

### 3. LOOP
Iteration over arrays
```
LOOP {
  comment: "Process items";
  inputArray: "items";
  outputArray: "results";
  
  INVOKE com.example:processItem;
};
```

### 4. SEQUENCE
Sequential execution with exit conditions
```
SEQUENCE {
  comment: "Validation sequence";
  exitOn: validationFailed == true;
  
  INVOKE com.example:validate;
  MAP { set validationFailed = !isValid; };
};
```

### 5. BRANCH
Conditional branching
```
BRANCH {
  comment: "Route by status";
  switch: orderStatus;
  evaluateLabels: true;
  
  SEQUENCE { label: "APPROVED"; ... };
  SEQUENCE { label: "REJECTED"; ... };
};
```

### 6. REPEAT
Retry logic
```
REPEAT {
  comment: "Retry operation";
  count: 3;
  repeatInterval: 5000;
  repeatOn: retryCount < maxRetries;
  
  INVOKE com.example:retryableOp;
};
```

### 7. TRY-CATCH-FINALLY
Exception handling
```
TRY {
  comment: "Main processing";
  INVOKE com.example:riskyOperation;
} CATCH {
  comment: "Handle errors";
  failures: "com.example.ProcessException";
  MAP { copy $error/message -> errorMsg; };
} FINALLY {
  comment: "Cleanup";
  INVOKE com.example:cleanup;
};
```

### 8. EXIT
Early termination
```
EXIT {
  comment: "Exit on failure";
  signal: "FAILURE";
  failureMessage: "Critical error occurred";
};
```

## Expression Support

The generator supports rich expressions in conditions:

### Arithmetic Operators
```
set total = count * price;
set discounted = total - 100;
set tax = total * 0.08;
```

### Comparison Operators
```
exitOn: count > 100;
repeatOn: retryCount < maxRetries;
switch: status == "APPROVED";
```

### Logical Operators
```
exitOn: isValid && count > 0;
repeatOn: !success || retryCount < 3;
```

### Variable Paths
```
copy customer/name -> customerName;
set isValid = order/status == "APPROVED";
```

### Special Variables
```
copy $error/message -> errorMessage;
selection: $error/type == "SystemException";
```

## Test Files

The `test-3` directory contains comprehensive test files:

| File | Description | Features |
|------|-------------|----------|
| sample_simple_test.flow | Basic syntax | INVOKE, MAP |
| sample_basic_flow.flow | Simple workflow | INVOKE, MAP, EXIT |
| sample_control_flow_test.flow | Control structures | SEQUENCE, LOOP, BRANCH, REPEAT, TRY-CATCH |
| sample_mapping_test.flow | Data mapping | Records, recordLists, TRANSFORM |
| sample_expression_test.flow | Expressions | All operators, precedence |
| sample_advanced_flow.flow | Complex scenario | Nested structures, error handling |

## Troubleshooting

### Common Issues

**1. Syntax Errors**
```
Error: line 10:5 mismatched input 'count' expecting ID
```
**Solution**: `count` is a reserved keyword. Use `itemCount` instead.

**2. Missing Semicolons**
```
Error: line 15:1 missing ';' at '}'
```
**Solution**: All properties and steps must end with semicolons.

**3. TRANSFORM Outside MAP**
```
Error: extraneous input 'TRANSFORM' expecting {...}
```
**Solution**: TRANSFORM must be inside a MAP block.

### Reserved Keywords

Avoid using these as variable names:
- Step keywords: MAP, INVOKE, LOOP, SEQUENCE, BRANCH, REPEAT, TRY, CATCH, FINALLY, EXIT
- Property keywords: count, input, output, copy, set, drop, comment, timeout, label
- Type keywords: String, Integer, Float, Boolean, etc.

## Importing to webMethods

1. Copy generated `flow.xml` and `node.ndf` to your webMethods package:
   ```
   <IntegrationServer>/packages/<YourPackage>/ns/<ServicePath>/
   ```

2. Reload the package in Designer or restart Integration Server

3. The service will appear in the package navigator

## Development

### Adding New Step Types

1. Update `FlowService.g4` grammar
2. Regenerate ANTLR parser
3. Add expression class in `expressions/flow/`
4. Update `AntlrToExpression.java` visitor
5. Update `WebMethodsFlowGenerator.java` generator

### Testing

Run the test suite:
```bash
java -cp "lib/*:bin" expressions.app.BatchProcessFlows test-3 test-output
```

Verify all files generate without errors.

## License

This tool is part of the FlowLSP project.

## Support

For issues or questions, please refer to the project documentation or create an issue in the repository.