# Übergabeparameter
# Aufbau: Anzahl an einzulesende Dateien, Datei1, Datei2, ...
args <- commandArgs(TRUE)

# Auswertungsfunktion
evaluate <- function(m) {
	hist( m$DOT, main="Anzahl Punkte" )
	hist( m$KOM, main="Anzahl Kommata")
	hist( m$AUS, main="Anzahl Ausrufezeichen" )
	hist( m$QUES, main="Anzahl Fragezeichen")
	hist( m$CITE, main="Anzahl Zitate" )
	hist( m$WORD, main="Anzahl der Wörter" )
	hist( m$Satzlaenge, main="Satzlängen" )
	hist( m$Vergangenheit, main="Vergangenheitsendungen" )
	hist( m$NUMBERwithDOT, main="Zahlen mit Punkten enthalten" )
	hist( m$NL, main="Anzahl von nl" )
	hist( m$NUMBERfour, main="vierstellige Zahlen(Jahreszahlen)" )
	hist( m$NUMBERrest, main="restliche Zahlen" )
}

# lade alle Dateien ein
x <- 1
for(i in 1: args[1] ) {	
	x <- x + 1
	str <- args[x]
	value <- read.csv2(str, header=TRUE)
	evaluate(value)
}



