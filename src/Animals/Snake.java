/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Animals;

import Mobility.Point;
import Olympics.Medal;

;
/**
 * The type Snake.
 */

public class Snake extends TerrestrialAnimals implements Reptile {
    private PoisonousLevel poisonous;
    private double lenght;
    /**
     * Instantiates a new snake.
     *
     * @param nm   the name
     * @param gndr the gender
     * @param we   the weight
     * @param sp   the spees
     * @param md   the medals
     * @param poisonous   if the snake is poisonous or not
     * @param lenght the snake length
     */
    public Snake(String nm, genderType gndr, double we, double sp, Medal[] md, Point p1, PoisonousLevel poisonous, double lenght,int maxEnergy,int energyPerMeter){
        super(nm, gndr, we, sp, md,p1, 0,maxEnergy,energyPerMeter);
        this.poisonous=poisonous;
        this.lenght=lenght;
        animalpicname="snake";
        loadImages("snake");
    }
    /**
     * default constructor
     */
    public Snake(){
        super();
        this.poisonous=PoisonousLevel.LOW;
        this.lenght=0;
    }
    @Override
    protected String classSound() {
        return "ssssssss";
    }

    @Override
    public String toString() {
        return super.toString()+" Snake: poisonous="+this.poisonous+
                " length="+this.lenght;
    }

    @Override
    public void speedUp(int ms) {
        if(ms+this.getSpeed()>=Reptile.MAX_SPEED){
            System.out.println("Max speed reached");
            this.setSpeed(Reptile.MAX_SPEED);
        }
        else this.setSpeed(this.getSpeed()+ms);
    }
    @Override
    public String retType() {
        return "Snake";
    }

    /**
     * @return number of available images
     */
    @Override
    public int picArsenal() {
        return 2;
    }
}
