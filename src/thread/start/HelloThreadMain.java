package thread.start;
import thread.start.HelloThread;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + ": start");

        System.out.println(Thread.currentThread().getName() + ": run 호출 전");
        HelloThread helloThread = new HelloThread();
        helloThread.run();
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": run 호출 후");
        System.out.println(Thread.currentThread().getName() + ": main() end");

    }
}
