/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

public class Eagle extends AirAnimal {
    private double altitude;
    static final int MAX_ALTITUDE=1000;
    /**
     * Instantiates a new Eagle.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the speed
     * @param md   the medals
     * @param ws    the wings span
     * @param alt   the altitude
     */
    public Eagle(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, double ws, double alt,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, ws,maxEnergy,energyPerMeter);
        this.setAltitude(alt);
        loadImages("eagle");
    }

    /**
     * default constructor
     */
    public Eagle(){
        super();
        this.setAltitude(0);
    }
    /**
     * sets new altitude
     * @param newalt new altitude
     * @return true if set was achieved
     */
    public Boolean setAltitude(double newalt){
        if(newalt<=Eagle.MAX_ALTITUDE){
            this.altitude=newalt;
            return true;
        }
        System.out.println("New altitude too high");
        return false;
    }
    @Override
    protected String classSound() {
        return "Clack-wack-chack";
    }

    @Override
    public String toString() {
        return super.toString()+" Eagle: altitude="+this.altitude;
    }
    @Override
    public String retType() {
        return "Eagle";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 3;
    }
}
