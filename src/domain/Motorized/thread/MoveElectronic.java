package domain.Motorized.thread;

import domain.Motorized.Interface.MoveThread;
import domain.Motorized.MotorizedVehicle;

public class MoveElectronic extends Thread implements MoveThread {

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
                    warningShow();
                    interrupt();
                }
            } catch (InterruptedException e) {
                break;
            }
        }


    }

    @Override
    public synchronized void useFuel() {
        motorizedVehicle.setFuel(motorizedVehicle.getFuel() - motorizedVehicle.getUseFuel());
    }

    @Override
    public synchronized int increaseDistance(int meter) {
        meter+=motorizedVehicle.getMove_oneDistnace();
        motorizedVehicle.setMove_totalDistance(motorizedVehicle.getMove_oneDistnace() + motorizedVehicle.getMove_totalDistance());
        System.out.println("현재 이동 거리 : " + meter + "m");

        return meter;
    }

    @Override
    public void warningShow() {
        System.out.println("배터리가 부족하여 자동 주행이 종료됩니다.");
        System.out.println("금일 총 이동 거리 : " + motorizedVehicle.getMove_totalDistance());
        System.out.println("충전을 진행하세요.");
        System.out.println("이어서 진행하려면 엔터를 눌러주세요.");
    }

}
