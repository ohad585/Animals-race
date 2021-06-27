/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * The type Dog.
 */
public class Dog extends TerrestrialAnimals {
    private String breed;

    /**
     * Instantiates a new Dog.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the spees
     * @param md   the medals
     * @param nl   the number of legs
     * @param br   Dog breed
     */
    public Dog(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, int nl, String br,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, nl,maxEnergy,energyPerMeter);
        this.breed=br;
        animalpicname="dog";
        loadImages("dog");
    }

    /**
     * default constructor
     */
    public Dog(){
        super();
        this.breed="";
    }
    /**
     * classSound
     * @return unique class sound
     */
    protected String classSound(){
        return "Woof Woof";
    }
    @Override
    public String toString() {
        return super.toString() +
                " Dog breed=" + breed ;
    }
    @Override
    public String retType() {
        return "Dog";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 6;
    }
}
