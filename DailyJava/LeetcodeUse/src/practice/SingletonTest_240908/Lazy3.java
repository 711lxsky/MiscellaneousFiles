package practice.SingletonTest_240908;

/**
 * 双重检查锁 懒汉单例
 */
public class Lazy3 {

    private Lazy3(){}

    private static volatile Lazy3 instance;

    public static Lazy3 getInstance(){
        if(instance == null){
            synchronized (Lazy3.class){
                if(instance == null){
                    instance = new Lazy3();
                }
            }
        }
        return instance;
    }

}
