package br.ufpe.cin.if688.minijava.visitor.implemented_antlr;

import br.ufpe.cin.if688.minijava.ast.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Iterator;

public class ImpPedroVisitor implements pedroVisitor<Object> {

    public ImpPedroVisitor() {
    }

    @Override
    public Object visitGoal(pedroParser.GoalContext ctx) {
        MainClass mainClass = (MainClass) ctx.mainClass().accept(this);
        ClassDeclList cdl = new ClassDeclList();
        for (pedroParser.ClassDeclarationContext classDeclarationContext : ctx.classDeclaration()) {
            cdl.addElement((ClassDecl) classDeclarationContext.accept(this));
        }
        return new Program(mainClass, cdl);
    }

    @Override
    public Object visitMainClass(pedroParser.MainClassContext ctx) {
        Identifier id1 = (Identifier) ctx.identifier(0).accept(this);

        Identifier id2 = (Identifier) ctx.identifier(1).accept(this);

        Statement s = (Statement) ctx.statement().accept(this);
        return new MainClass(id1, id2, s);
    }

    @Override
    public Object visitClassDeclaration(pedroParser.ClassDeclarationContext ctx) {
        Identifier id = (Identifier) ctx.identifier(0).accept(this);

        VarDeclList varDecList = new VarDeclList();
        for (pedroParser.VarDeclarationContext varDeclarationContext : ctx.varDeclaration()) {
            varDecList.addElement((VarDecl) varDeclarationContext.accept(this));
        }

        MethodDeclList methodDecList = new MethodDeclList();
        for (pedroParser.MethodDeclarationContext methodDeclarationContext : ctx.methodDeclaration()) {
            methodDecList.addElement((MethodDecl) methodDeclarationContext.accept(this));
        }

        if (ctx.identifier().size() > 1) {
            Identifier id2 = (Identifier) ctx.identifier(1).accept(this);
            return new ClassDeclExtends(id, id2, varDecList, methodDecList);
        } else
            return new ClassDeclSimple(id, varDecList, methodDecList);
    }

    @Override
    public Object visitVarDeclaration(pedroParser.VarDeclarationContext ctx) {
        Type t = (Type) ctx.type().accept(this);
        Identifier id = (Identifier) ctx.identifier().accept(this);
        return new VarDecl(t, id);
    }

    @Override
    public Object visitMethodDeclaration(pedroParser.MethodDeclarationContext ctx) {
        Type typ = (Type) ctx.type(0).accept(this);
        Identifier id = (Identifier) ctx.identifier(0).accept(this);

        FormalList fl = new FormalList();
        Iterator<pedroParser.TypeContext> itt = ctx.type().iterator();
        Iterator<pedroParser.IdentifierContext> itd = ctx.identifier().iterator();
        itt.next();
        itd.next();
        while (itd.hasNext() && itt.hasNext()) {
            Formal frm = new Formal((Type) itt.next().accept(this), (Identifier) itd.next().accept(this));
            fl.addElement(frm);
        }

        VarDeclList varDeclist = new VarDeclList();
        Iterator<pedroParser.VarDeclarationContext> it = ctx.varDeclaration().iterator();
        while (it.hasNext()) {
            varDeclist.addElement((VarDecl) it.next().accept(this));
        }

        StatementList stmList = new StatementList();
        Iterator<pedroParser.StatementContext> itStm = ctx.statement().iterator();
        while (itStm.hasNext()) {
            stmList.addElement((Statement) itStm.next().accept(this));
        }

        Exp exp = (Exp) ctx.expression().accept(this);
        return new MethodDecl(typ, id, fl, varDeclist, stmList, exp);
    }

    @Override
    public Object visitType(pedroParser.TypeContext ctx) {
        String str = ctx.getText();
        switch (str) {
            case "boolean":
                return new BooleanType();
            case "int[]":
                return new IntArrayType();
            case "int":
                return new IntegerType();
            default:
                return new IdentifierType(str);
        }
    }

    @Override
    public Object visitCochetes(pedroParser.CochetesContext ctx) {
        StatementList stmList = new StatementList();
        for (pedroParser.StatementContext e : ctx.statement()) {
            stmList.addElement((Statement) e.accept(this));
        }
        return new Block(stmList);
    }

