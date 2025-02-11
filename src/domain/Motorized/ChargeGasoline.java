package domain.Motorized;

import domain.Motorized.Interface.ChargeFuel;
import domain.Motorized.thread.ChargePercent;
import domain.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChargeGasoline implements ChargeFuel {

    private MotorizedVehicle motorizedVehicle;
    private int totalMoney;

    public ChargeGasoline(MotorizedVehicle motorizedVehicle) {
        this.motorizedVehicle = motorizedVehicle;
        this.totalMoney = 0;
    }

    @Override
    public void startFuel() {
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);

        if (!checkFuel()) {

            while(true) {
                try {
                    int fuel = scanner.nextInt();

                    if(validator.checkNumNegative(fuel)){
                        calculateFuel(fuel);
                        break;
                    }

                } catch (InputMismatchException e){
                    System.out.println("\n잘못된 입력입니다.\n");
                }

            }
        }

        while(true) {
            int chargeMoney = scanner.nextInt();

            if(calculateMoney(chargeMoney))
                break;
        }
    }

    @Override
    public boolean checkFuel() {
        if(motorizedVehicle.getFuel() != 100) {
            System.out.println("현재 연료 : " + motorizedVehicle.getFuel());
            System.out.print("주유할 연료를 입력하세요 : ");
            return false;
        }

        System.out.println("연료가 가득 찬 상태이므로 주유가 불가능합니다.");
        return true;
    }

    //연료 충전
    @Override
    public synchronized void calculateFuel(int fuel) {

        if(fuel > motorizedVehicle.getMax() - motorizedVehicle.getFuel()) {
            System.out.println("\n주유 가능 연료보다 많이 입력하셨습니다. 가득 채우겠습니다.");
            System.out.println("주유할 연료 : " + (motorizedVehicle.getMax()-motorizedVehicle.getFuel()) + "L");
            totalMoney = (motorizedVehicle.getMax()-motorizedVehicle.getFuel()) * motorizedVehicle.getPriceFuel();
            System.out.println("리터당 " + motorizedVehicle.getPriceFuel() + "원, 총 " + totalMoney + "원 입니다.");
            motorizedVehicle.setFuel(motorizedVehicle.getMax());
        }
        else {
            System.out.println("\n주유할 연료 : " + fuel + "L");
            totalMoney = fuel * motorizedVehicle.getPriceFuel();
            System.out.println("리터당 " + motorizedVehicle.getPriceFuel() + "원, 총 " + totalMoney + "원 입니다.");
            motorizedVehicle.setFuel(motorizedVehicle.getFuel() + fuel);
        }

        ChargePercent chargePercent = new ChargePercent();
        chargePercent.start();

        try {
            chargePercent.join();
        } catch (InterruptedException e){
        }

        System.out.println("주유 후 연료 : " + motorizedVehicle.getFuel() + "L\n");
        System.out.println("지불할 금액을 입력하세요. : ");

    }

    //사용자가 입력한 금액으로 계산
    @Override
    public boolean calculateMoney(int money) {

        if(totalMoney > money) {
            System.out.println("\n대여 요금보다 적게 입력하셨습니다.");
            System.out.println("대여 요금보다 이상의 금액을 입력해주세요.");
            System.out.print("지불하실 요금을 입력해주세요 : ");

            return false;
        }

        System.out.println("\n지불하신 금액은 " + money + "원 입니다.");
        System.out.println("거스름돈은 " + (money - totalMoney) + "원 입니다.");

        System.out.println("감사합니다.");

        return true;

    }
}
