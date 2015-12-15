/**
 * 
 */
package test;

import java.io.IOException;

import org.antlr.v4.runtime.*;

import syntaxAnalyse.Syntax;

import static syntaxAnalyse.Syntax.*;
/**
 * @author Erik
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CharStream input = null;
		if(args.length > 0) {
			try {
				input = new ANTLRFileStream(args[0]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Syntax lexer = new Syntax(input);
		Token t = lexer.nextToken();
		while(t.getType() != Token.EOF) {
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
			default: break;
			}
			//System.out.print(t.getText());
			t = lexer.nextToken();
		}
	}

}
