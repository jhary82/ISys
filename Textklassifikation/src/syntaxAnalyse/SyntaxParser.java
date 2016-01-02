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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SyntaxVisitor ) return ((SyntaxVisitor<? extends T>)visitor).visitNumberDotStat(this);
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
			setState(23);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DotStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10); match(DOT);
				}
				break;
			case 2:
				_localctx = new KomStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(11); match(KOM);
				}
				break;
			case 3:
				_localctx = new AusStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(12); match(AUS);
				}
				break;
			case 4:
				_localctx = new BrackStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(13); match(BRACK);
				}
				break;
			case 5:
				_localctx = new RbrackStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(14); match(RBRACK);
				}
				break;
			case 6:
				_localctx = new QuesStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(15); match(QUES);
				}
				break;
			case 7:
				_localctx = new CiteStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(16); match(CITE);
				}
				break;
			case 8:
				_localctx = new NumberDotStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(17); match(NUMBER);
				setState(18); match(DOT);
				setState(19); match(NUMBER);
				}
				break;
			case 9:
				_localctx = new NumberStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(20); match(NUMBER);
				}
				break;
			case 10:
				_localctx = new WordStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(21); match(WORD);
				}
				break;
			case 11:
				_localctx = new NlStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(22); match(NL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\34\4\2\t\2\4\3"+
		"\t\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3\32\n\3\3\3\2\2\4\2\4\2\2$\2\t\3\2\2\2\4\31\3\2"+
		"\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3"+
		"\3\2\2\2\13\t\3\2\2\2\f\32\7\3\2\2\r\32\7\4\2\2\16\32\7\5\2\2\17\32\7"+
		"\6\2\2\20\32\7\7\2\2\21\32\7\b\2\2\22\32\7\t\2\2\23\24\7\n\2\2\24\25\7"+
		"\3\2\2\25\32\7\n\2\2\26\32\7\n\2\2\27\32\7\13\2\2\30\32\7\f\2\2\31\f\3"+
		"\2\2\2\31\r\3\2\2\2\31\16\3\2\2\2\31\17\3\2\2\2\31\20\3\2\2\2\31\21\3"+
		"\2\2\2\31\22\3\2\2\2\31\23\3\2\2\2\31\26\3\2\2\2\31\27\3\2\2\2\31\30\3"+
		"\2\2\2\32\5\3\2\2\2\4\t\31";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}