grammar Ringelnatter;

@parser::members {

}

@lexer::members {
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  private int opened = 0;
  private Token lastToken = null;
  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }

  @Override
  public Token nextToken() {
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }

      this.emit(commonToken(RingelnatterLexer.NEWLINE, "\n"));

      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }

      this.emit(commonToken(RingelnatterLexer.EOF, "<EOF>"));
    }

    Token next = super.nextToken();

    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
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
    int count = 0;
    for (char ch : spaces.toCharArray()) {
      switch (ch) {
        case '\t':
          count += 8 - (count % 8);
          break;
        default:
          // A normal space char.
          count++;
      }
    }

    return count;
  }

  boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}

tokens { INDENT, DEDENT }

/*
* Parser Rules
*/

ringelnatter: (function | NEWLINE)* EOF;

function: 'fn' IDENTIFIER '(' IDENTIFIER? (',' IDENTIFIER)* '):' suite;

suite: NEWLINE INDENT (stmnt NEWLINE)+ DEDENT;

stmnt: 'let' IDENTIFIER '=' expression |
       'ret' expression;

expression: logical_term;
logical_term: logical_factor (op=('&&' | '||') logical_factor)*;
logical_factor: arithmetic (op=('==' | '!=' | '>' | '<' | '>=' | '<=') arithmetic)*;
arithmetic: term (op=('+' | '-') term)*;
term: factor (op=('*' | '/' | '%') factor)*;
factor: '!' factor | NUMERIC_LITERAL | IDENTIFIER | '(' expression ')';

/*
* Lexer Rules. Thanks to https://github.com/antlr/grammars-v4/blob/master/python/python3/Python3.g4 for indent handling.
*/

LINE_COMMENT : '#' ~[\r\n|EOF]* -> skip;

fragment LETTER : [A-Z] | [a-z] | '_' | '$';
fragment DIGIT : [0-9];
fragment TAB : '\t';

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

     int next = _input.LA(1);
     int nextnext = _input.LA(2);
     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(RingelnatterParser.INDENT, spaces));
       }
       else {
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
 ;

fragment SPACES
 : [ \t]+
 ;