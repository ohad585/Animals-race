/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;
import Graphics.CompetitionPanel;
import Graphics.IAnimal;
import Graphics.IDrawable;
import Graphics.Orientation;
import Mobility.ILocatable;
import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static Graphics.Orientation.*;

/**
 * abstract class that extends mobile
 */
public abstract class Animal extends Mobile implements ILocatable, IAnimal,IDrawable,Cloneable {
    private String name;
    private genderType gender;
    private double weight;
    private double speed;
    private Medal[] medals;
    //HW2
    protected int size;
    protected Orientation orien;
    protected int maxEnergy;
    protected int currentEnergy;
    protected int energyPerMeter;
    protected CompetitionPanel pan;
    protected BufferedImage img1;
    protected int picnumber;
    public static int animalsCreated=0;
    public static int animalsDeleted=0;
    //HW3
    protected AtomicBoolean canRun;


    /**
     * Animal constructor
     *
     * @param nm   name of animal
     * @param gndr animal gender
     * @param we   animal weight
     * @param sp   animal speed
     * @param md   animal medals list
     * @param p    animal location
     * @param energyPerMeter animals energy per meter
     * @param maxEnergy max energy
     */
    public Animal(String nm,genderType gndr,double we,double sp,Medal[] md,Point p,int maxEnergy,int energyPerMeter){
        super(p);
        animalsCreated++;
        this.name=new String(nm);
        this.gender=gndr;
        this.weight=we;
        this.speed=sp;
        if(md!=null) {
            this.medals = new Medal[md.length];
            for (int i = 0; i < md.length; i++) {
                this.medals[i] = new Medal(md[i]);
            }
        }
        else this.medals=null;
        this.maxEnergy=maxEnergy;
        this.energyPerMeter=energyPerMeter;
        this.currentEnergy=maxEnergy;
        this.canRun=new AtomicBoolean(true);
        this.size=65;
        this.orien=EAST;
        this.picnumber=1;
        pan=CompetitionPanel.getInstance();
    }

    /**
     * default constructor
     */
    public Animal(){
        super();
        this.name="Animal";
        this.gender=genderType.Male;
        this.weight=0;
        this.speed=0;
        this.medals=new Medal[1];
        this.medals[0]=new Medal();
    }

    /**
     * default constructor with given point
     * @param p animal location
     */
    public Animal(Point p){
        super(p);
        this.name="Animal";
        this.gender=genderType.Male;
        this.weight=0;
        this.speed=0;
        this.medals=new Medal[1];
        this.medals[0]=new Medal();
    }
    /**
     * makeSound prints animal sound
     */
    public void makeSound(){
        System.out.println("Animal " + this.name +
                            " said " + this.classSound() );
    }

    /**
     * classSound
     * @return individual class sound
     */
    protected abstract String classSound();

    /**
     * toString return animal as string
     */
    @Override
    public String toString() {
        return "Animal:" +
                " name=" + name  +
                ", gender=" + gender +
                ", weight=" + weight +
                ", speed=" + speed +
                ", medals=" + Arrays.toString(medals)+
                ", location="+ this.getLocation();
    }

    /**
     * @return animal speed
     */
    public double getSpeed(){ return this.speed;}
    public boolean setSpeed(double sp){
        this.speed=sp;
        return true;
    }

    /**
     * get name.
     * @return animal name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * get the current energy.
     * @return current energy.
     */
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * Calculate the energy spent.
     * @return animal energy spent.
     */
    public int calcEnergySpent(){return currentEnergy-maxEnergy;}

    /**
     * Get animal category
     * @return animal category as a String
     */
    public abstract String getCategory();

    /**
     * Animal Type(Dog,Cat,...)
     * @return animal type as string
     */
    public abstract String retType();
    @Override
    public boolean eat(int energy) {
        if(energy<0)
            return false;
        if(this.currentEnergy+energy>=this.maxEnergy)
        {
            this.currentEnergy=this.maxEnergy;
        }
        else this.currentEnergy+=energy;
        return true;
    }

    /**
     * loads picture into img1 .
     * @param nm image name
     */
    public void loadImages(String nm) {
        String s="E";
        switch (orien){
            case EAST:
                s="E";
                break;
            case WEST:
                s="W";
                break;
            case SOUTH:
                s="S";
                break;
            case NORTH:
                s="N";
                break;
        }
        try {
            img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH+nm+picnumber+s+".png"));

        }
        catch (IOException e) { System.out.println("Cannot load image"); }

    }

    /**
     * move moving object from one point to another one
     *
     * @param p1 point to move to
     * @return distance traveled
     */
    @Override
    public double move(Point p1) {
        if(currentEnergy-energyPerMeter<0){
            canRun.set(false);
            //JOptionPane.showMessageDialog(pan,"Not enough energy to run please eat!");
            System.out.println(this.currentEnergy);
            return 0;
        }
        double distance=super.move(p1);
        this.currentEnergy=this.currentEnergy-this.energyPerMeter;
        return distance;
    }

    /**
     * draws img1 to panel
     * @param g
     */
    @Override
    public void drawObject(Graphics g) {
        g.drawImage(img1,getLocation().getX(),getLocation().getY(),size,size, pan);
    }

    /**
     * sets the animal picture number
     * @param picnumber picture number 1,2,...,n
     */
    public void setPicnumber(int picnumber) {
        this.picnumber = picnumber;
        loadImages(retType().toLowerCase());
    }

    public Orientation getOrien() {
        return orien;
    }

    public void setOrien(Orientation orien) {
        this.orien = orien;

    }

    public AtomicBoolean getCanRun() {
        return canRun;
    }

    public void myFinalize(){
        animalsDeleted++;
    }
}