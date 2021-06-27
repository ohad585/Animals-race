package Tests;

import Olympics.Medal;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Medal test.
 */
public class MedalTest {
    /**
     * Test medal type string.
     */
    @Test
    public void testMedalTypeString(){
        Medal m1=new Medal();
        Assert.assertEquals("bronze",m1.medalTypeString());
    }

    /**
     * Test medal to string.
     */
    @Test
    public void testMedalToString(){
        Medal m1=new Medal();
        Assert.assertEquals("Medal: " +
                "type= " + "bronze" +
                ", tournament= " + "Judo" +
                ", year= " + 2019,m1.toString());
    }
}
