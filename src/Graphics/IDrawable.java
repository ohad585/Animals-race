/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Graphics;

import java.awt.*;

/**
 * interface to dram animals
 */
public interface IDrawable {
    public final static String PICTURE_PATH = "src/Graphics/Images/";
    public String animalpicname="";
    /**
     * Load images to class.
     * @param nm image name
     */
    public void loadImages(String nm);

    /**
     * Draw the picture to the panel.
     * @param g
     */
    public void drawObject (Graphics g);
    /**
     * @returns number of pics available.
     */
    public int picArsenal();

    /**
     * moves the animal in the correct direction.
     * @return if the animal moved .
     */
    public double moveInDirection();
}
