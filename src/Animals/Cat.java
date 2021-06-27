/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * The type Cat.
 */
public class Cat extends TerrestrialAnimals{
    private boolean castrated;
    /**
     * Instantiates a new Cat.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the speed
     * @param md   the medals
     * @param nl   the number of legs
     * @param castrated   If the cat is castrated
     */
    public Cat(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, int nl, Boolean castrated,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, nl,maxEnergy,energyPerMeter);
        this.castrated=castrated;
        animalpicname="cat";
        loadImages("cat");
    }

    /**
     * defualt constructor
     */
    public Cat(){
        super();
        this.castrated=false;
    }
    @Override
    protected String classSound() {
        return "Meow";
    }

    @Override
    public String toString() {
        return super.toString()+" Cat castrated="+this.castrated;
    }

    @Override
    public String retType() {
        return "Cat";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 2;
    }
}
