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
	| WORD					#wordStat
	| NL					#nlStat
	;
	
DOT: '.';
KOM: ',';
AUS: '!';
BRACK: '(';
RBRACK: '[';
QUES: '?';
CITE: ('>>' | '<<' | '"' | '\'');
NUMBER: DIGIT+;
WORD: LETTER+;
NL: '\n';
SKIPED: [-:)\]/;=*&] -> skip;
WS: [ \t\r] -> skip;
fragment LETTER: [a-zA-Z]|'\u00c4'|'\u00e4'|'\u00d6'|'\u00f6'|'\u00dc'|'\u00fc'|'\u00df';
fragment DIGIT: [0-9];
