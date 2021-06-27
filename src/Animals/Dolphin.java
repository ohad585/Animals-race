/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

enum WaterTypes{
    Sea,Sweet
}
public class Dolphin extends WaterAnimal{
    private WaterTypes waterType;
    /**
     * Instantiates a new Dolphin.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the speed
     * @param md   the medals
     * @param dd   the dive depth
     * @param wt   the water type
     */
    public Dolphin(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, int dd, int wt,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, dd, maxEnergy, energyPerMeter);
        this.intToWaterType(wt);
        loadImages("dolphin");
    }

    private void intToWaterType(int x){
        if (x==1){
            this.waterType=WaterTypes.Sea;
        }
        else  this.waterType=WaterTypes.Sweet;
    }
    @Override
    protected String classSound() {
        return "Click-click";
    }
    public String waterTypeString(){
        if (this.waterType==WaterTypes.Sea)
            return "Sea";
        return "Sweet";
    }
    @Override
    public String toString() {
        return super.toString()+" Dolphin: water type="+this.waterTypeString();
    }
    @Override
    public String retType() {
        return "Dolphin";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 3;
    }
}
