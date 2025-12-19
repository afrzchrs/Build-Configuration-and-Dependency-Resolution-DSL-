// Generated from d:/PLP/Build Configuration & Dependency Resolution DSL - automated executor/grammar/BuildDSL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BuildDSLParser}.
 */
public interface BuildDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#project}.
	 * @param ctx the parse tree
	 */
	void enterProject(BuildDSLParser.ProjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#project}.
	 * @param ctx the parse tree
	 */
	void exitProject(BuildDSLParser.ProjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(BuildDSLParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(BuildDSLParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#taskDecl}.
	 * @param ctx the parse tree
	 */
	void enterTaskDecl(BuildDSLParser.TaskDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#taskDecl}.
	 * @param ctx the parse tree
	 */
	void exitTaskDecl(BuildDSLParser.TaskDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#taskBody}.
	 * @param ctx the parse tree
	 */
	void enterTaskBody(BuildDSLParser.TaskBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#taskBody}.
	 * @param ctx the parse tree
	 */
	void exitTaskBody(BuildDSLParser.TaskBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(BuildDSLParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(BuildDSLParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#taskCall}.
	 * @param ctx the parse tree
	 */
	void enterTaskCall(BuildDSLParser.TaskCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#taskCall}.
	 * @param ctx the parse tree
	 */
	void exitTaskCall(BuildDSLParser.TaskCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BuildDSLParser#ifDecl}.
	 * @param ctx the parse tree
	 */
	void enterIfDecl(BuildDSLParser.IfDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BuildDSLParser#ifDecl}.
	 * @param ctx the parse tree
	 */
	void exitIfDecl(BuildDSLParser.IfDeclContext ctx);
}