package thread.start.test;

import static util.MyLogger.log;

public class AnonymousCounterRunnable{
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<6; i++){
                    System.out.println("value: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
