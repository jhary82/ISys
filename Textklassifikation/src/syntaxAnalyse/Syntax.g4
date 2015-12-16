grammar Syntax;

stat: symbol*				#symbolStat;				

symbol: DOT					#dotStat
	| KOM					#komStat
	| AUS					#ausStat
	| BRACK					#brackStat
	| RBRACK				#rbrackStat
	| QUES					#quesStat
	| CITE					#citeStat
	| NUMBER				#numberStat
	;

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
LETTER: [a-zA-Z������] -> skip;
fragment DIGIT: [0-9];
