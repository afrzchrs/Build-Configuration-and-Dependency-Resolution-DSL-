// Generated from grammar/BuildDSL.g4 by ANTLR 4.13.2
package dsl.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BuildDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BuildDSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BuildDSLParser#project}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProject(BuildDSLParser.ProjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildDSLParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(BuildDSLParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildDSLParser#taskDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDecl(BuildDSLParser.TaskDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildDSLParser#taskBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskBody(BuildDSLParser.TaskBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RunCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunCmd(BuildDSLParser.RunCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EchoCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEchoCmd(BuildDSLParser.EchoCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MkdirCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMkdirCmd(BuildDSLParser.MkdirCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CopyCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyCmd(BuildDSLParser.CopyCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeleteCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteCmd(BuildDSLParser.DeleteCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrganizeCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrganizeCmd(BuildDSLParser.OrganizeCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FixDepCmd}
	 * labeled alternative in {@link BuildDSLParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixDepCmd(BuildDSLParser.FixDepCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildDSLParser#taskCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskCall(BuildDSLParser.TaskCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BuildDSLParser#ifDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfDecl(BuildDSLParser.IfDeclContext ctx);
}