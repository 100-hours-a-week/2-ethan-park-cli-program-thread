package domain.Motorized;

public class AutoParking extends Thread {

    public void run() {
        System.out.println("자동 주차를 시작합니다.");
        int percent = 0;

        System.out.println("주차 진행중..");
        while(!Thread.currentThread().isInterrupted()){
            try {
                if(percent == 100)
                    interrupt();

                sleep(1000);
                percent+=10;
                System.out.println("현재 진행도 : " + percent + "%...");
            } catch (InterruptedException e) {
                System.out.println("자동 주차가 완료되었습니다.");
                break;
            }
        }
    }
}
