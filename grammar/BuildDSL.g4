grammar BuildDSL;

project
    : 'PROJECT' name=STRING ('FROM' sourcePath=STRING)? '{' (decl | taskDecl | ifDecl)* '}' EOF
    ;

decl
    : 'DEPEND' STRING 'VERSION' STRING
    ;

taskDecl
    : 'TASK' ID ':' taskBody 'END'
    ;

taskBody
    : (command | taskCall)* ;


command
    : 'RUN' STRING              # RunCmd
    | 'ECHO' STRING             # EchoCmd
    | 'MKDIR' STRING            # MkdirCmd
    | 'COPY' STRING 'TO' STRING # CopyCmd
    | 'DELETE' STRING           # DeleteCmd
    | 'ORGANIZE'                # OrganizeCmd
    | 'FIX_DEPENDENCIES'        # FixDepCmd
    ;

taskCall
    : 'DO' ID
    ;

ifDecl
    : 'IF' 'ENV' '==' STRING ':' (decl | taskDecl | command | taskCall)* 'END'
    ;

ID     : [a-zA-Z_][a-zA-Z0-9_]* ;
STRING : '"' (~["\r\n])* '"' ;
WS     : [ \t\r\n]+ -> skip ;