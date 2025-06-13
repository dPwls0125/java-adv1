package thread.control.join;

import static util.MyLogger.log;

public class JoinMainV1 {
    static class SumTask implements Runnable{

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue){
            this.startValue = startValue;
            this.endValue  = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            int sum = 0;
            for(int i=startValue; i<=endValue; i++){
                sum += i;
            }
            
            log("작업 완료 result =" + result);
        }
    }
}
