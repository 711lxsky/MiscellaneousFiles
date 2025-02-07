package practice.MultiThreadPrint_240924;

import java.util.concurrent.locks.ReentrantLock;

public class PrintABCWithLock {

    private int times;
    private int state;
    private int num;
    private ReentrantLock lock;

    public PrintABCWithLock(int times, int num){
        this.times = times;
        this.state = 0;
        this.num = num;
        this.lock = new ReentrantLock();
    }

    public void printLetter(String target, int targetState){
        for(int i = 0; i < this.times; ){
            lock.lock();
            if(state % num == targetState){
                System.out.print(target);
                state ++;
                i ++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABCWithLock printABCWithLock = new PrintABCWithLock(10, 3);
        new Thread(
                () ->{
                    printABCWithLock.printLetter("A", 0);
                }, "A"
        ).start();
        new Thread(
                () -> printABCWithLock.printLetter("B", 1)
                , "B"
        ).start();
        new Thread(
                () -> printABCWithLock.printLetter("C", 2)
                , "C"
        ).start();
    }

}
