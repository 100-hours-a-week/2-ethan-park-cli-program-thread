package domain.Motorized;

public class MoveElectronic extends Thread{

    private MotorizedVehicle motorizedVehicle;

    public MoveElectronic(MotorizedVehicle motorizedVehicle) {
        this.motorizedVehicle = motorizedVehicle;
    }

    public void run() {
        int meter = 0;

        while(!Thread.currentThread().isInterrupted()){
            try {
                sleep(1000);
                useFuel();
                meter = increaseDistance(meter);

                if(motorizedVehicle.getFuel() == 0){
                    sleep(1000);
                    System.out.println("배터리가 부족하여 주행이 불가능합니다.");
                    System.out.println("충전을 진행하세요.");
                    System.out.println("이어서 진행하려면 엔터를 눌러주세요.");
                    return;
                }
            } catch (InterruptedException e) {
                break;
            }
        }


    }

    public synchronized void useFuel() {
        motorizedVehicle.setFuel(motorizedVehicle.getFuel() - motorizedVehicle.getUseFuel());
    }

    public synchronized int increaseDistance(int meter) {
        meter+=motorizedVehicle.getMove_oneDistnace();
        motorizedVehicle.setMove_totalDistance(motorizedVehicle.getMove_oneDistnace() + motorizedVehicle.getMove_totalDistance());
        System.out.println("현재 이동 거리 : " + meter + "m");

        return meter;
    }


}
