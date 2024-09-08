package practice.SingletonTest_240908;

public class Hungry1 {

    private Hungry1(){}

    private static final Hungry1 instance = new Hungry1();

    public static Hungry1 getInstance(){
        return instance;
    }

}
