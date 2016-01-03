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
		DOT=1, COMMA=2, EXCLAMATION=3, BRACK=4, RBRACK=5, QUES=6, CITE=7, NUMBER=8, 
		NOUN=9, WORD=10, NL=11, SKIPED=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "COMMA", "'!'", "'('", "'['", "'?'", "CITE", "NUMBER", 
		"NOUN", "WORD", "'\n'", "SKIPED", "WS"
	};
	public static final int
		RULE_stat = 0, RULE_sentence = 1, RULE_subSentence = 2, RULE_symbol = 3;
	public static final String[] ruleNames = {
		"stat", "sentence", "subSentence", "symbol"
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
		public TerminalNode EOF() { return getToken(SyntaxParser.EOF, 0); }
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(10);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(8); sentence();
					}
					break;
				case 2:
					{
					setState(9); symbol();
					}
					break;
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << COMMA) | (1L << EXCLAMATION) | (1L << BRACK) | (1L << RBRACK) | (1L << QUES) | (1L << CITE) | (1L << NUMBER) | (1L << NOUN) | (1L << WORD) | (1L << NL))) != 0) );
			setState(14); match(EOF);
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
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SubSentenceContext subSentence() {
			return getRuleContext(SubSentenceContext.class,0);
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
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACK) | (1L << RBRACK) | (1L << CITE) | (1L << NUMBER) | (1L << NOUN) | (1L << WORD) | (1L << NL))) != 0)) {
				{
				{
				setState(16); symbol();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22); subSentence();
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

	public static class SubSentenceContext extends ParserRuleContext {
		public SubSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subSentence; }
	 
		public SubSentenceContext() { }
		public void copyFrom(SubSentenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CommaContext extends SubSentenceContext {
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SyntaxParser.COMMA, 0); }
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public List<SubSentenceContext> subSentence() {
			return getRuleContexts(SubSentenceContext.class);
		}
		public SubSentenceContext subSentence(int i) {
			return getRuleContext(SubSentenceContext.class,i);
		}
		public CommaContext(SubSentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitComma(this);
		}
	}
	public static class DotContext extends SubSentenceContext {
		public TerminalNode DOT() { return getToken(SyntaxParser.DOT, 0); }
		public DotContext(SubSentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitDot(this);
		}
	}
	public static class QuestionContext extends SubSentenceContext {
		public TerminalNode EXCLAMATION() { return getToken(SyntaxParser.EXCLAMATION, 0); }
		public TerminalNode QUES() { return getToken(SyntaxParser.QUES, 0); }
		public QuestionContext(SubSentenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitQuestion(this);
		}
	}

	public final SubSentenceContext subSentence() throws RecognitionException {
		SubSentenceContext _localctx = new SubSentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subSentence);
		int _la;
		try {
			int _alt;
			setState(38);
			switch (_input.LA(1)) {
			case DOT:
				_localctx = new DotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24); match(DOT);
				}
				break;
			case COMMA:
				_localctx = new CommaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(COMMA);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACK) | (1L << RBRACK) | (1L << CITE) | (1L << NUMBER) | (1L << NOUN) | (1L << WORD) | (1L << NL))) != 0)) {
					{
					{
					setState(26); symbol();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(33); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(32); subSentence();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(35); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case EXCLAMATION:
			case QUES:
				_localctx = new QuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				_la = _input.LA(1);
				if ( !(_la==EXCLAMATION || _la==QUES) ) {
				_errHandler.recoverInline(this);
				}
				consume();
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
	public static class Number_with_dotContext extends SymbolContext {
		public TerminalNode NUMBER(int i) {
			return getToken(SyntaxParser.NUMBER, i);
		}
		public TerminalNode DOT() { return getToken(SyntaxParser.DOT, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SyntaxParser.NUMBER); }
		public Number_with_dotContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNumber_with_dot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNumber_with_dot(this);
		}
	}
	public static class NumberContext extends SymbolContext {
		public TerminalNode NUMBER() { return getToken(SyntaxParser.NUMBER, 0); }
		public NumberContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNumber(this);
		}
	}
	public static class BrackContext extends SymbolContext {
		public TerminalNode BRACK() { return getToken(SyntaxParser.BRACK, 0); }
		public TerminalNode RBRACK() { return getToken(SyntaxParser.RBRACK, 0); }
		public BrackContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterBrack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitBrack(this);
		}
	}
	public static class CiteContext extends SymbolContext {
		public TerminalNode CITE() { return getToken(SyntaxParser.CITE, 0); }
		public CiteContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterCite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitCite(this);
		}
	}
	public static class NounContext extends SymbolContext {
		public TerminalNode NOUN() { return getToken(SyntaxParser.NOUN, 0); }
		public NounContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNoun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNoun(this);
		}
	}
	public static class WordContext extends SymbolContext {
		public TerminalNode WORD() { return getToken(SyntaxParser.WORD, 0); }
		public WordContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitWord(this);
		}
	}
	public static class NlContext extends SymbolContext {
		public TerminalNode NL() { return getToken(SyntaxParser.NL, 0); }
		public NlContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterNl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitNl(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_symbol);
		int _la;
		try {
			setState(49);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new BrackContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				_la = _input.LA(1);
				if ( !(_la==BRACK || _la==RBRACK) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 2:
				_localctx = new CiteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41); match(CITE);
				}
				break;
			case 3:
				_localctx = new Number_with_dotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42); match(NUMBER);
				setState(43); match(DOT);
				setState(44); match(NUMBER);
				}
				break;
			case 4:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(45); match(NUMBER);
				}
				break;
			case 5:
				_localctx = new WordContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(46); match(WORD);
				}
				break;
			case 6:
				_localctx = new NounContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(47); match(NOUN);
				}
				break;
			case 7:
				_localctx = new NlContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(48); match(NL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\6\2\r\n\2\r\2\16\2\16\3\2\3\2\3\3\7\3\24"+
		"\n\3\f\3\16\3\27\13\3\3\3\3\3\3\4\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3"+
		"\4\6\4$\n\4\r\4\16\4%\3\4\5\4)\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\64\n\5\3\5\2\2\6\2\4\6\b\2\4\4\2\5\5\b\b\3\2\6\7>\2\f\3\2\2\2\4\25"+
		"\3\2\2\2\6(\3\2\2\2\b\63\3\2\2\2\n\r\5\4\3\2\13\r\5\b\5\2\f\n\3\2\2\2"+
		"\f\13\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\20\3\2\2\2\20"+
		"\21\7\2\2\3\21\3\3\2\2\2\22\24\5\b\5\2\23\22\3\2\2\2\24\27\3\2\2\2\25"+
		"\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\6\4\2\31"+
		"\5\3\2\2\2\32)\7\3\2\2\33\37\7\4\2\2\34\36\5\b\5\2\35\34\3\2\2\2\36!\3"+
		"\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 #\3\2\2\2!\37\3\2\2\2\"$\5\6\4\2#\"\3"+
		"\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&)\3\2\2\2\')\t\2\2\2(\32\3\2\2\2"+
		"(\33\3\2\2\2(\'\3\2\2\2)\7\3\2\2\2*\64\t\3\2\2+\64\7\t\2\2,-\7\n\2\2-"+
		".\7\3\2\2.\64\7\n\2\2/\64\7\n\2\2\60\64\7\f\2\2\61\64\7\13\2\2\62\64\7"+
		"\r\2\2\63*\3\2\2\2\63+\3\2\2\2\63,\3\2\2\2\63/\3\2\2\2\63\60\3\2\2\2\63"+
		"\61\3\2\2\2\63\62\3\2\2\2\64\t\3\2\2\2\t\f\16\25\37%(\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}