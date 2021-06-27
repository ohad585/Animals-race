/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Mobility;

/**
 * Mobile class that defines movement ,extends ILocatable
 */
public class Mobile implements ILocatable {
    private Point location;
    private double totalDistance;

    /**
     * constructor
     *
     * @param p1 object start location
     */
    public Mobile(Point p1){
        this.location=new Point(p1);
        totalDistance=0;
    }
    public Mobile(){
        this.location=new Point();
        totalDistance=0;
    }
    /**
     * return mobile as string
     */
    @Override
    public String toString() {
        return  "location=" + location +
                ", totalDistance=" + totalDistance ;
    }

    /**
     * addTotalDistance add new distance
     *
     * @param dc new distance to be added
     */
    public void addTotalDistance(double dc){
        this.totalDistance+=dc;
    }

    /**
     * calsDistance calls the point method of calculating distance between 2 points
     *
     * @param p1 second point
     * @return the distance between the 2 points
     */
    public double calsDistance(Point p1){
        return this.location.calcDis(p1);
    }

    /**
     * move moving object from one point to another one
     *
     * @param p1 point to move to
     * @return distance traveled
     */
    public double move(Point p1){
        double db1=0;
        db1=this.calsDistance(p1);
        this.addTotalDistance(db1);
        this.location=new Point(p1);
        return  db1;
    }
    @Override
    public Point getLocation() {
        return this.location;
    }

    @Override
    public boolean setLocation(Point p1) {
        this.location=new Point(p1);
        return true;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
