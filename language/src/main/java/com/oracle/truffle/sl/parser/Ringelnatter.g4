grammar Ringelnatter;

tokens { INDENT, DEDENT }

@parser::members {

}

@lexer::members {
  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  // The stack that keeps track of the indentation level.
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  // The amount of opened braces, brackets and parenthesis.
  private int opened = 0;
  // The most recently produced token.
  private Token lastToken = null;
  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }

  @Override
  public Token nextToken() {
    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      // Remove any trailing EOF tokens from our buffer.
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }

      // First emit an extra line break that serves as the end of the statement.
      this.emit(commonToken(RingelnatterParser.NEWLINE, "\n"));

      // Now emit as much DEDENT tokens as needed.
      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }

      // Put the EOF back on the token stream.
      this.emit(commonToken(RingelnatterParser.EOF, "<EOF>"));
    }

    Token next = super.nextToken();

    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      // Keep track of the last token on the default channel.
      this.lastToken = next;
    }

    return tokens.isEmpty() ? next : tokens.poll();
  }

  private Token createDedent() {
    CommonToken dedent = commonToken(RingelnatterParser.DEDENT, "");
    dedent.setLine(this.lastToken.getLine());
    return dedent;
  }

  private CommonToken commonToken(int type, String text) {
    int stop = this.getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
  }

  static int getIndentationCount(String spaces) {
    return spaces.length() / 2;
  }

  boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}
/*
* Parser Rules
*/

ringelnatter: (function | NEWLINE)* EOF;

function: 'fn' IDENTIFIER '(' IDENTIFIER? (',' IDENTIFIER)* '):' NEWLINE suite;

suite: INDENT (stmnt)+ DEDENT;

stmnt: var=IDENTIFIER '=' expression NEWLINE |
       'let' var=IDENTIFIER '=' expression NEWLINE |
       'ret' expression NEWLINE |
       'if' expression ':' NEWLINE suite |
       'while' expression ':' NEWLINE suite;

expression:
    logical_term |
    factor ('.' factor)+ |
    '[' expression? ( ',' expression)* ']';
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

IDENTIFIER : LETTER (LETTER | DIGIT)*;
NUMERIC_LITERAL : DIGIT+;
WS: SPACES -> skip;

NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' | '\f' ) SPACES?
   )
   {
     String newLine = getText().replaceAll("[^\r\n\f]+", "");
     String spaces = getText().replaceAll("[\r\n\f]+", "");

     // Strip newlines inside open clauses except if we are near EOF. We keep NEWLINEs near EOF to
     // satisfy the final newline needed by the single_put rule used by the REPL.
     int next = _input.LA(1);
     int nextnext = _input.LA(2);
     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
       // If we're inside a list or on a blank line, ignore all indents,
       // dedents and line breaks.
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         // skip indents of the same size as the present indent-size
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(RingelnatterParser.INDENT, spaces));
       }
       else {
         // Possibly emit more than 1 DEDENT token.
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
 ;

fragment SPACES: [ ]+;