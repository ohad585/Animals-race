/**
 * Ohad Shalom 204525505
 * Yana Chichkin 321271033
 */
package Olympics;


;

/**
 * Medal class
 */
public class Medal {
    private Medaltype type;
    private String tournament;
    private int year;

    /**
     * default constructor
     */
    public Medal(){
        this.type=Medaltype.bronze;
        this.tournament="Judo";
        this.year=2019;
    }

    /**
     * constructor
     *
     * @param tp Type of the medal
     * @param tr tournament name
     * @param yr tournament year
     */
    public Medal(Medaltype tp,String tr,int yr){
        this.type=tp;
        this.tournament=new String(tr);
        this.year=yr;
    }

    /**
     * copy constructor
     *
     * @param m1 Medal to be deep copied
     */
    public Medal(Medal m1){
        this.tournament=m1.tournament;
        this.type=m1.type;
        this.year=m1.year;
    }

    /**
     * checks for type of medal and returns as string
     *
     * @return Medal type as string
     */
    public String medalTypeString(){
        if(this.type==Medaltype.bronze)
            return "bronze";
        if(this.type==Medaltype.silver)
            return "silver";
        return "gold";
    }

    /**
     * @return Medal as a string
     */
    @Override
    public String toString() {
        return "Medal: " +
                "type= " + this.medalTypeString() +
                ", tournament= " + tournament +
                ", year= " + year ;
    }
}
