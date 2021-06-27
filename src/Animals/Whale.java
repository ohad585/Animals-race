/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Whale extends WaterAnimal {
    private String foodType;
    /**
     * Instantiates a new Alligator.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the speed
     * @param md   the medals
     * @param dd   the dive depth
     * @param foodType   the type of food
     */
    public Whale(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, int dd, String foodType,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, dd,maxEnergy,energyPerMeter);
        this.foodType=foodType;
        loadImages("whale");
    }
    @Override
    protected String classSound() {
        return "Splash";
    }

    @Override
    public String toString() {
        return super.toString()+" Whale: Food type="+this.foodType;
    }
    @Override
    public String retType() {
        return "Whale";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 2;
    }
}
