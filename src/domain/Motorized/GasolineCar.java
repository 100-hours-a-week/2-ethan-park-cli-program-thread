package domain.Motorized;

import domain.AutoMove;

import java.util.Scanner;

public class GasolineCar extends MotorizedVehicle implements ChargeFuel {

    public GasolineCar(){
        super(1000, 10, 10000);
    }

    public void goMove() {

        if(getEngine()) {
            System.out.println("\n앞으로 이동합니다.");
            if (getFuel() > 0) {

                setFuel(getFuel()-getUseFuel());
                System.out.println("연료(배터리)가 " + getUseFuel() + "만큼 감소 했습니다.");
                System.out.println("현재 연료(배터리) : " + getFuel() + "\n");
            }
            else
                lackFuel();
        }
        else
            warning();
    }

    //뒤로 이동
    public void backMove() {
        if(getEngine()) {
            System.out.println("\n뒤로 이동합니다.");

            System.out.println("\n앞으로 이동합니다.");

            if (getFuel() > 0) {
                setFuel(getFuel() - getUseFuel());
                System.out.println("연료(배터리)가 " + getUseFuel() + "만큼 감소 했습니다.");
                System.out.println("현재 연료(배터리) : " + getFuel() + "\n");
            }
            else
                lackFuel();
        }
        else
            warning();
    }

    //주유 전 연료 확인
    @Override
    public int checkFuel(){
        if(getFuel() >= getMax()) {
            System.out.println("\n연료가 다 찼습니다.\n");
            return -1;
        }
        else{
            System.out.println("\n현재 연료 : " + getFuel());
            System.out.println("주유 가능 연료 : " + (getMax() - getFuel()));
        }

        System.out.print("주유할 연료를 입력하세요 : ");

        return 1;
    }

    //연료 충전
    @Override
    public void chargeFuel(int fuel) {

        if(fuel > getMax() - getFuel()) {
            System.out.println("\n주유 가능 연료보다 많이 입력하셨습니다. 가득 채우겠습니다.");
            System.out.println("주유할 연료 : " + (getMax()-getFuel()) + "L");
            System.out.println("리터당 " + getPriceFuel() + "원, 총 " + ((getMax()-getFuel()) * getPriceFuel()) + "원 입니다.");
            setFuel(getMax());
        }
        else {
            System.out.println("\n주유할 연료 : " + fuel + "L");
            System.out.println("리터당 " + getPriceFuel() + "원, 총 " + (fuel * getPriceFuel()) + "원 입니다.");
            setFuel(getFuel() + fuel);
        }
        System.out.println("주유 후 연료 : " + getFuel() + "\n");

    }

}


