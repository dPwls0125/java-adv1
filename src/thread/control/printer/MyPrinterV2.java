package thread.control.printer;

import java.io.BufferedInputStream;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV2 {
    public static void main(String[] args) {
        Printer printer  = new Printer();
        Thread printerThread = new Thread(printer);
        printerThread.start();

        Scanner userInput = new Scanner(new BufferedInputStream(System.in));

        while(true){
            log("프린터할 문서를 입력하세요. 종료 (q): ");
            String input = userInput.nextLine();
            if(input.equals("q")){
                printer.work = false;
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable{
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();
        @Override
        public void run() {
            while(work){

                if(jobQueue.isEmpty()){
                    continue;
                }
                try{
                    String job = jobQueue.poll();
                    log("출력 시작 : " + job + ", 대기 문서: "+ jobQueue);
                    Thread.sleep(1000);
                    log("출력 완료 : " + job);
                }catch(InterruptedException e){
                    log("인터럽트!");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void addJob(String input){
            jobQueue.offer(input);
        }
    }
}