    @Override
    public Object visitIf(pedroParser.IfContext ctx) {
        Exp e1 = (Exp) ctx.expression().accept(this);
        Statement st1 = (Statement) ctx.statement().get(0).accept(this);
        Statement st2 = (Statement) ctx.statement().get(1).accept(this);
        return new If(e1,st1,st2);
    }

    @Override
    public Object visitWhile(pedroParser.WhileContext ctx) {
        Statement st1 = (Statement) ctx.statement().accept(this);
        Exp ex = (Exp) ctx.expression().accept(this);
        return new While(ex, st1);
    }

    @Override
    public Object visitPrint(pedroParser.PrintContext ctx) {
        Exp e = (Exp) ctx.expression().accept(this);
        return new Print(e);
    }

    @Override
    public Object visitAtribuicao(pedroParser.AtribuicaoContext ctx) {
        Exp e = (Exp) ctx.expression().accept(this);
        Identifier i = (Identifier) ctx.identifier().accept(this);
        return new Assign(i,e);
    }

    @Override
    public Object visitAtribuicaoArray(pedroParser.AtribuicaoArrayContext ctx) {
        Exp e1 = (Exp) ctx.expression().get(0).accept(this);
        Exp e2 = (Exp) ctx.expression().get(1).accept(this);
        Identifier i = (Identifier) ctx.identifier().accept(this);
        return new ArrayAssign(i,e1,e2);
    }

    @Override
    public Object visitNegation(pedroParser.NegationContext ctx) {
        Exp e = (Exp) ctx.expression().accept(this);
        return new Not(e);
    }

    @Override
    public Object visitFalse(pedroParser.FalseContext ctx) {
        return new False();
    }

    @Override
    public Object visitThis(pedroParser.ThisContext ctx) {
        return new This();
    }

    @Override
    public Object visitLength(pedroParser.LengthContext ctx) {
        Exp e = (Exp) ctx.expression().accept(this);
        return new ArrayLength(e);
    }

    @Override
    public Object visitNewArray(pedroParser.NewArrayContext ctx) {
        Exp e = (Exp) ctx.expression().accept(this);
        return new NewArray(e);
    }

    @Override
    public Object visitArrayLookup(pedroParser.ArrayLookupContext ctx) {
        Exp e1 = (Exp) ctx.expression().get(0).accept(this);
        Exp e2 = (Exp) ctx.expression().get(1).accept(this);
        return new ArrayLookup(e1,e2);
    }

    @Override
    public Object visitNewObj(pedroParser.NewObjContext ctx) {
        Identifier id = (Identifier) ctx.identifier().accept(this);
        return new NewObject(id);
    }

