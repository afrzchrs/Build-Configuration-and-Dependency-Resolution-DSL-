// Generated from grammar/BuildDSL.g4 by ANTLR 4.13.2
package dsl.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BuildDSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, ID=22, STRING=23, WS=24;
	public static final int
		RULE_project = 0, RULE_decl = 1, RULE_taskDecl = 2, RULE_taskBody = 3, 
		RULE_command = 4, RULE_taskCall = 5, RULE_ifDecl = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"project", "decl", "taskDecl", "taskBody", "command", "taskCall", "ifDecl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROJECT'", "'FROM'", "'{'", "'}'", "'DEPEND'", "'VERSION'", "'TASK'", 
			"':'", "'END'", "'RUN'", "'ECHO'", "'MKDIR'", "'COPY'", "'TO'", "'DELETE'", 
			"'ORGANIZE'", "'FIX_DEPENDENCIES'", "'DO'", "'IF'", "'ENV'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "ID", "STRING", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BuildDSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BuildDSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProjectContext extends ParserRuleContext {
		public Token name;
		public Token sourcePath;
		public TerminalNode EOF() { return getToken(BuildDSLParser.EOF, 0); }
		public List<TerminalNode> STRING() { return getTokens(BuildDSLParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(BuildDSLParser.STRING, i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TaskDeclContext> taskDecl() {
			return getRuleContexts(TaskDeclContext.class);
		}
		public TaskDeclContext taskDecl(int i) {
			return getRuleContext(TaskDeclContext.class,i);
		}
		public List<IfDeclContext> ifDecl() {
			return getRuleContexts(IfDeclContext.class);
		}
		public IfDeclContext ifDecl(int i) {
			return getRuleContext(IfDeclContext.class,i);
		}
		public ProjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_project; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitProject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectContext project() throws RecognitionException {
		ProjectContext _localctx = new ProjectContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_project);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(T__0);
			setState(15);
			((ProjectContext)_localctx).name = match(STRING);
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(16);
				match(T__1);
				setState(17);
				((ProjectContext)_localctx).sourcePath = match(STRING);
				}
			}

			setState(20);
			match(T__2);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 524448L) != 0)) {
				{
				setState(24);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(21);
					decl();
					}
					break;
				case T__6:
					{
					setState(22);
					taskDecl();
					}
					break;
				case T__18:
					{
					setState(23);
					ifDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(T__3);
			setState(30);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(BuildDSLParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(BuildDSLParser.STRING, i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__4);
			setState(33);
			match(STRING);
			setState(34);
			match(T__5);
			setState(35);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TaskDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BuildDSLParser.ID, 0); }
		public TaskBodyContext taskBody() {
			return getRuleContext(TaskBodyContext.class,0);
		}
		public TaskDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitTaskDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskDeclContext taskDecl() throws RecognitionException {
		TaskDeclContext _localctx = new TaskDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_taskDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__6);
			setState(38);
			match(ID);
			setState(39);
			match(T__7);
			setState(40);
			taskBody();
			setState(41);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TaskBodyContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<TaskCallContext> taskCall() {
			return getRuleContexts(TaskCallContext.class);
		}
		public TaskCallContext taskCall(int i) {
			return getRuleContext(TaskCallContext.class,i);
		}
		public TaskBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitTaskBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskBodyContext taskBody() throws RecognitionException {
		TaskBodyContext _localctx = new TaskBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_taskBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 506880L) != 0)) {
				{
				setState(45);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__14:
				case T__15:
				case T__16:
					{
					setState(43);
					command();
					}
					break;
				case T__17:
					{
					setState(44);
					taskCall();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrganizeCmdContext extends CommandContext {
		public OrganizeCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitOrganizeCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CopyCmdContext extends CommandContext {
		public List<TerminalNode> STRING() { return getTokens(BuildDSLParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(BuildDSLParser.STRING, i);
		}
		public CopyCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitCopyCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FixDepCmdContext extends CommandContext {
		public FixDepCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitFixDepCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MkdirCmdContext extends CommandContext {
		public TerminalNode STRING() { return getToken(BuildDSLParser.STRING, 0); }
		public MkdirCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitMkdirCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RunCmdContext extends CommandContext {
		public TerminalNode STRING() { return getToken(BuildDSLParser.STRING, 0); }
		public RunCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitRunCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EchoCmdContext extends CommandContext {
		public TerminalNode STRING() { return getToken(BuildDSLParser.STRING, 0); }
		public EchoCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitEchoCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeleteCmdContext extends CommandContext {
		public TerminalNode STRING() { return getToken(BuildDSLParser.STRING, 0); }
		public DeleteCmdContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitDeleteCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_command);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new RunCmdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__9);
				setState(51);
				match(STRING);
				}
				break;
			case T__10:
				_localctx = new EchoCmdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__10);
				setState(53);
				match(STRING);
				}
				break;
			case T__11:
				_localctx = new MkdirCmdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				match(T__11);
				setState(55);
				match(STRING);
				}
				break;
			case T__12:
				_localctx = new CopyCmdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				match(T__12);
				setState(57);
				match(STRING);
				setState(58);
				match(T__13);
				setState(59);
				match(STRING);
				}
				break;
			case T__14:
				_localctx = new DeleteCmdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(T__14);
				setState(61);
				match(STRING);
				}
				break;
			case T__15:
				_localctx = new OrganizeCmdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				match(T__15);
				}
				break;
			case T__16:
				_localctx = new FixDepCmdContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(63);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TaskCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BuildDSLParser.ID, 0); }
		public TaskCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitTaskCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskCallContext taskCall() throws RecognitionException {
		TaskCallContext _localctx = new TaskCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_taskCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__17);
			setState(67);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfDeclContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BuildDSLParser.STRING, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TaskDeclContext> taskDecl() {
			return getRuleContexts(TaskDeclContext.class);
		}
		public TaskDeclContext taskDecl(int i) {
			return getRuleContext(TaskDeclContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<TaskCallContext> taskCall() {
			return getRuleContexts(TaskCallContext.class);
		}
		public TaskCallContext taskCall(int i) {
			return getRuleContext(TaskCallContext.class,i);
		}
		public IfDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BuildDSLVisitor ) return ((BuildDSLVisitor<? extends T>)visitor).visitIfDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDeclContext ifDecl() throws RecognitionException {
		IfDeclContext _localctx = new IfDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__18);
			setState(70);
			match(T__19);
			setState(71);
			match(T__20);
			setState(72);
			match(STRING);
			setState(73);
			match(T__7);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 507040L) != 0)) {
				{
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(74);
					decl();
					}
					break;
				case T__6:
					{
					setState(75);
					taskDecl();
					}
					break;
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__14:
				case T__15:
				case T__16:
					{
					setState(76);
					command();
					}
					break;
				case T__17:
					{
					setState(77);
					taskCall();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018V\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\u0013\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u0019\b\u0000\n\u0000\f\u0000\u001c\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003.\b\u0003"+
		"\n\u0003\f\u00031\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006O\b\u0006\n\u0006\f\u0006R\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0000"+
		"^\u0000\u000e\u0001\u0000\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004"+
		"%\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b@\u0001\u0000"+
		"\u0000\u0000\nB\u0001\u0000\u0000\u0000\fE\u0001\u0000\u0000\u0000\u000e"+
		"\u000f\u0005\u0001\u0000\u0000\u000f\u0012\u0005\u0017\u0000\u0000\u0010"+
		"\u0011\u0005\u0002\u0000\u0000\u0011\u0013\u0005\u0017\u0000\u0000\u0012"+
		"\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0001\u0000\u0000\u0000\u0014\u001a\u0005\u0003\u0000\u0000\u0015"+
		"\u0019\u0003\u0002\u0001\u0000\u0016\u0019\u0003\u0004\u0002\u0000\u0017"+
		"\u0019\u0003\f\u0006\u0000\u0018\u0015\u0001\u0000\u0000\u0000\u0018\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001c"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u001a"+
		"\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0004\u0000\u0000\u001e\u001f"+
		"\u0005\u0000\u0000\u0001\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u0005"+
		"\u0000\u0000!\"\u0005\u0017\u0000\u0000\"#\u0005\u0006\u0000\u0000#$\u0005"+
		"\u0017\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0005\u0007\u0000"+
		"\u0000&\'\u0005\u0016\u0000\u0000\'(\u0005\b\u0000\u0000()\u0003\u0006"+
		"\u0003\u0000)*\u0005\t\u0000\u0000*\u0005\u0001\u0000\u0000\u0000+.\u0003"+
		"\b\u0004\u0000,.\u0003\n\u0005\u0000-+\u0001\u0000\u0000\u0000-,\u0001"+
		"\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u00000\u0007\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000023\u0005\n\u0000\u00003A\u0005\u0017\u0000\u000045\u0005\u000b"+
		"\u0000\u00005A\u0005\u0017\u0000\u000067\u0005\f\u0000\u00007A\u0005\u0017"+
		"\u0000\u000089\u0005\r\u0000\u00009:\u0005\u0017\u0000\u0000:;\u0005\u000e"+
		"\u0000\u0000;A\u0005\u0017\u0000\u0000<=\u0005\u000f\u0000\u0000=A\u0005"+
		"\u0017\u0000\u0000>A\u0005\u0010\u0000\u0000?A\u0005\u0011\u0000\u0000"+
		"@2\u0001\u0000\u0000\u0000@4\u0001\u0000\u0000\u0000@6\u0001\u0000\u0000"+
		"\u0000@8\u0001\u0000\u0000\u0000@<\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000A\t\u0001\u0000\u0000\u0000BC\u0005"+
		"\u0012\u0000\u0000CD\u0005\u0016\u0000\u0000D\u000b\u0001\u0000\u0000"+
		"\u0000EF\u0005\u0013\u0000\u0000FG\u0005\u0014\u0000\u0000GH\u0005\u0015"+
		"\u0000\u0000HI\u0005\u0017\u0000\u0000IP\u0005\b\u0000\u0000JO\u0003\u0002"+
		"\u0001\u0000KO\u0003\u0004\u0002\u0000LO\u0003\b\u0004\u0000MO\u0003\n"+
		"\u0005\u0000NJ\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000ST\u0005\t\u0000\u0000T\r\u0001\u0000"+
		"\u0000\u0000\b\u0012\u0018\u001a-/@NP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}