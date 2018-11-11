package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ast.*;
import br.ufpe.cin.if688.minijava.symboltable.Class;
import br.ufpe.cin.if688.minijava.symboltable.Method;
import br.ufpe.cin.if688.minijava.symboltable.SymbolTable;

public class BuildSymbolTableV implements IVisitor<Void> {

    SymbolTable symbolTable;
    public BuildSymbolTableV() { this.symbolTable = new SymbolTable(); }
    public SymbolTable getSymbolTable() { return symbolTable; }

    private Class currClass;
    private Method currMethod;

    @Override
    public Void visit(Program n) {
        n.m.accept(this);

        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MainClass n) {
        this.symbolTable.addClass(n.i1.s, null);
        this.currClass = this.symbolTable.getClass(n.i1.s);
//        checar
        this.currClass.addMethod("main", null );
        this.currMethod = currClass.getMethod("main");
        this.currMethod.addParam(n.i2.s, new IntArrayType());

        n.i1.accept(this);
        n.i2.accept(this);
        n.s.accept(this);

        this.currClass = null;
        this.currMethod = null;
        return null;
    }

    @Override
    public Void visit(ClassDeclSimple n) {
        if(this.currClass != null) {
            if(!this.symbolTable.addClass(n.i.s, this.currClass.getId())){
                System.out.println("Classe já existe");
                return null;
            }
        }
        else{
            if(!this.symbolTable.addClass(n.i.s, null)){
                System.out.println("Classe já existe");
                return null;
            }
        }

        this.currClass = this.symbolTable.getClass(n.i.s);

        n.i.accept(this);

        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }

        this.currClass = null;
        return null;
    }

    @Override
    public Void visit(ClassDeclExtends n) {
        if(this.currClass != null) {
            if(!this.symbolTable.addClass(n.i.s, this.currClass.getId())){
                System.out.println("Classe já existe");
                return null;
            }
        }
        else{
            if(!this.symbolTable.addClass(n.i.s, null)){
                System.out.println("Classe já existe");
                return null;
            }
        }

        this.currClass = this.symbolTable.getClass(n.i.s);

        n.i.accept(this);
        n.j.accept(this);
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }

        this.currClass = null;
        return null;
    }

    @Override
    public Void visit(VarDecl n) {
        if(this.currMethod != null) {
            if(!this.currMethod.addVar(n.i.s, n.t)) {
                System.out.println("Variável já existe neste bloco");
                return null;
            }
        }
        else {
            if(!this.currClass.addVar(n.i.s, n.t)) {
                System.out.println("Variável já existe neste bloco");
                return null;
            }
        }

        n.t.accept(this);
        n.i.accept(this);
        return null;
    }

    @Override
    public Void visit(MethodDecl n) {
        if(this.currClass != null) {
            if(!this.currClass.addMethod(n.i.s, n.t)) {
                System.out.println("Método já existe neste bloco");
                return null;
            }
        }
        else {
            System.out.println("Erro: Método fora de bloco");
            return null;
        }

        this.currMethod = this.currClass.getMethod(n.i.s);

        n.t.accept(this);
        n.i.accept(this);

        for (int i = 0; i < n.fl.size(); i++) {
            n.fl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.sl.size(); i++) {
            n.sl.elementAt(i).accept(this);
        }

        n.e.accept(this);
        currMethod = null;
        return null;
    }

    @Override
    public Void visit(Formal n) {
        if(this.currMethod!=null) {
            if(!this.currMethod.addParam(n.i.s, n.t)) {
                System.out.println("Parâmetro já existe!");
                return null;
            }
        }

        else {
            System.out.println("Não há método!");
            return null;
        }

        n.t.accept(this);
        n.i.accept(this);
        return null;
    }

    @Override
    public Void visit(IntArrayType n) { return null; }

    @Override
    public Void visit(BooleanType n) { return null; }

    @Override
    public Void visit(IntegerType n) { return null; }

    @Override
    public Void visit(IdentifierType n) { return null; }

    @Override
    public Void visit(Block n) {
        for (int i = 0; i < n.sl.size(); i++) {
            n.sl.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Void visit(If n) {
        n.e.accept(this);
        n.s1.accept(this);
        n.s2.accept(this);
        return null;
    }

    @Override
    public Void visit(While n) {
        n.e.accept(this);
        n.s.accept(this);
        return null;
    }

    @Override
    public Void visit(Print n) {
        n.e.accept(this);
        return null;
    }

    @Override
    public Void visit(Assign n) {
        n.i.accept(this);
        n.e.accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayAssign n) {
        n.i.accept(this);
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(And n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(LessThan n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(Plus n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(Minus n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(Times n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayLookup n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Void visit(ArrayLength n) {
        n.e.accept(this);
        return null;
    }

    @Override
    public Void visit(Call n) {
        n.e.accept(this);
        n.i.accept(this);
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IntegerLiteral n) {
        return null;
    }

    @Override
    public Void visit(True n) {
        return null;
    }

    @Override
    public Void visit(False n) {
        return null;
    }

    @Override
    public Void visit(IdentifierExp n) {
        return null;
    }

    @Override
    public Void visit(This n) {
        return null;
    }

    @Override
    public Void visit(NewArray n) {
        n.e.accept(this);
        return null;
    }

    @Override
    public Void visit(NewObject n) {
        return null;
    }

    @Override
    public Void visit(Not n) {
        n.e.accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier n) {
        return null;
    }
}
