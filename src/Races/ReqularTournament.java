/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Races;

import Animals.Animal;
import Animals.AnimalThread;
import Graphics.RaceDetails;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The reqular tournament class.
 */
public class ReqularTournament extends Tournament {

    /**
     * constructor
     * @param animals Animals
     * @param distance total distance
     * @param p the race details panel
     */
    public ReqularTournament(Animal[][] animals, int distance, RaceDetails p) {
        super(animals,distance,p);
    }

    @Override
    protected void setup(Animal[][] animals) {
        System.out.println("Setting Regular");
        int numberOfGroups=animals.length;
        AtomicBoolean startFlag=new AtomicBoolean();
        AtomicBoolean[] finishFlags=new AtomicBoolean[numberOfGroups];
        Referee[] referees=new Referee[numberOfGroups];
        Scores scores=new Scores();
        AnimalThread[] animalThreads=new AnimalThread[numberOfGroups];
        for(int i=0;i<numberOfGroups;i++){
            finishFlags[i]=new AtomicBoolean();
            referees[i]=new Referee(finishFlags[i],animals[i][0].getName(),scores);
            animalThreads[i]=new AnimalThread(animals[i][0],raceDistance,startFlag,finishFlags[i]);
            new Thread(referees[i]).start();
            new Thread(animalThreads[i]).start();
        }
        thread=new TournamentThread(scores,startFlag,numberOfGroups,panel);
    }
}
