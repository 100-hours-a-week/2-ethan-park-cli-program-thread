package domain.Motorized;

import domain.Vehicle;

public class MotorizedVehicle extends Vehicle {

    private final int Max = 100;
    private int fuel;   //현재 연료
    private int priceFuel;  //연료 리터당 가격
    private int useFuel;
    private boolean engine = false;

    public MotorizedVehicle(int priceFuel, int useFuel, int money) {
        super(money);
        this.fuel = 100;
        this.priceFuel = priceFuel;
        this.useFuel = useFuel;
    }


    public void setFuel(int fuel) { this.fuel = fuel; }

    public int getFuel() { return fuel; }

    public int getPriceFuel() { return priceFuel; }

    public int getUseFuel() { return useFuel; }

    public int getMax() { return Max; }

    public boolean getEngine() {
        return engine;
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

    public void onEngine() {
        if(!getEngine()){
            System.out.println("\n시동이 켜졌습니다.\n");
            this.engine = true;
        }
        else{
            System.out.println("\n이미 시동이 켜졌습니다.\n");
        }
    }

    public void offEngine() {
        if(getEngine()){
            System.out.println("\n시동이 꺼졌습니다.\n");
            this.engine = false;
        }
        else{
            System.out.println("\n이미 시동이 꺼졌습니다.\n");
        }
    }

    public void warning() {
        System.out.println("\n시동이 켜진 상태에서 이용해주세요.\n");
    }


}