    @Override
    public Object visitLiteral(pedroParser.LiteralContext ctx) {
        return new IntegerLiteral(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Object visitCall(pedroParser.CallContext ctx) {

        ExpList el = new ExpList();
        Exp e1 = (Exp) ctx.expression().get(0).accept(this);
        Identifier id = (Identifier) ctx.identifier().accept(this);
        for(int i = 1; i < ctx.expression().size(); i++){
            el.addElement( (Exp) ctx.expression().get(i).accept(this));
        }
        return new Call(e1,id,el);
    }

    @Override
    public Object visitAddParenthesis(pedroParser.AddParenthesisContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public Object visitTrue(pedroParser.TrueContext ctx) {
        return new True();
    }

    @Override
    public Object visitId(pedroParser.IdContext ctx) {
        return new IdentifierExp(ctx.getText());
    }

    @Override
    public Object visitExpressaoBinaria(pedroParser.ExpressaoBinariaContext ctx) {
        Exp e0 = (Exp) ctx.expression().get(0).accept(this);
        Exp e1 = (Exp) ctx.expression().get(1).accept(this);
        String op = ctx.OPERATOR().getText();
        switch (op){
            case "&&":
                return new And(e0,e1);
            case "<":
                return new LessThan(e0,e1);
            case "+":
                return new Plus(e0,e1);
            case "-":
                return new Minus(e0,e1);
            case "*":
                return new Times(e0,e1);
        }
        return null;
    }

//    @Override
//    public Object visitStatement(pedroParser.StatementContext ctx) {
//        switch (ctx.getStart().getText()) {
//            case "{":
//                StatementList stmList = new StatementList();
//                Iterator<pedroParser.StatementContext> it = (Iterator<pedroParser.StatementContext>) ctx.statement().iterator();
//                while (it.hasNext()) {
//                    stmList.addElement((Statement) it.next().accept(this));
//                }
//                return new Block(stmList);
//            case "if":
//                Exp exp = (Exp) ctx.expression(0).accept(this);
//                Statement s1 = (Statement) ctx.statement(0).accept(this);
//                Statement s2 = (Statement) ctx.statement(1).accept(this);
//                return new If(exp, s1, s2);
//            case "while":
//                Exp exp1 = (Exp) ctx.expression(0).accept(this);
//                Statement s3 = (Statement) ctx.statement(0).accept(this);
//                return new While(exp1, s3);
//            case "System.out.println":
//                return new Print((Exp) ctx.expression(0).accept(this));
//            default:
//                if (ctx.expression().size() == 1) {
//                    Identifier id = (Identifier) ctx.identifier().accept(this);
//                    Exp exp2 = (Exp) ctx.expression(0).accept(this);
//                    return new Assign(id, exp2);
//                } else {
//                    Identifier i = (Identifier) ctx.identifier().accept(this);
//                    Exp exp3 = (Exp) ctx.expression(0).accept(this);
//                    Exp exp4 = (Exp) ctx.expression(1).accept(this);
//                    return new ArrayAssign(i, exp3, exp4);
//                }
//        }
//    }
//
//    @Override
//    public Object visitExpression(pedroParser.ExpressionContext ctx) {
//        int nExps = ctx.expression().size();
//        int nChild = ctx.getChildCount();
//
//        if (nChild >= 5) {
//            String op = ctx.getChild(3).getText();
//            if (op.equals("(")) {
//                Exp exp = (Exp) ctx.expression(0).accept(this);
//                Identifier id = (Identifier) ctx.identifier().accept(this);
//
//                ExpList el = new ExpList();
//                Iterator<pedroParser.ExpressionContext> it = ctx.expression().iterator();
//                it.next();
//                while (it.hasNext()) {
//                    el.addElement((Exp) it.next().accept(this));
//                }
//
//                return new Call(exp, id, el);
//            }
//        }
//
//        if (nExps == 2) {
//            Exp e1 = (Exp) ctx.expression(0).accept(this);
//            Exp e2 = (Exp) ctx.expression(1).accept(this);
//
//            if (nChild == 3) {
//                switch (ctx.getChild(1).getText()) {
//                    case "&&":
//                        return new And(e1, e2);
//                    case "+":
//                        return new Plus(e1, e2);
//                    case "-":
//                        return new Minus(e1, e2);
//                    case "<":
//                        return new LessThan(e1, e2);
//                    default:
//                        return new Times(e1, e2);
//                }
//            } else return new ArrayLookup(e1, e2);
//        } else if (nExps == 1) {
//            Exp exp = (Exp) ctx.expression(0).accept(this);
//            switch (ctx.getChild(1).getText()) {
//                case "!":
//                    return new Not(exp);
//                case ".":
//                    return new ArrayLength(exp);
//                case "(":
//                    return (Exp) ctx.expression(0).accept(this);
//                default:
//                    return new NewArray(exp);
//            }
//        } else {
//            String s = ctx.getStart().getText();
//            switch (s) {
//                case "false":
//                    return new False();
//                case "this":
//                    return new This();
//                case "true":
//                    return new True();
//                case "new":
//                    return new NewObject((Identifier) ctx.identifier().accept(this));
//                default:
//                    if (s.matches("\\d+")) {
//                        return (IntegerLiteral) ctx.integerLiteral().accept(this);
//                    } else {
//                        return (Identifier) ctx.identifier().accept(this);
//                    }
//            }
//        }
//    }

    @Override
    public Object visitIdentifier(pedroParser.IdentifierContext ctx) {
        return new Identifier(ctx.getText());
    }

    @Override
    public Object visitIntegerLiteral(pedroParser.IntegerLiteralContext ctx) {
        return new IntegerLiteral(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return parseTree.accept(this);
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
