/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import syntaxAnalyse.SyntaxLexer;
import syntaxAnalyse.SyntaxParser;
import visitor.Visitor;

/**
 * @author Erik und Simon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CharStream input = null;
		FileReader fr;
		BufferedReader reader;
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				try {
					//fr = new FileReader(args[i]);
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[i])));
					input = new ANTLRInputStream(reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SyntaxLexer lexer = new SyntaxLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				SyntaxParser parser = new SyntaxParser(tokens);
				System.out.println(lexer.getInputStream().getText(Interval.of(0, 100)));
				ParseTree tree = parser.stat();
				Visitor visitor = new Visitor();
				System.out.println(tree.getText());
				visitor.visit(tree);
				System.out.println("Text: " + args[i]);
				for (int count : visitor.getCountSymbols()) {
					System.out.print(count + " ");
				}
			}
		}

	}

}
