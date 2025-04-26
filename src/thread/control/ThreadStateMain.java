package thread.control;

import java.util.concurrent.Callable;
import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread  = new Thread(new MyRunnable());
        log("myThread.state1 = " + myThread.getState());
        myThread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + myThread.getState());
        Thread.sleep(4000);
        log("myThread.state4 = " + myThread.getState());
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            log("start");
            log("sleep() start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("sleep() end");
            log("end");
            // Callable
        }
    }

}
