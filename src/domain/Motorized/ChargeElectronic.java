package domain.Motorized;

import domain.Motorized.Interface.ChargeFuel;
import domain.Motorized.thread.ChargePercent;

public class ChargeElectronic implements ChargeFuel {

    private MotorizedVehicle motorizedVehicle;
    private int totalMoney;

    public ChargeElectronic(MotorizedVehicle motorizedVehicle) {
        this.motorizedVehicle = motorizedVehicle;
        this.totalMoney = 0;
    }

    @Override
    public boolean checkFuel() {
        if(motorizedVehicle.getFuel() != 100) {
            System.out.println("현재 배터리 : " + motorizedVehicle.getFuel());
            System.out.print("충전할 배터리를 입력하세요 : ");
            return false;
        }

        System.out.println("풀충전 상태이므로 충전이 불가능합니다.");
        return true;
    }

    //연료 충전
    @Override
    public synchronized void calculateFuel(int fuel) {

        if(fuel > motorizedVehicle.getMax() - motorizedVehicle.getFuel()) {
            System.out.println("\n충전 가능 배터리보다 많이 입력하셨습니다. 풀충전하겠습니다.");
            System.out.println("충전할 연료 : " + (motorizedVehicle.getMax()-motorizedVehicle.getFuel()) + "%");
            totalMoney = (motorizedVehicle.getMax()-motorizedVehicle.getFuel()) * motorizedVehicle.getPriceFuel();
            System.out.println("퍼센트당 " + motorizedVehicle.getPriceFuel() + "원, 총 " + totalMoney + "원 입니다.");
            motorizedVehicle.setFuel(motorizedVehicle.getMax());
        }
        else {
            System.out.println("\n충전할 배터리 : " + fuel + "%");
            System.out.println("퍼센트당 " + motorizedVehicle.getPriceFuel() + "원, 총 " + (fuel * motorizedVehicle.getPriceFuel()) + "원 입니다.");
            motorizedVehicle.setFuel(motorizedVehicle.getFuel() + fuel);
        }

        ChargePercent chargePercent = new ChargePercent();
        chargePercent.start();

        try {
            chargePercent.join();
        } catch (InterruptedException e){
        }

        System.out.println("충전 후 연료 : " + motorizedVehicle.getFuel() + "%\n");
        System.out.println("지불할 금액을 입력하세요. : ");

    }

    //사용자가 입력한 금액으로 계산
    @Override
    public boolean calculateMoney(int money) {

        if(totalMoney > money) {
            System.out.println("\n충전 요금보다 적게 입력하셨습니다.");
            System.out.println("충전 요금보다 이상의 금액을 입력해주세요.");
            System.out.print("지불하실 요금을 입력해주세요 : ");

            return false;
        }

        System.out.println("\n지불하신 금액은 " + money + "원 입니다.");
        System.out.println("거스름돈은 " + (money - totalMoney) + "원 입니다.");

        System.out.println("감사합니다.");

        return true;

    }
}
