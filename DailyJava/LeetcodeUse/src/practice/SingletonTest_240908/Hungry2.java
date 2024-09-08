package practice.SingletonTest_240908;

public class Hungry2 {

    private Hungry2(){};

    private static final Hungry2 instance;
    static {
        instance = new Hungry2();
    }

    public static Hungry2 getInstance(){
        return instance;
    }


}
