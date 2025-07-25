package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Job());
        Thread thread2 = new Thread(new Job());

        log("시작");
        thread1.start();
        thread2.start();
        log("완료");

    }

    static class Job implements Runnable{
        @Override
        public void run() {
            log("작업 시작");
            sleep(1000);
            log("작업 완료");
        }
    }
}
