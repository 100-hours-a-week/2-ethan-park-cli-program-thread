package domain.Motorized.thread;

public class ChargePercent extends Thread {

    public void run() {

        int percent = 0;
        System.out.println("주유중.....");
        while(!Thread.currentThread().isInterrupted()){
            try {
                if(percent == 100)
                    interrupt();

                sleep(1000);
                percent+=10;
                System.out.println("현재 진행도 : " + percent + "%...");
            } catch (InterruptedException e) {
                System.out.println("주유가 완료되었습니다.");
                break;
            }
        }
    }
}
