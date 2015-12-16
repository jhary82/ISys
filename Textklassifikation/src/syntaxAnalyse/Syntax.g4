lexer grammar Syntax;


WS: [ \t\r] -> skip;
DOT: '.';
KOM: ',';
AUS: '!';
BRACK: '(';
RBRACK: '[';
QUES: '?';
CITE: ('>>' | '<<' | '"' | '\'');
NUMBER: DIGIT+;
NL: '\n';
SKIPED: [-:)\]/;=*&] -> skip;
LETTER: [a-zA-ZÄÜÖäüö] -> skip;
fragment DIGIT: [0-9];
