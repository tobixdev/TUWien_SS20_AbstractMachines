grammar Ringelnatter;

@parser::members {

}

/*
* Parser Rules
*/

ringelnatter: (function | NEWLINE)* EOF;

function: 'fn' IDENTIFIER '(' IDENTIFIER? (',' IDENTIFIER)* '):' NEWLINE suite;

suite: (stmnt NEWLINE)+ ';';

stmnt: 'let' IDENTIFIER '=' expression |
       'ret' expression;

expression: logical_term;
logical_term: logical_factor (op=('&&' | '||') logical_factor)*;
logical_factor: arithmetic (op=('==' | '!=' | '>' | '<' | '>=' | '<=') arithmetic)*;
arithmetic: term (op=('+' | '-') term)*;
term: factor (op=('*' | '/' | '%') factor)*;
factor: op='!' factor |
        factor op='is' typename |
        NUMERIC_LITERAL |
        var=IDENTIFIER |
        '(' expression ')' |
        target=IDENTIFIER '(' expression? (',' expression)* ')';

typename: 'number' | 'list';
/*
* Lexer Rules. Thanks to https://github.com/antlr/grammars-v4/blob/master/python/python3/Python3.g4 for indent handling.
*/

LINE_COMMENT : '#' ~[\r\n|EOF]* -> skip;

fragment LETTER : [A-Z] | [a-z] | '_';
fragment DIGIT : [0-9];
fragment TAB : '\t';

IDENTIFIER : LETTER (LETTER | DIGIT)*;
NUMERIC_LITERAL : DIGIT+;
WS: SPACES -> skip;

NEWLINE : ( '\r'? '\n');

fragment SPACES: [ \t]+;