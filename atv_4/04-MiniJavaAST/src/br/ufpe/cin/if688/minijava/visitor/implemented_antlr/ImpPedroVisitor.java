package br.ufpe.cin.if688.minijava.visitor.implemented_antlr;

import br.ufpe.cin.if688.minijava.ast.*;
import br.ufpe.cin.if688.minijava.main.Main;
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
        Iterator<pedroParser.ClassDeclarationContext> it = (Iterator<pedroParser.ClassDeclarationContext>) ctx.classDeclaration().iterator();
        while (it.hasNext()) {
            cdl.addElement((ClassDecl) it.next().accept(this));
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
        Iterator<pedroParser.VarDeclarationContext> it = (Iterator<pedroParser.VarDeclarationContext>) ctx.varDeclaration().iterator();
        while (it.hasNext()) {
            varDecList.addElement((VarDecl) it.next().accept(this));
        }

        MethodDeclList methodDecList = new MethodDeclList();
        Iterator<pedroParser.MethodDeclarationContext> itM = (Iterator<pedroParser.MethodDeclarationContext>) ctx.methodDeclaration().iterator();
        while (itM.hasNext()) {
            methodDecList.addElement((MethodDecl) itM.next().accept(this));
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
        Iterator<pedroParser.TypeContext> itt = (Iterator<pedroParser.TypeContext>) ctx.type().iterator();
        Iterator<pedroParser.IdentifierContext> itd = (Iterator<pedroParser.IdentifierContext>) ctx.identifier().iterator();
        itt.next();
        itd.next();
        while (itd.hasNext() && itt.hasNext()) {
            Formal frm = new Formal((Type) itt.next().accept(this), (Identifier) itd.next().accept(this));
            fl.addElement(frm);
        }

        VarDeclList varDeclist = new VarDeclList();
        Iterator<pedroParser.VarDeclarationContext> it = (Iterator<pedroParser.VarDeclarationContext>) ctx.varDeclaration().iterator();
        while (it.hasNext()) {
            varDeclist.addElement((VarDecl) it.next().accept(this));
        }

        StatementList stmList = new StatementList();
        Iterator<pedroParser.StatementContext> itStm = (Iterator<pedroParser.StatementContext>) ctx.statement().iterator();
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
    public Object visitStatement(pedroParser.StatementContext ctx) {
        switch (ctx.getStart().getText()) {
            case "{":
                StatementList stmList = new StatementList();
                Iterator<pedroParser.StatementContext> it = (Iterator<pedroParser.StatementContext>) ctx.statement().iterator();
                while (it.hasNext()) {
                    stmList.addElement((Statement) it.next().accept(this));
                }
                return new Block(stmList);
            case "if":
                Exp exp = (Exp) ctx.expression(0).accept(this);
                Statement s1 = (Statement) ctx.statement(0).accept(this);
                Statement s2 = (Statement) ctx.statement(1).accept(this);
                return new If(exp, s1, s2);
            case "while":
                Exp exp1 = (Exp) ctx.expression(0).accept(this);
                Statement s3 = (Statement) ctx.statement(0).accept(this);
                return new While(exp1, s3);
            case "System.out.println":
                return new Print((Exp) ctx.expression(0).accept(this));
            default:
                if (ctx.expression().size() == 1) {
                    Identifier id = (Identifier) ctx.identifier().accept(this);
                    Exp exp2 = (Exp) ctx.expression(0).accept(this);
                    return new Assign(id, exp2);
                } else {
                    Identifier i = (Identifier) ctx.identifier().accept(this);
                    Exp exp3 = (Exp) ctx.expression(0).accept(this);
                    Exp exp4 = (Exp) ctx.expression(1).accept(this);
                    return new ArrayAssign(i, exp3, exp4);
                }
        }
    }

    @Override
    public Object visitExpression(pedroParser.ExpressionContext ctx) {
        int nExps = ctx.expression().size();
        int nChild = ctx.getChildCount();

        if (nChild >= 5) {
            String op = ctx.getChild(3).getText();
            if (op.equals("(")) {
                Exp exp = (Exp) ctx.expression(0).accept(this);
                Identifier id = (Identifier) ctx.identifier().accept(this);

                ExpList el = new ExpList();
                Iterator<pedroParser.ExpressionContext> it = (Iterator<pedroParser.ExpressionContext>) ctx.expression().iterator();
                it.next();
                while (it.hasNext()) {
                    el.addElement((Exp) it.next().accept(this));
                }

                return new Call(exp, id, el);
            }
        }

        if (nExps == 2) {
            Exp e1 = (Exp) ctx.expression(0).accept(this);
            Exp e2 = (Exp) ctx.expression(1).accept(this);

            if (nChild == 3) {
                switch (ctx.getChild(1).getText()) {
                    case "&&":
                        return new And(e1, e2);
                    case "+":
                        return new Plus(e1, e2);
                    case "-":
                        return new Minus(e1, e2);
                    case "<":
                        return new LessThan(e1, e2);
                    default:
                        return new Times(e1, e2);
                }
            } else return new ArrayLookup(e1, e2);
        } else if (nExps == 1) {
            Exp exp = (Exp) ctx.expression(0).accept(this);
            switch (ctx.getChild(1).getText()) {
                case "!":
                    return new Not(exp);
                case ".":
                    return new ArrayLength(exp);
                case "(":
                    return (Exp) ctx.expression(0).accept(this);
                default:
                    return new NewArray(exp);
            }
        } else {
            String s = ctx.getStart().getText();
            switch (s) {
                case "false":
                    return new False();
                case "this":
                    return new This();
                case "true":
                    return new True();
                case "new":
                    return new NewObject((Identifier) ctx.identifier().accept(this));
                default:
                    if (s.matches("\\d+")) {
                        return (IntegerLiteral) ctx.integerLiteral().accept(this);
                    } else {
                        return (Identifier) ctx.identifier().accept(this);
                    }
            }
        }
    }

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
