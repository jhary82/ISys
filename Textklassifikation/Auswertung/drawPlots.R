# Übergabeparameter
# Aufbau: Anzahl an einzulesende Dateien, Datei1, Datei2, ...
args <- commandArgs(TRUE)

# Auswertungsfunktion
evaluate <- function(m, str) {
	boxplot( m$DOT, main=paste(str, "- Anzahl Punkte") )
  boxplot( m$COMMA, main=paste(str, "- Anzahl Kommata") )
  boxplot( m$QUESTION, main=paste(str, "- Anzahl ! und ?"))
  boxplot( m$CITE, main=paste(str, "- Anzahl Zitate" ))
  boxplot( m$SENTENCE_LENGTH_AVG, main=paste(str, "- durchschnittliche Satzlängen"  ))
  boxplot( m$SENTENCE_LENGTH_MAX, main=paste(str, "- maximale Satzlänge"  ))	
  boxplot( m$NUMBER_WITH_DOT, main=paste(str, "- Zahlen mit Punkten enthalten" ))
  boxplot( m$NL, main=paste(str, "- Anzahl von nl" ))
  boxplot( m$NUMBER_FOUR, main=paste(str, "- vierstellige Zahlen(Jahreszahlen))" ))
  boxplot( m$NUMBER_REST, main=paste(str, "- restliche Zahlen" ))
  boxplot( m$BRACK, main=paste(str, "- Anzahl an Klammern"))
  boxplot( m$SUB_SENTENCES, main=paste(str, "- Anzahl an Haupt-,Nebensätzen"))
  boxplot( m$PAST, main=paste(str, "- Anzahl an Vergangenheitsformen"))
  boxplot( m$NOUN, main=paste(str, "- Anzahl an Nomen"))	
  boxplot( m$WORD_LENGTH_3, main=paste(str, "- Wörter der Länge 3"))			
  boxplot( m$WORD_LENGTH_4, main=paste(str, "- Wörter der Länge 4"))			
  boxplot( m$WORD_LENGTH_5, main=paste(str, "- Wörter der Länge 5"))			
  boxplot( m$WORD_LENGTH_6, main=paste(str, "- Wörter der Länge 6"))			
  boxplot( m$WORD_LENGTH_7, main=paste(str, "- Wörter der Länge 7"))			
  boxplot( m$WORD_LENGTH_8, main=paste(str, "- Wörter der Länge 8 oder mehr"))			
  boxplot( m$NOUN_LENGTH_3, main=paste(str, "- Nomen der Länge 3"))			
  boxplot( m$NOUN_LENGTH_4, main=paste(str, "- Nomen der Länge 4"))			
  boxplot( m$NOUN_LENGTH_5, main=paste(str, "- Nomen der Länge 5"))			
  boxplot( m$NOUN_LENGTH_6, main=paste(str, "- Nomen der Länge 6"))			
  boxplot( m$NOUN_LENGTH_7, main=paste(str, "- Nomen der Länge 7"))			
  boxplot( m$NOUN_LENGTH_8, main=paste(str, "- Nomen der Länge 8 oder mehr"))	
}

# lade alle Dateien ein
x <- 1
for(i in 1: args[1] ) {	
	x <- x + 1
	str <- args[x]
	value <- read.csv2(str, header=TRUE)
	evaluate(value, str)
}



