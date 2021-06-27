/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Graphics.CompetitionFrame;
import Mobility.Point;
import Olympics.Medal;
import Olympics.Medaltype;


import static Animals.genderType.Male;

/**
 * abstract class ,extend Animal.
 * describes all air animals
 */
public abstract class AirAnimal extends Animal {
    private double wingspan;

    /**
     * AirAnimal constructor
     *
     * @param nm   the nm
     * @param gndr the gndr
     * @param we   the we
     * @param sp   the sp
     * @param md   the md
     * @param ws   air animal wingspan
     */
    public AirAnimal(String nm, genderType gndr, double we, double sp, Medal[] md,Point p1, double ws,int maxEnergy,int energyPerMeter){
        super(nm,gndr,we,sp,md,new Point(25,5),maxEnergy,energyPerMeter);
        this.wingspan=ws;
        if(p1!=null){
            this.setLocation(p1);
        }
    }

    /**
     * default constructor
     */
    public AirAnimal(){
        super(new Point(0,100));
        this.wingspan=0;
    }

    /**
     * @return AirAnimal as string
     */
    @Override
    public String toString() {
        return super.toString()+" AirAnimal " +
                "wingspan=" + wingspan ;
    }

    @Override
    public String getCategory() {
        return "Air";
    }

    /**
     * moves the animal in the correct direction.
     *
     * @return if the animal moved .
     */
    @Override
    public double moveInDirection() {
        double flag=0;
        int distance= (int) (CompetitionFrame.MOVEPIXSELS*getSpeed());
        Point temp = getLocation();
        if(temp.getX()+distance>695){
            flag =move(new Point(695,temp.getY()));
        }
        else flag=move(new Point(temp.getX()+distance,temp.getY()));
        return flag;
    }
}
