package br.ufpe.cin.if688.minijava.main;

import br.ufpe.cin.if688.minijava.visitor.implemented_antlr.pedroLexer;
import br.ufpe.cin.if688.minijava.visitor.implemented_antlr.pedroParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


import java.io.IOException;

public class TesteAntlr {
    public static void main(String[] args) {
        CharStream charStream = null;
        try {
            charStream = CharStreams.fromFileName("" +
                    "/home/p/github/if688.github.io/atividades/04-MiniJavaAST/src/br/ufpe/cin/if688/minijava/resources/teste_basico.txt"
            );
            pedroLexer lexer = new pedroLexer(charStream);
            CommonTokenStream cts  = new CommonTokenStream(lexer);
            pedroParser parser = new pedroParser(cts);
            parser.goal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
