// Generated from /home/p/github/if688.github.io/atividades/04-MiniJavaAST/src/br/ufpe/cin/if688/minijava/pedro.g4 by ANTLR 4.7
package br.ufpe.cin.if688.minijava.visitor.implemented_antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pedroParser}.
 */
public interface pedroListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pedroParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(pedroParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(pedroParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(pedroParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(pedroParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(pedroParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(pedroParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(pedroParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(pedroParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(pedroParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(pedroParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(pedroParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(pedroParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(pedroParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(pedroParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(pedroParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(pedroParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(pedroParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(pedroParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link pedroParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(pedroParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link pedroParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(pedroParser.IntegerLiteralContext ctx);
}