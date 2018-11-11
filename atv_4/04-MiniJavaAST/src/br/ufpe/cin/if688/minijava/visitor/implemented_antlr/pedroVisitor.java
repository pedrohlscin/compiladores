// Generated from /home/p/github/if688.github.io/atividades/04-MiniJavaAST/src/br/ufpe/cin/if688/minijava/pedro.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(pedroParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(pedroParser.ExpressionContext ctx);
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