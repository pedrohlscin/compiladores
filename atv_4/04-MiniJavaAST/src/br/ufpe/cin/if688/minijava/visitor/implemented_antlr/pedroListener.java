// Generated from C:/Users/pedro/IdeaProjects/compiladores/atv_4/04-MiniJavaAST/src/br/ufpe/cin/if688/minijava\pedro.g4 by ANTLR 4.7
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
	 * Enter a parse tree produced by the {@code cochetes}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCochetes(pedroParser.CochetesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cochetes}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCochetes(pedroParser.CochetesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(pedroParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(pedroParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(pedroParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(pedroParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(pedroParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(pedroParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atribuicao}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(pedroParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atribuicao}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(pedroParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atribuicaoArray}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicaoArray(pedroParser.AtribuicaoArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atribuicaoArray}
	 * labeled alternative in {@link pedroParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicaoArray(pedroParser.AtribuicaoArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegation(pedroParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegation(pedroParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalse(pedroParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalse(pedroParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code this}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis(pedroParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code this}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis(pedroParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code length}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLength(pedroParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code length}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLength(pedroParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(pedroParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(pedroParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLookup}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLookup(pedroParser.ArrayLookupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLookup}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLookup(pedroParser.ArrayLookupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObj}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewObj(pedroParser.NewObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObj}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewObj(pedroParser.NewObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(pedroParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(pedroParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code call}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCall(pedroParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code call}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCall(pedroParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addParenthesis}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddParenthesis(pedroParser.AddParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addParenthesis}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddParenthesis(pedroParser.AddParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrue(pedroParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrue(pedroParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(pedroParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(pedroParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressaoBinaria}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoBinaria(pedroParser.ExpressaoBinariaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressaoBinaria}
	 * labeled alternative in {@link pedroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoBinaria(pedroParser.ExpressaoBinariaContext ctx);
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