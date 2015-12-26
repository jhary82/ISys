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
		DOT=1, KOM=2, AUS=3, BRACK=4, RBRACK=5, QUES=6, CITE=7, NUMBER=8, WORD=9, 
		NL=10, SKIPED=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"DOT", "KOM", "AUS", "BRACK", "RBRACK", "QUES", "CITE", "NUMBER", "WORD", 
		"NL", "SKIPED", "WS", "LETTER", "DIGIT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16M\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\61\n\b\3\t\6\t\64\n\t\r\t\16"+
		"\t\65\3\n\6\n9\n\n\r\n\16\n:\3\13\3\13\3\f\5\f@\n\f\3\f\3\f\3\r\5\rE\n"+
		"\r\3\r\3\r\3\16\5\16J\n\16\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\2\35\2\3\2\7\7\2$$))\u00ad\u00ad\u00bd"+
		"\u00bd\u201e\u2021\25\2((+,//\61\61<=??^_\u00cc\u00cc\u00d2\u00d2\u00e2"+
		"\u00e3\u00ea\u00ea\u00ec\u00ec\u00ef\u00ef\u00f3\u00f3\u00f5\u00f5\u2012"+
		"\u2017\u201b\u201b\u2028\u2028\uffff\uffff\7\2\13\13\17\17\"\"\u00a2\u00a2"+
		"\u00af\u00af\f\2C\\c|\u00c6\u00c6\u00d8\u00d8\u00de\u00de\u00e1\u00e1"+
		"\u00e6\u00e6\u00eb\u00eb\u00f8\u00f8\u00fe\u00fe\3\2\62;N\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2"+
		"\17\60\3\2\2\2\21\63\3\2\2\2\238\3\2\2\2\25<\3\2\2\2\27?\3\2\2\2\31D\3"+
		"\2\2\2\33I\3\2\2\2\35K\3\2\2\2\37 \7\60\2\2 \4\3\2\2\2!\"\7.\2\2\"\6\3"+
		"\2\2\2#$\7#\2\2$\b\3\2\2\2%&\7*\2\2&\n\3\2\2\2\'(\7]\2\2(\f\3\2\2\2)*"+
		"\7A\2\2*\16\3\2\2\2+,\7@\2\2,\61\7@\2\2-.\7>\2\2.\61\7>\2\2/\61\t\2\2"+
		"\2\60+\3\2\2\2\60-\3\2\2\2\60/\3\2\2\2\61\20\3\2\2\2\62\64\5\35\17\2\63"+
		"\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\22\3\2\2\2\67"+
		"9\5\33\16\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\24\3\2\2\2<=\7"+
		"\f\2\2=\26\3\2\2\2>@\t\3\2\2?>\3\2\2\2@A\3\2\2\2AB\b\f\2\2B\30\3\2\2\2"+
		"CE\t\4\2\2DC\3\2\2\2EF\3\2\2\2FG\b\r\2\2G\32\3\2\2\2HJ\t\5\2\2IH\3\2\2"+
		"\2J\34\3\2\2\2KL\t\6\2\2L\36\3\2\2\2\t\2\60\65:?DI\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}