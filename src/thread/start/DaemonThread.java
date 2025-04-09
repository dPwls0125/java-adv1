package thread.start;

public class DaemonThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()  + " : daemon-start");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()  + " : daemon-end");
    }

}

class DaeMonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + ": start");

        System.out.println(Thread.currentThread().getName() + ": run 호출 전");
        DaemonThread th = new DaemonThread();
        th.setDaemon(true); // 데몬 쓰레드 설정
        th.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
        System.out.println(Thread.currentThread().getName() + ": run 호출 후");
    }
}
