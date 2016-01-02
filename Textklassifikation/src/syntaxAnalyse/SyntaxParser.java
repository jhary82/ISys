// Generated from Syntax.g4 by ANTLR 4.4
package syntaxAnalyse;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SyntaxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, EXCLAMATION=3, BRACK=4, RBRACK=5, COLON=6, QUES=7, CITE=8, 
		NUMBER=9, WORD=10, NL=11, SKIPED=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "COMMA", "'!'", "'('", "'['", "':'", "'?'", "CITE", 
		"NUMBER", "WORD", "'\n'", "SKIPED", "WS"
	};
	public static final int
		RULE_stat = 0, RULE_sentence = 1, RULE_seperatorSymbol = 2, RULE_symbol = 3;
	public static final String[] ruleNames = {
		"stat", "sentence", "seperatorSymbol", "symbol"
	};

	@Override
	public String getGrammarFileName() { return "Syntax.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SyntaxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SentenceStatContext extends StatContext {
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterSentenceStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitSentenceStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			_localctx = new SentenceStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << COMMA) | (1L << EXCLAMATION) | (1L << COLON) | (1L << QUES))) != 0)) {
				{
				{
				setState(8); sentence();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public List<SeperatorSymbolContext> seperatorSymbol() {
			return getRuleContexts(SeperatorSymbolContext.class);
		}
		public List<TerminalNode> WORD() { return getTokens(SyntaxParser.WORD); }
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SeperatorSymbolContext seperatorSymbol(int i) {
			return getRuleContext(SeperatorSymbolContext.class,i);
		}
		public TerminalNode WORD(int i) {
			return getToken(SyntaxParser.WORD, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(14); seperatorSymbol();
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACK) | (1L << RBRACK) | (1L << CITE) | (1L << NUMBER) | (1L << WORD) | (1L << NL))) != 0)) {
				{
				setState(17);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(15); match(WORD);
					}
					break;
				case 2:
					{
					setState(16); symbol();
					}
					break;
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22); seperatorSymbol();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeperatorSymbolContext extends ParserRuleContext {
		public SeperatorSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seperatorSymbol; }
	 
		public SeperatorSymbolContext() { }
		public void copyFrom(SeperatorSymbolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExclamationStatContext extends SeperatorSymbolContext {
		public TerminalNode EXCLAMATION() { return getToken(SyntaxParser.EXCLAMATION, 0); }
		public ExclamationStatContext(SeperatorSymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterExclamationStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitExclamationStat(this);
		}
	}
	public static class QuesStatContext extends SeperatorSymbolContext {
		public TerminalNode QUES() { return getToken(SyntaxParser.QUES, 0); }
		public QuesStatContext(SeperatorSymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterQuesStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitQuesStat(this);
		}
	}
	public static class CommaStatContext extends SeperatorSymbolContext {
		public TerminalNode COMMA() { return getToken(SyntaxParser.COMMA, 0); }
		public CommaStatContext(SeperatorSymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterCommaStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitCommaStat(this);
		}
	}
	public static class ColonStatContext extends SeperatorSymbolContext {
		public TerminalNode COLON() { return getToken(SyntaxParser.COLON, 0); }
		public ColonStatContext(SeperatorSymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterColonStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitColonStat(this);
		}
	}
	public static class DotStatContext extends SeperatorSymbolContext {
		public TerminalNode DOT() { return getToken(SyntaxParser.DOT, 0); }
		public DotStatContext(SeperatorSymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterDotStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitDotStat(this);
		}
	}

	public final SeperatorSymbolContext seperatorSymbol() throws RecognitionException {
		SeperatorSymbolContext _localctx = new SeperatorSymbolContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seperatorSymbol);
		try {
			setState(29);
			switch (_input.LA(1)) {
			case DOT:
				_localctx = new DotStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24); match(DOT);
				}
				break;
			case COMMA:
				_localctx = new CommaStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(COMMA);
				}
				break;
			case EXCLAMATION:
				_localctx = new ExclamationStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26); match(EXCLAMATION);
				}
				break;
			case QUES:
				_localctx = new QuesStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(27); match(QUES);
				}
				break;
			case COLON:
				_localctx = new ColonStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(28); match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
	 
		public SymbolContext() { }
		public void copyFrom(SymbolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CiteStatContext extends SymbolContext {
		public TerminalNode CITE() { return getToken(SyntaxParser.CITE, 0); }
		public CiteStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterCiteStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitCiteStat(this);
		}
	}
	public static class NumberStatContext extends SymbolContext {
		public TerminalNode NUMBER() { return getToken(SyntaxParser.NUMBER, 0); }
		public NumberStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNumberStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNumberStat(this);
		}
	}
	public static class NumberDotStatContext extends SymbolContext {
		public TerminalNode NUMBER(int i) {
			return getToken(SyntaxParser.NUMBER, i);
		}
		public TerminalNode DOT() { return getToken(SyntaxParser.DOT, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SyntaxParser.NUMBER); }
		public NumberDotStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNumberDotStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNumberDotStat(this);
		}
	}
	public static class NlStatContext extends SymbolContext {
		public TerminalNode NL() { return getToken(SyntaxParser.NL, 0); }
		public NlStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNlStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNlStat(this);
		}
	}
	public static class BrackStatContext extends SymbolContext {
		public TerminalNode BRACK() { return getToken(SyntaxParser.BRACK, 0); }
		public BrackStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterBrackStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitBrackStat(this);
		}
	}
	public static class WordStatContext extends SymbolContext {
		public TerminalNode WORD() { return getToken(SyntaxParser.WORD, 0); }
		public WordStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterWordStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitWordStat(this);
		}
	}
	public static class RbrackStatContext extends SymbolContext {
		public TerminalNode RBRACK() { return getToken(SyntaxParser.RBRACK, 0); }
		public RbrackStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterRbrackStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitRbrackStat(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_symbol);
		try {
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new BrackStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31); match(BRACK);
				}
				break;
			case 2:
				_localctx = new RbrackStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32); match(RBRACK);
				}
				break;
			case 3:
				_localctx = new CiteStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33); match(CITE);
				}
				break;
			case 4:
				_localctx = new NumberDotStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(34); match(NUMBER);
				setState(35); match(DOT);
				setState(36); match(NUMBER);
				}
				break;
			case 5:
				_localctx = new NumberStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(37); match(NUMBER);
				}
				break;
			case 6:
				_localctx = new WordStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(38); match(WORD);
				}
				break;
			case 7:
				_localctx = new NlStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(39); match(NL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\3\3\3\3\3\7\3\24\n"+
		"\3\f\3\16\3\27\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4 \n\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5+\n\5\3\5\2\2\6\2\4\6\b\2\2\65\2\r\3\2\2\2\4"+
		"\20\3\2\2\2\6\37\3\2\2\2\b*\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\17\3\2"+
		"\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17\r\3\2\2\2\20\25\5\6\4\2"+
		"\21\24\7\f\2\2\22\24\5\b\5\2\23\21\3\2\2\2\23\22\3\2\2\2\24\27\3\2\2\2"+
		"\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\6\4\2"+
		"\31\5\3\2\2\2\32 \7\3\2\2\33 \7\4\2\2\34 \7\5\2\2\35 \7\t\2\2\36 \7\b"+
		"\2\2\37\32\3\2\2\2\37\33\3\2\2\2\37\34\3\2\2\2\37\35\3\2\2\2\37\36\3\2"+
		"\2\2 \7\3\2\2\2!+\7\6\2\2\"+\7\7\2\2#+\7\n\2\2$%\7\13\2\2%&\7\3\2\2&+"+
		"\7\13\2\2\'+\7\13\2\2(+\7\f\2\2)+\7\r\2\2*!\3\2\2\2*\"\3\2\2\2*#\3\2\2"+
		"\2*$\3\2\2\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+\t\3\2\2\2\7\r\23\25\37*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}