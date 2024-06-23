package practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreadPrint_240623 {

    private final AtomicInteger count = new AtomicInteger(1);

    private static final int MAX = 100;

    private final Semaphore odd = new Semaphore(1);

    private final Semaphore even = new Semaphore(0);

    class OddPrinter implements Runnable {

        @Override
        public void run() {
            while (count.get() < MAX){
                try{
                    odd.acquire();
                    if(count.get() % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + "==: " + count.getAndIncrement());
                        even.release();
                    }
                    else {
                        odd.release();
                    }
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    class EvenPrinter implements Runnable {

        @Override
        public void run() {
            while(count.get() < MAX){
                try {
                    even.acquire();
                    if(count.get() % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + "--: " + count.getAndIncrement());
                        odd.release();
                    }
                    else {
                        even.release();
                    }
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadPrint_240623 printer = new TwoThreadPrint_240623();
        Thread t1 = new Thread(printer.new OddPrinter(), "OddPrinter1");
        Thread t2 = new Thread(printer.new EvenPrinter(), "EvenPrinter1");
        t1.start();
        t2.start();
    }

}
