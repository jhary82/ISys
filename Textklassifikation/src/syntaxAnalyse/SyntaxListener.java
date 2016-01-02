// Generated from Syntax.g4 by ANTLR 4.4
package syntaxAnalyse;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SyntaxParser}.
 */
public interface SyntaxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SyntaxParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(@NotNull SyntaxParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(@NotNull SyntaxParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code citeStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterCiteStat(@NotNull SyntaxParser.CiteStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code citeStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitCiteStat(@NotNull SyntaxParser.CiteStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNumberStat(@NotNull SyntaxParser.NumberStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNumberStat(@NotNull SyntaxParser.NumberStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberDotStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNumberDotStat(@NotNull SyntaxParser.NumberDotStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberDotStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNumberDotStat(@NotNull SyntaxParser.NumberDotStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code colonStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void enterColonStat(@NotNull SyntaxParser.ColonStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colonStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void exitColonStat(@NotNull SyntaxParser.ColonStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wordStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterWordStat(@NotNull SyntaxParser.WordStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wordStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitWordStat(@NotNull SyntaxParser.WordStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sentenceStat}
	 * labeled alternative in {@link SyntaxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSentenceStat(@NotNull SyntaxParser.SentenceStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sentenceStat}
	 * labeled alternative in {@link SyntaxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSentenceStat(@NotNull SyntaxParser.SentenceStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exclamationStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void enterExclamationStat(@NotNull SyntaxParser.ExclamationStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exclamationStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void exitExclamationStat(@NotNull SyntaxParser.ExclamationStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quesStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void enterQuesStat(@NotNull SyntaxParser.QuesStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quesStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void exitQuesStat(@NotNull SyntaxParser.QuesStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void enterCommaStat(@NotNull SyntaxParser.CommaStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void exitCommaStat(@NotNull SyntaxParser.CommaStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nlStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNlStat(@NotNull SyntaxParser.NlStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nlStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNlStat(@NotNull SyntaxParser.NlStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code brackStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterBrackStat(@NotNull SyntaxParser.BrackStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code brackStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitBrackStat(@NotNull SyntaxParser.BrackStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void enterDotStat(@NotNull SyntaxParser.DotStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotStat}
	 * labeled alternative in {@link SyntaxParser#seperatorSymbol}.
	 * @param ctx the parse tree
	 */
	void exitDotStat(@NotNull SyntaxParser.DotStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rbrackStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterRbrackStat(@NotNull SyntaxParser.RbrackStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rbrackStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitRbrackStat(@NotNull SyntaxParser.RbrackStatContext ctx);
}