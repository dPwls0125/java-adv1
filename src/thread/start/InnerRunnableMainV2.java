package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main()");

        // 특정 메서드 안에서만 간단히 정의하고 사용하고 싶다면 익명 클래스를 사용하면 된다.
        Runnable runnable = new Runnable() {
            @Override
            public void run(){
                log("run()");
            }
        };

        Thread thread = new Thread(runnable);
        // 람다를 사용
        //Thread thread = new Thread(() -> log("run()"));
        thread.start();
        log("main() end");
    }
}
