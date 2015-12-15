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
WS: [ \t\r] -> skip;
WORD: LETTER -> skip;
//TEST: UMLAUTE -> skip;
TEST: '�' -> skip;

fragment DIGIT: [0-9]+;
fragment LETTER: [a-zA-Z]+;
/*fragment UMLAUTE: ('�'|'�'|'�'|'�'|'�'|'�')+;*/