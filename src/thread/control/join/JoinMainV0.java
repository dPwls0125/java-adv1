package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {


    static class Job implements Runnable{
        @Override
        public void run() {
            log("작업 시작");
            sleep(1000);

        }
    }
}
