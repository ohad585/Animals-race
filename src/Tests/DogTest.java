package Tests;

import Animals.Dog;
import Animals.genderType;
import Olympics.Medal;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Dog test.
 */
public class DogTest extends Dog{
    /**
     * Instantiates a new Dog test.
     */
    public DogTest() {
        super("Buffy", genderType.Male,8,10,new Medal[2],null,4,"Pintzer",6,6);
    }

    /**
     * Test dog class sound method.
     */
    @Test
    public void TestDogClassSound(){
        DogTest d2=new DogTest();
        Assert.assertEquals("Woof Woof",d2.classSound());
    }
}
