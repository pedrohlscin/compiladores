// Generated from C:/Users/pedro/IdeaProjects/compiladores/atv_4/04-MiniJavaAST/src/br/ufpe/cin/if688/minijava\pedro.g4 by ANTLR 4.7
package br.ufpe.cin.if688.minijava.visitor.implemented_antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pedroParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pedroVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pedroParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(pedroParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(pedroParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(pedroParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(pedroParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(pedroParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(pedroParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cochetes}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCochetes(pedroParser.CochetesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(pedroParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(pedroParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(pedroParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atribuicao}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(pedroParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atribuicaoArray}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicaoArray(pedroParser.AtribuicaoArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(pedroParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(pedroParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code this}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis(pedroParser.ThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code length}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(pedroParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(pedroParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLookup}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookup(pedroParser.ArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObj}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObj(pedroParser.NewObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(pedroParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code call}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(pedroParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addParenthesis}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddParenthesis(pedroParser.AddParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(pedroParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(pedroParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressaoBinaria}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoBinaria(pedroParser.ExpressaoBinariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(pedroParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(pedroParser.IntegerLiteralContext ctx);
}