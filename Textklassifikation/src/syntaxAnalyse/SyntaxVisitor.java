// Generated from Syntax.g4 by ANTLR 4.4
package syntaxAnalyse;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SyntaxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SyntaxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code symbolStat}
	 * labeled alternative in {@link SyntaxParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolStat(@NotNull SyntaxParser.SymbolStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code citeStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCiteStat(@NotNull SyntaxParser.CiteStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code komStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKomStat(@NotNull SyntaxParser.KomStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberStat(@NotNull SyntaxParser.NumberStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quesStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuesStat(@NotNull SyntaxParser.QuesStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ausStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAusStat(@NotNull SyntaxParser.AusStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nlStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNlStat(@NotNull SyntaxParser.NlStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code brackStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackStat(@NotNull SyntaxParser.BrackStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotStat(@NotNull SyntaxParser.DotStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wordStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordStat(@NotNull SyntaxParser.WordStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rbrackStat}
	 * labeled alternative in {@link SyntaxParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRbrackStat(@NotNull SyntaxParser.RbrackStatContext ctx);
}