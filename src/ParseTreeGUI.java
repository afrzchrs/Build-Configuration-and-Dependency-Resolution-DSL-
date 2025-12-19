import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;

import dsl.antlr.*;  // package lexer + parser kamu

import java.io.FileInputStream;

public class ParseTreeGUI {
    public static void main(String[] args) throws Exception {

        // File DSL yang ingin divisualisasikan
        FileInputStream fis = new FileInputStream("build.dsl");

        // Pipeline ANTLR
        CharStream input = CharStreams.fromStream(fis);
        BuildDSLLexer lexer = new BuildDSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BuildDSLParser parser = new BuildDSLParser(tokens);

        // Ambil rule akar grammar
        ParseTree tree = parser.project();

        // Print versi teks ke terminal
        System.out.println(tree.toStringTree(parser));

        // 🔥 TAMPILKAN GUI ANTLR4 PARSE TREE
        Trees.inspect(tree, parser);
    }
}
