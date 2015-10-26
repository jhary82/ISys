
setwd("/home/skrause/git/ISys/MäDn/ext/4_player_statistics")
#Einlesen der csv.Datei
m <- read.csv2("/home/skrause/git/ISys/MäDn/ext/4_player_statistics/TFBTandKAF.csv", header=TRUE)

#Gewinn-Quote
won <- length ( m$isWon[ m$isWon == 1 ] )
length <- length( m$isWon )
won / lengthwon <- length

#Aufsplitten nach m1 und m0
m0 <- m[ m$isWon == 0 ]
m1 <- m[ m$isWon == 1 ]

m

