package thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + ": start");

        System.out.println(Thread.currentThread().getName() + ": run 호출 전");
        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable);

        thread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
        System.out.println(Thread.currentThread().getName() + ": run 호출 후");
    }
}
