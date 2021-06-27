/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

/**
 * The type Alligator.
 */

public class Alligator extends WaterAnimal implements Reptile{
    private String areaOfLiving;
    //HW2
    private TerrestrialAligator tsAligator;
    /**
     * Instantiates a new Alligator.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the speed
     * @param md   the medals
     * @param dd   the dive depth
     * @param areaOfLiving   where the alligator lives
     */
    public Alligator(String nm, genderType gndr, double we, double sp, Medal[] md,Point p1, int dd, String areaOfLiving,int nl,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, dd,maxEnergy,energyPerMeter);
        this.tsAligator=new TerrestrialAligator(nm,gndr,we,sp,md,p1,nl,maxEnergy,energyPerMeter);
        this.areaOfLiving=areaOfLiving;
        loadImages("alligator");
    }
    @Override
    protected String classSound() {
        return "Roar";
    }

    @Override
    public String toString() {
        return super.toString()+" Alligator: Area of living="+this.areaOfLiving+tsAligator.toString();
    }

    @Override
    public void speedUp(int ms) {
        if(ms+this.getSpeed()>=Reptile.MAX_SPEED){
            System.out.println("Max speed reached");
            this.setSpeed(Reptile.MAX_SPEED);
        }
        else this.setSpeed(this.getSpeed()+ms);
    }


    @Override
    public String retType() {
        return "Alligator";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 3;
    }
}
