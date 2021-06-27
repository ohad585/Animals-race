/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;
import Graphics.Orientation;
import Mobility.Point;
import Olympics.Medal;

/**
 * Delegator for alligator.
 */
public class TerrestrialAligator extends TerrestrialAnimals {

    public TerrestrialAligator(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, int noLegs,int maxEnergy,int energyPerMeter){
        super(nm,gndr,we,sp,md,p1,noLegs,maxEnergy,energyPerMeter);
    }
    @Override
    protected String classSound() {
        return "Roar";
    }

    /**
     * Will only return the difference between Terrestrial animal and sea animal.
     * @return number of legs.
     */
    @Override
    public String toString() {
        return " Number of legs="+super.getNoLegs();
    }

    /**
     * @returns number of pics available.
     */
    @Override
    public int picArsenal() {
        return 0;
    }
    @Override
    public String retType() {
        return "Land Alligator";
    }
}
