package domain.Motorized;

import domain.Motorized.Interface.ChargeFuel;
import domain.Motorized.Interface.Move;
import domain.Motorized.thread.ChargePercent;
import domain.Motorized.thread.MoveElectronic;

import java.util.Scanner;

public class ElectronicBicycle extends MotorizedVehicle implements Move {

    public ElectronicBicycle() {
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

}