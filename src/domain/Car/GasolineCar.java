package domain.Car;

import domain.Vehicle;

public class GasolineCar extends Vehicle {

    private boolean startUp = false;

    public GasolineCar(){
        super(1000, 10, 10000);
    }

    public GasolineCar(int priceFuel, int useFuel, int money){
        super(priceFuel, useFuel, money);
    }

    public boolean getStartup() {
        return startUp;
    }

    public void goMove() {
        if(getStartup()) {
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
        if(getStartup()) {
            System.out.println("\n뒤로 이동합니다.");
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

    public void lackFuel() {
        System.out.println("\n연료가 충분하지 않습니다.\n");
    }

    public void onCar() {
        if(!getStartup()){
            System.out.println("\n시동이 켜졌습니다.\n");
            this.startUp = true;
        }
        else{
            System.out.println("\n이미 시동이 켜졌습니다.\n");
        }
    }

    public void offCar() {
        if(getStartup()){
            System.out.println("\n시동이 꺼졌습니다.\n");
            this.startUp = false;
        }
        else{
            System.out.println("\n이미 시동이 꺼졌습니다.\n");
        }
    }

    public void warning() {
        System.out.println("\n시동이 켜진 상태에서 이용해주세요.\n");
    }

}


