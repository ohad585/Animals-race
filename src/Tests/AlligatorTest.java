package Tests;

import Animals.Alligator;
import Animals.Animal;
import Animals.genderType;
import org.junit.Test;

public class AlligatorTest extends Alligator {
    public AlligatorTest(){
        super("Ali", genderType.Male,200,2.5,null,null,4,"Ashdod",4,6,6);
    }
    @Test
    public void TestMakeSound(){
        Animal a1=new AlligatorTest();
        a1.makeSound();
    }
}
