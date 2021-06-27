/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Mobility;

/**
 * Locatable interface
 */
public interface ILocatable {
    /**
     * getLocation
     *
     * @return object location
     */
    public Point getLocation();

    /**
     * setLocation
     *
     * @param p1 reference to a new point to be set
     * @return boolean value if the set was successful
     */
    public boolean setLocation(Point p1);
}
