#!/bin/bash

test=""
CouleurDebut="\033[31m"
CouleurFin="\033[00m"

echo -e "\033[36mCompilation..."
javac $1.java
echo -e $CouleurFin"\n\033[35mTest en cours..."$CouleurFin

VAR1=$(java $1)
VAR2="RadScorpion #1: Crrr!
SuperMutant #1: Roaarrr!
RadScorpion #2: Crrr!
Joe on duty.
Joe has been equipped with a Plasma Rifle.
Abaddon has teleported from space.
Abaddon has been equipped with a Power Fist.
Rose on duty.
Rose has been equipped with a Plasma Rifle.
Joe has entered the arena.
RadScorpion #1 has entered the arena.
Joe attacks RadScorpion #1 with a Plasma Rifle.
PIOU
RadScorpion #1: I'm too far away from Joe.
RadScorpion #1 is moving closer to Joe.
Joe attacks RadScorpion #1 with a Plasma Rifle.
PIOU
RadScorpion #1 attacks Joe.
Joe attacks RadScorpion #1 with a Plasma Rifle.
PIOU
RadScorpion #1 attacks Joe.
Abaddon has entered the arena.
Abaddon: I'm too far away from RadScorpion #1.
Abaddon is moving closer to RadScorpion #1.
RadScorpion #1: I'm too far away from Abaddon.
RadScorpion #1 is moving closer to Abaddon.
Abaddon attacks RadScorpion #1 with a Power Fist.
SBAM
SuperMutant #1 has entered the arena.
Abaddon: I'm too far away from SuperMutant #1.
Abaddon is moving closer to SuperMutant #1.
SuperMutant #1: I'm too far away from Abaddon.
SuperMutant #1 is moving closer to Abaddon.
Abaddon attacks SuperMutant #1 with a Power Fist.
SBAM
SuperMutant #1 attacks Abaddon.
Abaddon attacks SuperMutant #1 with a Power Fist.
SBAM
Abaddon attacks SuperMutant #1 with a Power Fist.
SBAM
Abaddon attacks SuperMutant #1 with a Power Fist.
SBAM
RadScorpion #2 has entered the arena.
Abaddon: I'm too far away from RadScorpion #2.
Abaddon is moving closer to RadScorpion #2.
RadScorpion #2: I'm too far away from Abaddon.
RadScorpion #2 is moving closer to Abaddon.
Abaddon attacks RadScorpion #2 with a Power Fist.
SBAM
RadScorpion #2 attacks Abaddon.
Abaddon attacks RadScorpion #2 with a Power Fist.
SBAM
The spaceMarines are victorious.
SuperMutant #2: Roaarrr!
SuperMutant #3: Roaarrr!
SuperMutant #2 has entered the arena.
Abaddon: I'm too far away from SuperMutant #2.
Abaddon is moving closer to SuperMutant #2.
SuperMutant #2: I'm too far away from Abaddon.
SuperMutant #2 is moving closer to Abaddon.
Abaddon attacks SuperMutant #2 with a Power Fist.
SBAM
SuperMutant #2 attacks Abaddon.
Abaddon attacks SuperMutant #2 with a Power Fist.
SBAM
Abaddon attacks SuperMutant #2 with a Power Fist.
SBAM
SuperMutant #2 attacks Abaddon.
Rose has entered the arena.
Rose attacks SuperMutant #2 with a Plasma Rifle.
PIOU
SuperMutant #2: I'm too far away from Rose.
SuperMutant #2 is moving closer to Rose.
Rose attacks SuperMutant #2 with a Plasma Rifle.
PIOU
Rose attacks SuperMutant #2 with a Plasma Rifle.
PIOU
Rose attacks SuperMutant #2 with a Plasma Rifle.
PIOU
SuperMutant #3 has entered the arena.
Rose attacks SuperMutant #3 with a Plasma Rifle.
PIOU
SuperMutant #3: I'm too far away from Rose.
SuperMutant #3 is moving closer to Rose.
Rose attacks SuperMutant #3 with a Plasma Rifle.
PIOU
SuperMutant #3 attacks Rose.
Rose attacks SuperMutant #3 with a Plasma Rifle.
PIOU
Rose attacks SuperMutant #3 with a Plasma Rifle.
PIOU
SuperMutant #3 attacks Rose.
The monsters are victorious."



for L in $(seq 1 ${#VAR2}); do
if [[ $(echo $VAR1 | cut -c$L) == $(echo $VAR2 | cut -c$L) ]]; then
    # echo "Niquel c'est pareil"
    test+=$CouleurFin$(echo $VAR2 | cut -c$L)
else
    test+=$CouleurDebut$(echo $VAR2 | cut -c$L)
    # echo "et non ce n'est pas bon."
fi

done

echo -e "\033[33m\nVoici les differences :"$CouleurFin
echo -e "$test$CouleurDebut\n"

echo -e $CouleurDebut"CouleurRouge = ERREUR !!!!$CouleurFin"

