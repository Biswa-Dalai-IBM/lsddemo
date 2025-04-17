package expressions.app;

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

	public static void main(String[] args) {
		if(args.length!=1) {
			System.err.println("Missing file name");
		}else {
			String fileName = args[0];
			FlowServiceParser parser = getParser(fileName);
			ParseTree antlrAST = parser.flowService();
			
			AntlrToProgram program = new AntlrToProgram();
			FlowProgram flowProgram = program.visit(antlrAST);
			FlowGenerator flowGenerator = new FlowGenerator();
			flowGenerator.generateFlow(flowProgram);
			System.out.println(flowProgram);
		}

	}
	
	private static FlowServiceParser getParser(String fileName) {
		
		FlowServiceParser parser = null;
		
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			FlowServiceLexer lexer = new FlowServiceLexer(input);
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			parser=new FlowServiceParser(tokenStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return parser;
	}

}
