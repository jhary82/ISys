# Übergabeparameter
# Aufbau: Anzahl an einzulesende Dateien, Datei1, Datei2, ...
args <- commandArgs(TRUE)

# Auswertungsfunktion
evaluate <- function(m) {
	hist( m$DOT, main="Anzahl Punkte" )
	hist( m$COMMA, main="Anzahl Kommata")
	hist( m$EXCLAMATION, main="Anzahl Ausrufezeichen" )
	hist( m$QUESTION, main="Anzahl Fragezeichen")
	hist( m$CITE, main="Anzahl Zitate" )
	hist( m$WORDS, main="Anzahl der Wörter" )
	hist( m$SENTENCE_LENGTH, main="Satzlängen" )
	hist( m$PAST, main="Vergangenheitsendungen" )
	hist( m$NUMBER_WITH_DOT, main="Zahlen mit Punkten enthalten" )
	hist( m$NL, main="Anzahl von nl" )
	hist( m$NUMBER_FOUR, main="vierstellige Zahlen(Jahreszahlen)" )
	hist( m$NUMBER_REST, main="restliche Zahlen" )
	hist( m$BRACK, main="Anzahl an Klammern")
}

# lade alle Dateien ein
x <- 1
for(i in 1: args[1] ) {	
	x <- x + 1
	str <- args[x]
	value <- read.csv2(str, header=TRUE)
	evaluate(value)
}



