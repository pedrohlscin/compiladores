package br.ufpe.cin.if688.minijava.main;

import br.ufpe.cin.if688.minijava.ast.*;
import br.ufpe.cin.if688.minijava.visitor.PrettyPrintVisitor;
import br.ufpe.cin.if688.minijava.visitor.implemented_antlr.ImpPedroVisitor;
import br.ufpe.cin.if688.minijava.visitor.implemented_antlr.pedroLexer;
import br.ufpe.cin.if688.minijava.visitor.implemented_antlr.pedroParser;
import br.ufpe.cin.if688.minijava.visitor.implemented_antlr.pedroVisitor;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
//		MainClass main = new MainClass(
//				new Identifier("Teste"),
//				new Identifier("Testando"),
//				new Print(new IntegerLiteral(2))
//		);
//
//		VarDeclList vdl1 = new VarDeclList();
//		vdl1.addElement(new VarDecl(
//			new BooleanType(),
//			new Identifier("flag")
//		));
//		vdl1.addElement(new VarDecl(
//				new IntegerType(),
//				new Identifier("num")
//		));
//
//		MethodDeclList mdl = new MethodDeclList();
//
//		ClassDeclSimple A = new ClassDeclSimple(
//					new Identifier("A"), vdl1, mdl
//		);
//
//		ClassDeclExtends B = new ClassDeclExtends(
//				new Identifier("B"), new Identifier("A"),
//				new VarDeclList(), new MethodDeclList()
//		);
//
//		VarDeclList vdl2 = new VarDeclList();
//		vdl2.addElement(new VarDecl(
//				new IdentifierType("A"),
//				new Identifier("obj")
//		));
//		ClassDeclSimple C = new ClassDeclSimple(
//				new Identifier("C"), vdl2, new MethodDeclList()
//		);
//
//		ClassDeclList cdl = new ClassDeclList();
//		cdl.addElement(A);
//		cdl.addElement(B);
//		cdl.addElement(C);
//
//		Program p = new Program(main, cdl);
//
//		PrettyPrintVisitor ppv = new PrettyPrintVisitor();
//		ppv.visit(p);
		try {
			ImpPedroVisitor astVisitor = new ImpPedroVisitor();
			CharStream cs = CharStreams.fromFileName("/home/p/github/if688.github.io/atividades/04-MiniJavaAST/src/br/ufpe/cin/if688/minijava/resources/teste_basico.txt");



				pedroLexer lexer = new pedroLexer(cs);
				TokenStream tokenStream = new BufferedTokenStream(lexer);
				pedroParser parser = new pedroParser(tokenStream);

				pedroParser.GoalContext program = parser.goal();
				Program p = (Program) astVisitor.visitGoal(program);
				PrettyPrintVisitor ppv = new PrettyPrintVisitor();
				ppv.visit(p);
			} catch(IOException e) {
				System.err.println("Erro ao abrir arquivo!");
				e.printStackTrace();
				System.exit(1);
			}
	}

}
