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
		DOT=1, KOM=2, AUS=3, BRACK=4, RBRACK=5, QUES=6, CITE=7, NUMBER=8, WORD=9, 
		NL=10, SKIPED=11, WS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "','", "'!'", "'('", "'['", "'?'", "CITE", "NUMBER", 
		"WORD", "'\n'", "SKIPED", "WS"
	};
	public static final int
		RULE_stat = 0, RULE_symbol = 1;
	public static final String[] ruleNames = {
		"stat", "symbol"
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
	public static class SymbolStatContext extends StatContext {
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterSymbolStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitSymbolStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitSymbolStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			_localctx = new SymbolStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT) | (1L << KOM) | (1L << AUS) | (1L << BRACK) | (1L << RBRACK) | (1L << QUES) | (1L << CITE) | (1L << NUMBER) | (1L << WORD) | (1L << NL))) != 0)) {
				{
				{
				setState(4); symbol();
				}
				}
				setState(9);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitCiteStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KomStatContext extends SymbolContext {
		public TerminalNode KOM() { return getToken(SyntaxParser.KOM, 0); }
		public KomStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterKomStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitKomStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitKomStat(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitNumberStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuesStatContext extends SymbolContext {
		public TerminalNode QUES() { return getToken(SyntaxParser.QUES, 0); }
		public QuesStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterQuesStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitQuesStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitQuesStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AusStatContext extends SymbolContext {
		public TerminalNode AUS() { return getToken(SyntaxParser.AUS, 0); }
		public AusStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterAusStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitAusStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitAusStat(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitNlStat(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitBrackStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DotStatContext extends SymbolContext {
		public TerminalNode DOT() { return getToken(SyntaxParser.DOT, 0); }
		public DotStatContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).enterDotStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SyntaxListener ) ((SyntaxListener)listener).exitDotStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitDotStat(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitWordStat(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitRbrackStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_symbol);
		try {
			setState(20);
			switch (_input.LA(1)) {
			case DOT:
				_localctx = new DotStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10); match(DOT);
				}
				break;
			case KOM:
				_localctx = new KomStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(11); match(KOM);
				}
				break;
			case AUS:
				_localctx = new AusStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(12); match(AUS);
				}
				break;
			case BRACK:
				_localctx = new BrackStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(13); match(BRACK);
				}
				break;
			case RBRACK:
				_localctx = new RbrackStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(14); match(RBRACK);
				}
				break;
			case QUES:
				_localctx = new QuesStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(15); match(QUES);
				}
				break;
			case CITE:
				_localctx = new CiteStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(16); match(CITE);
				}
				break;
			case NUMBER:
				_localctx = new NumberStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(17); match(NUMBER);
				}
				break;
			case WORD:
				_localctx = new WordStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(18); match(WORD);
				}
				break;
			case NL:
				_localctx = new NlStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(19); match(NL);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\31\4\2\t\2\4\3"+
		"\t\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\27\n\3\3\3\2\2\4\2\4\2\2 \2\t\3\2\2\2\4\26\3\2\2\2\6\b\5\4"+
		"\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13\t"+
		"\3\2\2\2\f\27\7\3\2\2\r\27\7\4\2\2\16\27\7\5\2\2\17\27\7\6\2\2\20\27\7"+
		"\7\2\2\21\27\7\b\2\2\22\27\7\t\2\2\23\27\7\n\2\2\24\27\7\13\2\2\25\27"+
		"\7\f\2\2\26\f\3\2\2\2\26\r\3\2\2\2\26\16\3\2\2\2\26\17\3\2\2\2\26\20\3"+
		"\2\2\2\26\21\3\2\2\2\26\22\3\2\2\2\26\23\3\2\2\2\26\24\3\2\2\2\26\25\3"+
		"\2\2\2\27\5\3\2\2\2\4\t\26";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}