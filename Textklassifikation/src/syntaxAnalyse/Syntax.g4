grammar Syntax;

stat
	: sentence*				#sentenceStat		 
	;

sentence
	: (seperatorSymbol (WORD|symbol)* seperatorSymbol)
	;
				
seperatorSymbol
 	: DOT					#dotStat
	| COMMA					#commaStat
	| EXCLAMATION			#exclamationStat
	| QUES					#quesStat
	| COLON					#colonStat
	;
	
symbol
	: BRACK					#brackStat	
	| RBRACK				#rbrackStat	
	| CITE					#citeStat
	| NUMBER DOT NUMBER 	#numberDotStat 
	| NUMBER 				#numberStat
	| WORD					#wordStat 
	| NL					#nlStat
	;
	
DOT: '.';
COMMA: ',' | ';';
EXCLAMATION: '!';
BRACK: '(';
RBRACK: '[';
COLON: ':'; 
QUES: '?';
CITE: ('>>' | '<<' | '"' | '\'' | '\u201c' | '\u201d' | '\u201e' | '\u201f'
	| '\u00bb' // �
	| '\u00ab' // �
	);
NUMBER: DIGIT+;
WORD: LETTER+;
NL: '\n';
SKIPED: ([-:)\]/;=*&���] | '\u002d' | '\u2010' | '\u2011' | '\u2012' | '\u2013' | '\u2014' | '\u2015' | '\u2026'
		| '\u00d0' // �
		| '\u00ea' // �
		| '\u00e8' // �
		| '\u00f3' // �
		| '\u00e1' // �
		| '\u2019' // �
		| '\u00ca' // �
		| '\u00e0' // �
		| '\u00f1' // �
		| '\u00ed' // �
		) -> skip;
WS: ([ \t\r]|'\u00a0' | '\u00ad') -> skip;
fragment LETTER: [a-zA-Z]|'\u00c4'|'\u00e4'|'\u00d6'|'\u00f6'|'\u00dc'|'\u00fc'|'\u00df'|'\u00E9';
fragment DIGIT: [0-9];
