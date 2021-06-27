/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

/**
 * Reptile interface
 */
public interface Reptile {
    /**
     * The constant MAX_SPEED.
     */
    static final int MAX_SPEED=5;

    /**
     * Speed up.
     * increase speed value at animal
     * @param ms new_speed = ms + old_speed
     */
    public void speedUp(int ms);
}
