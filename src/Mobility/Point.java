/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Mobility;

import java.lang.Math;

/**
 * Point class
 */
public class Point implements Cloneable {
    private int x;
    private int y;

    /**
     * default constructor.
     * x=0,y=0.
     */
    public Point(){
        this.x=0;
        this.y=0;
    }

    /**
     * constructor
     *
     * @param x point x
     * @param y point y
     */
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    /**
     * copy constructor
     *
     * @param p1 point to be deep copied
     */
    public Point(Point p1){
        this.x=p1.getX();
        this.y=p1.getY();
    }

    /**
     * Sets x.
     *
     * @param x new x to set
     * @return true -successful ,false-failed
     */
    public boolean setX(int x) {
        if(x>=0) {
            this.x = x;
            return true;
        }
        return false;
    }

    /**
     * Set y boolean.
     *
     * @param y new y to set
     * @return true -successful ,false-failed
     */
    public boolean setY(int y){
        if(y>=0){
            this.y=y;
            return true;
        }
        return false;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * calcDis calculate distance
     *
     * @param p1 point to calc the distance between
     * @return the distance between this point to p1
     */
    public double calcDis(Point p1){
        return Math.sqrt(Math.pow((this.x-p1.x),2)+Math.pow(this.y-p1.y,2));
    }

    /**
     * toString
     * @return Point as a string
     */
    @Override
    public String toString() {
        return  "x=" + x +
                ", y=" + y;
    }


}
