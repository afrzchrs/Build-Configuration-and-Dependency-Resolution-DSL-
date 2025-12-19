package dsl.runner;

import dsl.antlr.BuildDSLLexer;
import dsl.antlr.BuildDSLParser;
import dsl.visitor.BuildVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class DSLRunner {

    public static void main(String[] args) {
        try {
            // Pastikan file build.dsl ada di root folder proyek
            CharStream input = CharStreams.fromFileName("build.dsl");

            BuildDSLLexer lexer = new BuildDSLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BuildDSLParser parser = new BuildDSLParser(tokens);

            // Mulai parsing dari rule 'project'
            BuildDSLParser.ProjectContext tree = parser.project();

            BuildVisitor visitor = new BuildVisitor();
            visitor.visit(tree);

            System.out.println("--------------------------------");
            visitor.runTask("run");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}