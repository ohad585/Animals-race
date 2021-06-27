/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Graphics.IDrawable;
import Graphics.CompetitionFrame;
import Graphics.Orientation;
import Mobility.Point;
import Olympics.Medal;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * abstract class ,extend Animal.
 * describes all terrestrial animals
 */
public abstract class TerrestrialAnimals extends Animal {
    private int noLegs;
    protected String animalpicname;
    /**
     * Instantiates a new Terrestrial animals.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the spees
     * @param md   the medals
     * @param nl   the number of legs
     */
    public TerrestrialAnimals(String nm, genderType gndr, double we, double sp, Medal[] md,Point p1, int nl,int maxEnergy,int energyPerMeter){
        super(nm,gndr,we,sp,md,new Point(25,5),maxEnergy,energyPerMeter);
        this.noLegs=nl;
        if(p1!=null){
            //this.setLocation(p1);
        }
    }

    /**
     * default constructor
     */
    public TerrestrialAnimals(){
        super(new Point(0,20));
        this.noLegs=0;
    }
    @Override
    public String toString() {
        return super.toString()+" Terrestrial Animal " +
                "number of legs=" + this.noLegs ;
    }

    /**
     * Sets number legs.
     * @param noLegs the number of legs
     */
    public void setNoLegs(int noLegs) {
        if(noLegs<0){
            System.out.println("Require positive number");
            return;
        }
        this.noLegs = noLegs;
    }

    /**
     * Gets number legs.
     *
     * @return the number of legs
     */
    public int getNoLegs() {
        return noLegs;
    }

    @Override
    public void drawObject(Graphics g) {
        super.drawObject(g);
    }

    @Override
    public String getCategory() {
        return "Terrestrial";
    }

    @Override
    public void setOrien(Orientation orien) {
        super.setOrien(orien);
        loadImages(animalpicname);
    }


    public boolean setLocationT(Animal ani) {
        super.setLocation(ani.getLocation());
        setOrien(ani.getOrien());
        return true;
    }

    /**
     * moves the animal in the correct direction.
     *
     * @return if the animal moved .
     */
    @Override
    public double moveInDirection() {
        double flag=0;
        int movepixels= (int) (CompetitionFrame.MOVEPIXSELS*getSpeed());
        Point temp=getLocation();
        int tempi=0;
        switch (orien){
            case EAST:
                if(temp.getX()+movepixels>=705){
                    orien= Orientation.SOUTH;
                    loadImages(animalpicname);
                    tempi=temp.getX()+movepixels-705;
                    flag=move(new Point(705,5+tempi));
                }
                else flag=move(new Point((int) (temp.getX()+ CompetitionFrame.MOVEPIXSELS *getSpeed()),5));
                break;
            case NORTH:
                if(temp.getY()-movepixels<5){
                    orien=Orientation.EAST;
                    loadImages(animalpicname);
                    flag=move(new Point(1,5));
                }
                else flag=move(new Point(1,temp.getY()-movepixels));
                break;
            case SOUTH:
                if(temp.getY()+movepixels>605){
                    orien=Orientation.WEST;
                    loadImages(animalpicname);
                    tempi=temp.getY()+movepixels-605;
                    flag=move(new Point(temp.getX()-tempi,605));
                }
                else flag=move(new Point(temp.getX(),temp.getY()+movepixels));
                break;
            case WEST:
                    if(temp.getX()-movepixels<1){
                        orien=Orientation.NORTH;
                        loadImages(animalpicname);
                        tempi=movepixels-temp.getX();
                        flag=move(new Point(1,temp.getY()-tempi));
                    }
                    else flag=move(new Point(temp.getX()-movepixels,temp.getY()));
                break;
        }
        return flag;
    }

}
