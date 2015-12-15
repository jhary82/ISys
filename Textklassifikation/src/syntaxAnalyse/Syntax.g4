lexer grammar Syntax;
DOT: '.';
KOM: ',';
AUS: '!';
BRACK: '(';
RBRACK: '[';
QUES: '?';
CITE: ('>>' | '<<' | '"');
NUMBER: DIGIT;
NL: '\n';
WS: [ \t];

fragment DIGIT: [0-9]+;