package practice.SingletonTest_240908;

/**
 * 最普通的懒汉式，线程不安全
 */
public class Lazy1 {

    private Lazy1(){}

    private static Lazy1 instance;

    public static Lazy1 getInstance(){
        if(instance == null){
            instance = new Lazy1();
        }
        return instance;
    }
}
