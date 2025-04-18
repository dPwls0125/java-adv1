package thread.start.test;

import static util.MyLogger.log;
public class CounterRunnableMain {
    public static void main(String[] args) throws InterruptedException {
        CounterRunnable runnable = new CounterRunnable();
        Thread thread = new Thread(runnable, "counter runnable");
        thread.start();
    }

    static class CounterRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=1; i<6; i++){
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
