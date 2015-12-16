/**
 * 
 */
package test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.*;

import syntaxAnalyse.SyntaxLexer;
import static syntaxAnalyse.SyntaxLexer.*;

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
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				try {
					input = new ANTLRFileStream(args[i], StandardCharsets.US_ASCII.name());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SyntaxLexer lexer = new SyntaxLexer(input);
				Token t = lexer.nextToken();
				while (t.getType() != Token.EOF) {
					switch (t.getType()) {
					case DOT: break; 
					case KOM: break;
					case AUS: break; 
					case BRACK: break; 
					case RBRACK: break;
					case QUES: break; 
					case CITE: break; 
					case NUMBER: break;
					case NL: break; 
					default: break; }
					 
					// System.out.print(t.getText());
					t = lexer.nextToken();
				}
			}
		}

	}

}
