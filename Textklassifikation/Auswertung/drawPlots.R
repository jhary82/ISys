# Übergabeparameter
# Aufbau: Anzahl an einzulesende Dateien, Datei1, Datei2, ...
args <- commandArgs(TRUE)

# Auswertungsfunktion
evaluate <- function(m, str) {
	hist( m$DOT, main=paste(str, "- Anzahl Punkte") )
	hist( m$COMMA, main=paste(str, "- Anzahl Kommata") )
	hist( m$QUESTION, main=paste(str, "- Anzahl ! und ?"))
	hist( m$CITE, main=paste(str, "- Anzahl Zitate" ))
	hist( m$SENTENCE_LENGTH_AVG, main=paste(str, "- durchschnittliche Satzlängen"  ))
	hist( m$SENTENCE_LENGTH_MAX, main=paste(str, "- maximale Satzlänge"  ))	
	hist( m$NUMBER_WITH_DOT, main=paste(str, "- Zahlen mit Punkten enthalten" ))
	hist( m$NL, main=paste(str, "- Anzahl von nl" ))
	hist( m$NUMBER_FOUR, main=paste(str, "- vierstellige Zahlen(Jahreszahlen))" ))
	hist( m$NUMBER_REST, main=paste(str, "- restliche Zahlen" ))
	hist( m$BRACK, main=paste(str, "- Anzahl an Klammern"))
	hist( m$SUB_SENTENCES, main=paste(str, "- Anzahl an Haupt-,Nebensätzen"))
	hist( m$PAST, main=paste(str, "- Anzahl an Vergangenheitsformen"))
	hist( m$NOUN, main=paste(str, "- Anzahl an Nomen"))	
	hist( m$WORD_LENGTH_3, main=paste(str, "- Wörter der Länge 3"))			
	hist( m$WORD_LENGTH_4, main=paste(str, "- Wörter der Länge 4"))			
	hist( m$WORD_LENGTH_5, main=paste(str, "- Wörter der Länge 5"))			
	hist( m$WORD_LENGTH_6, main=paste(str, "- Wörter der Länge 6"))			
	hist( m$WORD_LENGTH_7, main=paste(str, "- Wörter der Länge 7"))			
	hist( m$WORD_LENGTH_8, main=paste(str, "- Wörter der Länge 8 oder mehr"))			
	hist( m$NOUN_LENGTH_3, main=paste(str, "- Nomen der Länge 3"))			
	hist( m$NOUN_LENGTH_4, main=paste(str, "- Nomen der Länge 4"))			
	hist( m$NOUN_LENGTH_5, main=paste(str, "- Nomen der Länge 5"))			
	hist( m$NOUN_LENGTH_6, main=paste(str, "- Nomen der Länge 6"))			
	hist( m$NOUN_LENGTH_7, main=paste(str, "- Nomen der Länge 7"))			
	hist( m$NOUN_LENGTH_8, main=paste(str, "- Nomen der Länge 8 oder mehr"))	
}

# lade alle Dateien ein
x <- 1
for(i in 1: args[1] ) {	
	x <- x + 1
	str <- args[x]
	value <- read.csv2(str, header=TRUE)
	evaluate(value, str)
}



