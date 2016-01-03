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
	 * Enter a parse tree produced by the {@code number_with_dot}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNumber_with_dot(@NotNull SyntaxParser.Number_with_dotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number_with_dot}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNumber_with_dot(@NotNull SyntaxParser.Number_with_dotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comma}
	 * labeled alternative in {@link SyntaxParser#subSentence}.
	 * @param ctx the parse tree
	 */
	void enterComma(@NotNull SyntaxParser.CommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comma}
	 * labeled alternative in {@link SyntaxParser#subSentence}.
	 * @param ctx the parse tree
	 */
	void exitComma(@NotNull SyntaxParser.CommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SyntaxParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SyntaxParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull SyntaxParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull SyntaxParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code brack}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterBrack(@NotNull SyntaxParser.BrackContext ctx);
	/**
	 * Exit a parse tree produced by the {@code brack}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitBrack(@NotNull SyntaxParser.BrackContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dot}
	 * labeled alternative in {@link SyntaxParser#subSentence}.
	 * @param ctx the parse tree
	 */
	void enterDot(@NotNull SyntaxParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dot}
	 * labeled alternative in {@link SyntaxParser#subSentence}.
	 * @param ctx the parse tree
	 */
	void exitDot(@NotNull SyntaxParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cite}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterCite(@NotNull SyntaxParser.CiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cite}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitCite(@NotNull SyntaxParser.CiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noun}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNoun(@NotNull SyntaxParser.NounContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noun}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNoun(@NotNull SyntaxParser.NounContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Question}
	 * labeled alternative in {@link SyntaxParser#subSentence}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull SyntaxParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Question}
	 * labeled alternative in {@link SyntaxParser#subSentence}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull SyntaxParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code word}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterWord(@NotNull SyntaxParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code word}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitWord(@NotNull SyntaxParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nl}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterNl(@NotNull SyntaxParser.NlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nl}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitNl(@NotNull SyntaxParser.NlContext ctx);
}