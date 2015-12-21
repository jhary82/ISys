grammar Syntax;


stat: symbol*				#symbolStat;				

symbol
	: DOT					#dotStat
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
CITE: ('>>' | '<<' | '"' | '\'' | '\u201c' | '\u201d' | '\u201e' | '\u201f');
NUMBER: DIGIT+;
WORD: LETTER+;
NL: '\n';
SKIPED: ([-:)\]/;=*&] | '\u002d' | '\u2010' | '\u2011' | '\u2012' | '\u2013' | '\u2014' | '\u2015') -> skip;
WS: ([ \t\r]|'\u00a0' | '\u00ad') -> skip;
fragment LETTER: [a-zA-Z]|'\u00c4'|'\u00e4'|'\u00d6'|'\u00f6'|'\u00dc'|'\u00fc'|'\u00df'|'\u00E9';
fragment DIGIT: [0-9];
