package thread.control.test;

import static util.ThreadUtils.sleep;

public class JoinTest1Main {

    public static void main(String[] args) throws InterruptedException {

        Task task1 = new Task();
        Task task2 = new Task();

        Thread thread1  = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int result = task1.result + task2.result;
        System.out.println("result : " + result);

    }

    static class Task implements Runnable{
        int result = 0;
        @Override
        public void run() {
            for(int i=0; i<3; i++){
                result += i;
                System.out.print(Thread.currentThread().getName() + "," + i);
                System.out.println();
                sleep(1000);
            }
        }
    }
}
