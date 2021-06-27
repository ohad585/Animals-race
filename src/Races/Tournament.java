/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Races;

import Animals.Animal;
import Graphics.RaceDetails;

/**
 * the Tournament abstract class
 */
public abstract class Tournament {
    protected TournamentThread thread;
    protected int raceDistance;
    protected RaceDetails panel;
    public Tournament(Animal[][] animals,int distance,RaceDetails p){
        raceDistance=distance;
        panel=p;
        setup(animals);
    }

    /**
     * Setting up the tournament.
     * @param animals The animals in the tournament.
     */
    protected abstract void setup(Animal[][] animals);

    /**
     * Return the thread of the tournament.
     * @return Thread.
     */
    public TournamentThread getThread(){return thread;}
}
