package domain.Car;

import domain.Vehicle;

public class GasolineCar extends Vehicle {

    private boolean door;

    public void setDoor(boolean door) {
        this.door = door;
    }

    public GasolineCar(){
        super(1000, 10);
    }

    public GasolineCar(int priceFuel, int useFuel){
        super(priceFuel, useFuel);
    }

    public boolean getDoor() {
        return door;
    }

    public void goMove() {
        if(!getDoor()) {
            System.out.println("앞으로 이동합니다.");
            if (getFuel() > 0) {

                setFuel(getFuel()-getUseFuel());
                System.out.println("연료(배터리)가 " + getUseFuel() + "만큼 감소 했습니다.");
                System.out.println("현재 연료(배터리) : " + getFuel());
            }
            else
                lackFuel();
        }
        else
            closedDoor();
    }

    //뒤로 이동
    public void backMove() {
        if(!getDoor()) {
            System.out.println("뒤로 이동합니다.");
            if (getFuel() > 0) {
                setFuel(getFuel() - getUseFuel());
                System.out.println("연료(배터리)가 " + getUseFuel() + "만큼 감소 했습니다.");
                System.out.println("현재 연료(배터리) : " + getFuel());
            }
            else
                lackFuel();
        }
        closedDoor();
    }

    public void closedDoor(){
        System.out.println("문이 열린 상태로는 이동이 불가능합니다.");
    }

    public void lackFuel() {
        System.out.println("연료가 충분하지 않습니다.");
    }

}


