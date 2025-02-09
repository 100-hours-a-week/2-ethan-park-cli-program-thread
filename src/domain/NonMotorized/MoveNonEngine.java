package domain.NonMotorized;

public class MoveNonEngine extends Thread{

    private NonMotorizedVehicle nonMotorizedVehicle;

    public MoveNonEngine(NonMotorizedVehicle nonMotorizedVehicle) {
        this.nonMotorizedVehicle = nonMotorizedVehicle;
    }

    public void run() {
        int meter = 0;

        while(!Thread.currentThread().isInterrupted()){
            try {
                sleep(1000);
                meter = increaseDistance(meter);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public synchronized int increaseDistance(int meter) {
        meter+=nonMotorizedVehicle.getMove_oneDistnace();
        nonMotorizedVehicle.setMove_totalDistance(nonMotorizedVehicle.getMove_oneDistnace() + nonMotorizedVehicle.getMove_totalDistance());
        System.out.println("현재 이동 거리 : " + meter + "m");

        return meter;
    }

}
