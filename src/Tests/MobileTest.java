package Tests;

import Mobility.Mobile;
import Mobility.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Mobile test.
 */
public class MobileTest {
    /**
     * Test move.
     */
    @Test
    public void testMove(){
        Point p1=new Point();
        Point p2=new Point(2,0);
        Mobile m1=new Mobile(p1);
        double d1=m1.move(p2);
        double d2=p1.calcDis(p2);
        Assert.assertEquals(d1,d2,0.2);
    }
}
