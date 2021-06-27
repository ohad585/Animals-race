package Tests;

import Mobility.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Point test.
 */
public class PointTest {
    /**
     * Test calc dis.
     */
    @Test
    public void testCalcDis(){
        Point p1=new Point();
        Point p2=new Point(3,0);
        Assert.assertEquals(3.0,p1.calcDis(p2),0.9);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString(){
        Point p1=new Point();
        Assert.assertEquals( "x=" + 0+
                            ", y=" + 0,p1.toString());
    }
}
