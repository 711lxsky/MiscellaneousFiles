package practice.SingletonTest_240908;

/**
 * 线程安全式 懒汉单例
 * 效率太差
 */
public class Lazy2 {

    private Lazy2(){}

    private static Lazy2 instance;

    public static synchronized Lazy2 getInstance(){
        if(instance == null){
            instance = new Lazy2();
        }
        return instance;
    }

}
