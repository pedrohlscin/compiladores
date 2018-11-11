package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ast.*;
import br.ufpe.cin.if688.minijava.symboltable.Class;
import br.ufpe.cin.if688.minijava.symboltable.Method;
import br.ufpe.cin.if688.minijava.symboltable.SymbolTable;
import br.ufpe.cin.if688.minijava.symboltable.Variable;

public class TypeCheckVisitor implements IVisitor<Type> {
    private SymbolTable symbolTable;
    private Class currClass;
    private Method currMethod;
    private Error err;

    public TypeCheckVisitor(SymbolTable st) {
        err = new Error();
        symbolTable = st;

    }


    public Type visit(Program n) {

        n.m.accept(this);
        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
        }

        return null;
    }

    public Type visit(MainClass n) {

        currClass = symbolTable.getClass(n.i1.s);
        currMethod = symbolTable.getMethod("main", currClass.getId());

        n.i1.accept(this);
        n.i2.accept(this);
        n.s.accept(this);
        currClass = null;
        currMethod = null;
        return null;
    }

    public Type visit(ClassDeclSimple n) {

        currClass = symbolTable.getClass(n.i.s);

        n.i.accept(this);
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }

        currClass = null;
        return null;
    }


    public Type visit(ClassDeclExtends n) {

        currClass = symbolTable.getClass(n.i.s);
        n.i.accept(this);
        n.j.accept(this);
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }

        currClass = null;
        return null;
    }

    public Type visit(VarDecl n) {

        n.i.accept(this);
        return n.t.accept(this);
    }

    public Type visit(MethodDecl n) {

        currMethod = symbolTable.getMethod(n.i.s, currClass.getId());

        Type declaredType = n.t.accept(this);

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
        Type returnedType = n.e.accept(this);

        if(!assertTypesAreEqual(returnedType, declaredType)) {
            System.out.println("In method: " + currMethod.getId());
            err.cannotConvert(declaredType, returnedType);
            System.exit(0);
        }
        currMethod = null;
        return declaredType;
    }

    public Type visit(Formal n) {
        n.i.accept(this);
        return n.t.accept(this);
    }

    public Type visit(IntArrayType n) {
        return n;
    }

    public Type visit(BooleanType n) {
        return n;
    }

    public Type visit(IntegerType n) {
        return n;
    }

    // String s;
    public Type visit(IdentifierType n) {
        return n;
    }

    // StatementList sl;
    public Type visit(Block n) {
        for (int i = 0; i < n.sl.size(); i++) {
            n.sl.elementAt(i).accept(this);
        }
        return null;
    }

    public Type visit(If n) {
        Type statement1Type = n.s1.accept(this);
        Type statement2Type = n.s2.accept(this);
        Type expressionType = n.e.accept(this);

        if(!this.symbolTable.compareTypes(expressionType, new BooleanType())) {
            err.notABoolean(expressionType);
            System.exit(0);
            return null;
        }

        return null;
    }

    public Type visit(While n) {
        Type expressionType = n.e.accept(this);

        if(!this.symbolTable.compareTypes(expressionType, new BooleanType())) {
            err.notABoolean(expressionType);
            System.exit(0);
            return null;
        }
        n.s.accept(this);
        return null;
    }

    public Type visit(Print n) {
        n.e.accept(this);
        return null;
    }

    public Type visit(Assign n) {
        Type typeDeclared = symbolTable.getVarType(currMethod, currClass, n.i.s);

        Type typeUsed = n.e.accept(this);

        if(!(assertTypesAreEqual(typeDeclared, typeUsed))) {
            System.out.println("In variable : " + n.i.s);
            err.cannotConvert(typeDeclared, typeUsed);
            System.exit(0);
        }
        n.i.accept(this);
        return null;
    }

    public Type visit(ArrayAssign n) {
        Type indexAcessor = n.e2.accept(this);

        if(!(indexAcessor instanceof IntegerType )) {
            err.indexAcessorNotInt(indexAcessor);
            return null;
        }

        Type variableDeclaredType = symbolTable.getVarType(currMethod, currClass, n.i.s);
        Type variableBeingUsedType = n.i.accept(this);

        if(!(assertTypesAreEqual(variableDeclaredType, variableBeingUsedType))) {
            System.out.println("In array : " + n.i.s);
            err.cannotConvert(variableDeclaredType, variableBeingUsedType);
            return null;
        }

        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    public Type visit(And n) {
        Type typeLeft = n.e1.accept(this);
        Type typeRight = n.e2.accept(this);
        Type bool = new BooleanType();
        String op = "AND";
        if(!assertTypesAreEqual(typeLeft, bool) && assertTypesAreEqual(typeRight, bool)) {
            err.badOperands(typeLeft, typeRight, op);
        }
        return new BooleanType();
    }

    public Type visit(LessThan n) {
        Type typeLeft = n.e1.accept(this);
        Type typeRight = n.e2.accept(this);
        Type integer = new IntegerType();
        String op = "Less than ( < )";
        if(!assertTypesAreEqual(typeLeft, integer) && assertTypesAreEqual(typeRight, integer)) {
            err.badOperands(typeLeft, typeRight, op);
        }
        return new BooleanType();
    }

    public Type visit(Plus n) {
        Type typeLeft = n.e1.accept(this);
        Type typeRight = n.e2.accept(this);
        Type integer = new IntegerType();
        String op = "Plus";
        if(!assertTypesAreEqual(typeLeft, integer) && assertTypesAreEqual(typeRight, integer)) {
            err.badOperands(typeLeft, typeRight, op);
        }
        return new IntegerType();
    }

    public Type visit(Minus n) {
        Type typeLeft = n.e1.accept(this);
        Type typeRight = n.e2.accept(this);
        Type integer = new IntegerType();
        String op = "Minus";
        if(!assertTypesAreEqual(typeLeft, integer) && assertTypesAreEqual(typeRight, integer)) {
            err.badOperands(typeLeft, typeRight, op);
        }
        return new IntegerType();
    }

    public Type visit(Times n) {
        Type typeLeft = n.e1.accept(this);
        Type typeRight = n.e2.accept(this);
        Type integer = new IntegerType();
        String op = "Times";
        if(!assertTypesAreEqual(typeLeft, integer) && assertTypesAreEqual(typeRight, integer)) {
            err.badOperands(typeLeft, typeRight, op);
        }
        return new IntegerType();
    }

    public Type visit(ArrayLookup n) {
        Type type1 = n.e1.accept(this);
        Type type2 = n.e2.accept(this);
        if(!(assertTypesAreEqual(type1, new IntArrayType()))) {
            err.cannotConvert(type1, new IntArrayType());
            System.exit(0);
        }
        if(!(assertTypesAreEqual(type2, new IntegerType()))) {
            err.cannotConvert(type2, new IntegerType());
            System.exit(0);
        }
        return new IntegerType();
    }

    public Type visit(ArrayLength n) {
        Type type = n.e.accept(this);
        if(!(assertTypesAreEqual(type, new IntArrayType()))) {
            err.cannotConvert(type, new IntArrayType());
            System.exit(0);
        }
        return new IntegerType();
    }

    public Type visit(Call n) {
        Type returnType = null;

        Type check = n.e.accept(this);
        if(n.e instanceof This) {
            returnType = currClass.getMethod(n.i.s).type();
        }
        else if(check instanceof IdentifierType) {
            Class calledClass = this.symbolTable.getClass(((IdentifierType) check).s);
            Method calledMethod = this.symbolTable.getMethod(n.i.toString(), calledClass.getId());
            Class currentClass = this.currClass;
            this.currClass = calledClass;

            int i;
            for ( i = 0; i < n.el.size(); i++) {
                Type parametersTypes = n.el.elementAt(i).accept(this);

                Variable parametersDeclared = calledMethod.getParamAt(i);
                if(parametersDeclared == null) {
                    err.parametersDifferInLength(calledMethod);
                    System.exit(0);
                    return null;
                }
                Type parametersDeclaredTypes = calledMethod.getParamAt(i).type();
                if(!(assertTypesAreEqual(parametersTypes, parametersDeclaredTypes))) {
                    err.cannotConvert(parametersDeclaredTypes, parametersTypes);
                    System.exit(0);
                    return null;
                }
            }
            if(calledMethod.getParamAt(i) != null) {
                err.parametersDifferInLength(calledMethod);
                System.exit(0);
                return null;
            }
            Type idType = n.i.accept(this);
            currClass = currentClass;
            return idType;
        }

        return returnType;
    }

    public Type visit(IntegerLiteral n) {
        return new IntegerType();
    }

    public Type visit(True n) {
        return new BooleanType();
    }

    public Type visit(False n) {
        return new BooleanType();
    }

    public Type visit(IdentifierExp n) {
        Type t = symbolTable.getVarType(this.currMethod, this.currClass, n.s);
        return t;
    }

    public Type visit(This n) {
        return currClass.type();
    }

    public Type visit(NewArray n) {
        Type indexType = n.e.accept(this);

        if(!(assertTypesAreEqual(indexType, new IntegerType()))) {
            err.cannotConvert(indexType, new IntegerType());
            System.exit(0);
        }
        return new IntArrayType();
    }

    public Type visit(NewObject n) {
        return n.i.accept(this);
    }

    public Type visit(Not n) {
        n.e.accept(this);
        return null;
    }

    public Type visit(Identifier n) {

        if(currClass.containsVar(n.s)) {
            return symbolTable.getVarType(currMethod, currClass, n.s);
        }
        if(currClass.containsMethod(n.s)) {
            return symbolTable.getMethodType(n.s, currClass.getId());
        }
        if(currMethod != null && currMethod.containsVar(n.s)) {
            return currMethod.getVar(n.s).type();
        }
        if(currMethod != null && currMethod.containsParam(n.s)) {
            return currMethod.getParam(n.s).type();
        }
        else {
            Class c = this.symbolTable.getClass(n.s);
            if(c == null) {
                err.cannotFindVariable(n);
                System.exit(0);
            }
            return c.type();
        }

    }

    public boolean assertTypesAreEqual(Type t1, Type t2) {
        return symbolTable.compareTypes(t1, t2);
    }
}
