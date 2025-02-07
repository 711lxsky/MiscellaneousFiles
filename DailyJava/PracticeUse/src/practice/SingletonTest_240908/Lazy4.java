package practice.SingletonTest_240908;

/**
 * 内部静态类 懒汉单例
 */
public class Lazy4 {

    private Lazy4(){}

    private static class SingletonHolder {
        private static final Lazy4 instance = new Lazy4();
    }

    public static Lazy4 getInstance(){
        return SingletonHolder.instance;
    }

    // 防止反序列化破坏单例
    protected Object readResolve() {
        return getInstance();
    }
}
