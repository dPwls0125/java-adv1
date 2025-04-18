package thread.start.test;

import java.awt.print.Pageable;

public class multiThreadMain {
    public static void main(String[] args) {

        Runnable r1 = new PrintWork("Thread-A",1000);
        Runnable r2 = new PrintWork("Thread-B",500);

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();
    }

    static class PrintWork implements Runnable{
        String content;
        int time ;
        public PrintWork(String printWork, int miliSecond){
            this.content = printWork;
            this.time = miliSecond;
        }
        @Override
        public void run() {
            while(true) {
                System.out.println(content);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
