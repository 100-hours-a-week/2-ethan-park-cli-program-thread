package domain.Motorized;

import java.util.Scanner;

public class ElectronicCircle extends MotorizedVehicle implements ChargeFuel, Move {

    public ElectronicCircle() {
        super(200, 1, 4000, 3);
    }

    @Override
    public void goMove() {

        MoveElectronic moveElectronic = new MoveElectronic(this);
        int beforeFuel = getFuel();

        if(!getEngine())
            warning();

        else if(getFuel() == 0)
            lackFuel();

        else {
            System.out.println("\n앞으로 이동합니다.");

            moveElectronic.start();
            Scanner input = new Scanner(System.in);
            System.out.println("이동을 멈추려면 엔터(브레이크)를 누르세요");

            input.nextLine();
            moveElectronic.interrupt();

            inforDistance(beforeFuel);
        }

    }

    //뒤로 이동
    @Override
    public void backMove() {

        MoveElectronic moveElectronic = new MoveElectronic(this);
        int beforeFuel = getFuel();

        if(!getEngine())
            warning();

        else if(getFuel() == 0)
            lackFuel();

        else {
            System.out.println("\n뒤로 이동합니다.");

            moveElectronic.start();
            Scanner input = new Scanner(System.in);
            System.out.println("차량을 멈추려면 엔터를 누르세요");

            input.nextLine();
            moveElectronic.interrupt();

            inforDistance(beforeFuel);
        }

    }

    @Override
    public void lackFuel() {
        System.out.println("\n배터리가 충분하지 않습니다.\n");
    }

    @Override
    public void inforDistance(int beforeFuel) {
        System.out.println("금일 이동한 거리는 총 " + getMove_totalDistance() + "m 입니다.");
        System.out.println("배터리가 " + (beforeFuel - getFuel()) + "만큼 감소 했습니다.");
        System.out.println("현재 배터리 : " + getFuel() + "\n");
    }

    //주유 전 연료 확인
    @Override
    public int checkFuel(){
        if(getFuel() >= getMax()) {
            System.out.println("\n배터리가 다 찼습니다.\n");
            return -1;
        }
        else{
            System.out.println("\n배터리 : " + getFuel());
            System.out.println("충전 가능 배터리 : " + (getMax() - getFuel()));
        }

        System.out.print("충전할 배터리를 입력하세요 : ");

        return 1;
    }

    //연료 충전
    @Override
    public void chargeFuel(int fuel) {

        ChargePercent chargePercent = new ChargePercent();

        if(fuel > getMax() - getFuel()) {
            System.out.println("\n충전 가능 배터리보다 많이 입력하셨습니다. 풀충전하겠습니다.");
            System.out.println("충전할 배터리 : " + (getMax()-getFuel()) + "%");
            System.out.println("퍼센트당 " + getPriceFuel() + "원, 총 " + ((getMax()-getFuel()) * getPriceFuel()) + "원 입니다.");
            setFuel(getMax());
        }
        else {
            System.out.println("\n충전할 배터리 : " + fuel + "%");
            System.out.println("퍼센트당 " + getPriceFuel() + "원, 총 " + (fuel * getPriceFuel()) + "원 입니다.");
            setFuel(getFuel() + fuel);
        }

        chargePercent.start();

        try {
            chargePercent.join();
        } catch (InterruptedException e){
        }

        System.out.println("충전 후 배터리 : " + getFuel() + "%\n");

    }


}