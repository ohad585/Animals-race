/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;
import Graphics.CompetitionFrame;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * abstract class ,extend Animal.
 * describes all water animals
 */
public abstract class WaterAnimal extends Animal{
    /**
     * The Max dive.
     */
    protected String animalpicname;
    static final int MAX_DIVE=-800;
    private double diveDept=0;

    /**
     * Instantiates a new Water animal.
     *
     * @param nm   the nm
     * @param gndr the gndr
     * @param we   the we
     * @param sp   the sp
     * @param md   the md
     * @param dd   the dd
     */
    public WaterAnimal(String nm, genderType gndr, double we, double sp, Medal[] md,Point p1, double dd,int maxEnergy,int energyPerMeter){
        super(nm,gndr,we,sp,md,new Point(68,83),maxEnergy,energyPerMeter);
        this.Dive(dd);
    }
    /**
     * Dive.
     *
     * @param d the d
     */
    public void Dive(double d){
        if(d<=WaterAnimal.MAX_DIVE){
            System.out.println("exceeded max dive");
            return;
        }
        this.diveDept=d;
    }
    @Override
    public String toString() {
        return super.toString()+" Water Animal " +
                "Dive depth=" + this.diveDept ;
    }

    /**
     * Gets dive dept.
     *
     * @return the dive dept
     */
    public double getDiveDept() {
        return diveDept;
    }

    @Override
    public String getCategory() {
        return "Water";
    }

    /**
     * moves the animal in the correct direction.
     *
     * @return if the animal moved .
     */
    @Override
    public double moveInDirection() {
        double flag=0;
        Point temp=getLocation();
        int distance=(int) (CompetitionFrame.MOVEPIXSELS*getSpeed());
        if(temp.getX()+distance>630){
            flag=move(new Point(630,temp.getY()));
        }
        else flag=move(new Point(temp.getX()+distance,temp.getY()));
        return flag;
    }
}
