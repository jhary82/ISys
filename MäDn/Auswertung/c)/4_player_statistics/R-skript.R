#-- Übergabeparameter --
args <- commandArgs(TRUE)

#-- Hilfsfunktion --
# m ist die Gesamtmenge
evaluate <- function(m) {

	#-- Gewinn-Quote --
	won <- length ( m$isWon[ m$isWon == 1 ] )
	length <- length( m$isWon )
	wonQuote <- won / length
	cat(paste("gewonne Spiele: ",won,"\n"))
	cat(paste("Gesamtzahl der Spiele: ", length,"\n"))
	cat(paste("Gewinnquotient: ", wonQuote,"\n"))

	#-- Aufsplitten nach m1 und m0 --
	m0 <- m[ (m$isWon==0), c(2,3,5,6,7,8,9,10) ]
	m1 <- m[ (m$isWon==1), c(2,3,5,6,7,8,9,10) ]

	#-- Schlagquote --
	output( 1, "Schlagchance bei gewonnenen Spielen", m1)
	output( 1, "Schlagchance bei verlorenen Spielen", m0)

	#-- wie oft herausgekommen? --
	output( 2, "Herauskommen aus StartZone bei gewonnenen Spielen", m1)
	output( 2, "Herauskommen aus StartZone bei verlorenen Spielen", m0)

	#-- turnCount --
	output( 4, "TurnCount insgesamt", m)

	#-- Auswertung der SubStrategien --	
	cat("Substrategien:\n")
	output( 3, "keine Zugmöglichkeit bei gewonnenen Spielen", m1)
	output( 3, "keine Zugmöglichkeit bei verlorenen Spielen", m0)
	
	output( 4, "Sonderfall zurückschlagen bei gewonnenen Spielen", m1)
	output( 4, "Sonderfall zurückschlagen bei verlorenen Spielen", m0)

	output( 5, "schlage mit vorderster Figur nach vorne bei gewonnenen Spielen", m1)
	output( 5, "schlage mit vorderster Figur nach vorne bei verlorenen Spielen", m0)

	output( 6, "ziehe mit vorderster Figur bei gewonnenen Spielen", m1)
	output( 6, "ziehe mit vorderster Figur bei verlorenen Spielen", m0)
	
	output( 7, "schlage zufällig eine gegnerische Figur bei gewonnenen Spielen", m1)
	output( 7, "schlage zufällig eine gegnerische Figur bei verlorenen Spielen", m0)

	output( 8, "ziehe mit ersten gefährdeten Figur bei gewonnenen Spielen", m1)
	output( 8, "ziehe mit ersten gefährdeten Figur bei verlorenen Spielen", m0)
	
	#-- Boxplot aller Substrategien nebeneinander --
	boxplot( m1[, c(3,4,5,6,7,8)], main="bei gewonnenen Spielen" )
	boxplot( m0[, c(3,4,5,6,7,8)], main="bei verlorenen Spielen" )
	
}

#-- Hilfsfunktion --
# pos ist die auszuwertende Spalte von data
# text ist der auszugebende Text
# data sind die Datensätze, auf denen gearbeitet wird
output <- function( pos, text, data){
	cat(paste("Durchschnittlicher Anteil von ", text, mean( data[,pos] ), "\n"))
	boxplot( data[,pos], main=text )
}

#-- Lade csv-Daten ein und werte aus --
x <- 1
for(i in 1:args[1]) {
	x <- x + 1
	#-- Einlesen der csv.Datei --
	str <- args[x]
	m <- read.csv2(str, header=TRUE)

	#-- werte aus --
	evaluate(m)
}



