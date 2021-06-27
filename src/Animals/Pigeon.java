/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Pigeon extends AirAnimal {
    private String family;
    /**
     * Instantiates a new Pigeon.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the speed
     * @param md   the medals
     * @param ws    the wings span
     * @param fm   the family
     */
    public Pigeon(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, double ws, String fm,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, ws,maxEnergy,energyPerMeter);
        this.family=fm;
        loadImages("pigeon");
    }
    /**
     * default constructor
     */
    public Pigeon(){
        super();
        this.family="";
    }
    @Override
    protected String classSound() {
        return "Arr-rar-rar-rar-raah";
    }

    @Override
    public String toString() {
        return super.toString()+" Pigeon: family="+this.family;
    }
    @Override
    public String retType() {
        return "Pigeon";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 1;
    }
}
