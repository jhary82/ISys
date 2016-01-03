// Generated from Syntax.g4 by ANTLR 4.4
package syntaxAnalyse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SyntaxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, EXCLAMATION=3, BRACK=4, RBRACK=5, QUES=6, CITE=7, NUMBER=8, 
		NOUN=9, WORD=10, NL=11, SKIPED=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'"
	};
	public static final String[] ruleNames = {
		"DOT", "COMMA", "EXCLAMATION", "BRACK", "RBRACK", "QUES", "CITE", "NUMBER", 
		"NOUN", "WORD", "NL", "SKIPED", "WS", "CAPITAL_LETTER", "LETTER", "DIGIT"
	};


	public SyntaxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Syntax.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17^\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\65\n\b"+
		"\3\t\6\t8\n\t\r\t\16\t9\3\n\3\n\7\n>\n\n\f\n\16\nA\13\n\3\13\5\13D\n\13"+
		"\3\13\7\13G\n\13\f\13\16\13J\13\13\3\f\3\f\3\r\5\rO\n\r\3\r\3\r\3\16\5"+
		"\16T\n\16\3\16\3\16\3\17\3\17\3\20\5\20[\n\20\3\21\3\21\2\2\22\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\2\3"+
		"\2\t\4\2..==\7\2$$))\u00ad\u00ad\u00bd\u00bd\u201e\u2021\25\2((+,//\61"+
		"\61<=??^_\u00cc\u00cc\u00d2\u00d2\u00e2\u00e3\u00ea\u00ea\u00ec\u00ec"+
		"\u00ef\u00ef\u00f3\u00f3\u00f5\u00f5\u2012\u2017\u201b\u201b\u2028\u2028"+
		"\uffff\uffff\7\2\13\13\17\17\"\"\u00a2\u00a2\u00af\u00af\3\2C\\\13\2c"+
		"|\u00c6\u00c6\u00d8\u00d8\u00de\u00de\u00e1\u00e1\u00e6\u00e6\u00eb\u00eb"+
		"\u00f8\u00f8\u00fe\u00fe\3\2\62;`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3#\3\2\2\2"+
		"\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17\64\3\2\2"+
		"\2\21\67\3\2\2\2\23;\3\2\2\2\25C\3\2\2\2\27K\3\2\2\2\31N\3\2\2\2\33S\3"+
		"\2\2\2\35W\3\2\2\2\37Z\3\2\2\2!\\\3\2\2\2#$\7\60\2\2$\4\3\2\2\2%&\t\2"+
		"\2\2&\6\3\2\2\2\'(\7#\2\2(\b\3\2\2\2)*\7*\2\2*\n\3\2\2\2+,\7]\2\2,\f\3"+
		"\2\2\2-.\7A\2\2.\16\3\2\2\2/\60\7@\2\2\60\65\7@\2\2\61\62\7>\2\2\62\65"+
		"\7>\2\2\63\65\t\3\2\2\64/\3\2\2\2\64\61\3\2\2\2\64\63\3\2\2\2\65\20\3"+
		"\2\2\2\668\5!\21\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\22\3"+
		"\2\2\2;?\5\35\17\2<>\5\37\20\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2"+
		"@\24\3\2\2\2A?\3\2\2\2BD\5\35\17\2CB\3\2\2\2CD\3\2\2\2DH\3\2\2\2EG\5\37"+
		"\20\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\26\3\2\2\2JH\3\2\2\2KL"+
		"\7\f\2\2L\30\3\2\2\2MO\t\4\2\2NM\3\2\2\2OP\3\2\2\2PQ\b\r\2\2Q\32\3\2\2"+
		"\2RT\t\5\2\2SR\3\2\2\2TU\3\2\2\2UV\b\16\2\2V\34\3\2\2\2WX\t\6\2\2X\36"+
		"\3\2\2\2Y[\t\7\2\2ZY\3\2\2\2[ \3\2\2\2\\]\t\b\2\2]\"\3\2\2\2\13\2\649"+
		"?CHNSZ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}