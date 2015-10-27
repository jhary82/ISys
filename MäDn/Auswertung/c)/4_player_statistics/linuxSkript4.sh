#!/bin/bash

cd .. 
java -cp ludo.jar:commons-cli-1.2.jar:ludo-new.jar ludo.LudoCli -m 10000 -p . -r TakeFirstBeatTokenStrategy -b  TakeRandomActionStrategy -g  TakeRandomActionStrategy -o  TakeRandomActionStrategy

java -cp ludo.jar:commons-cli-1.2.jar:ludo-new.jar ludo.LudoCli -m 10000 -p . -r TFBTandKAF -b  TakeRandomActionStrategy -g  TakeRandomActionStrategy -o  TakeRandomActionStrategy

java -cp ludo.jar:commons-cli-1.2.jar:ludo-new.jar ludo.LudoCli -m 10000 -p . -r KillAndFleeStrategy -b  TakeRandomActionStrategy -g  TakeRandomActionStrategy -o  TakeRandomActionStrategy 


