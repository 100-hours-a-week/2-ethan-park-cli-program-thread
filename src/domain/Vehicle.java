package domain;

public class Vehicle{

    private final int Max = 100;

    private int fuel;   //현재 연료
    private int priceFuel;  //연료 리터당 가격
    private int useFuel;    //동작 시 연료 사용
    private int money;
    private boolean engine = false;

    public Vehicle(int priceFuel, int useFuel, int money){
        this.fuel = 100;
        this.priceFuel = priceFuel;
        this.useFuel = useFuel;
        this.money = money;
    }

    public void setFuel(int fuel) { this.fuel = fuel; }

    public int getFuel() { return fuel; }

    public int getPriceFuel() { return priceFuel; }

    public int getUseFuel() { return useFuel; }

    public int getMax() { return Max; }

    public int getMoney() { return money; }

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

    //주유 전 연료 확인
    public int checkFuel(){
        if(getFuel() >= Max) {
            System.out.println("\n연료(배터리)가 다 찼습니다.\n");
            return -1;
        }
        else{
            System.out.println("\n현재 연료(배터리) : " + getFuel());
            System.out.println("주유(충전) 가능 연료(배터리) : " + (Max - getFuel()));
        }

        System.out.print("주유(충전)할 연료(배터리)를 입력하세요 : ");

        return 1;
    }

    //연료 충전
    public void chargeFuel(int fuel) {

        if(fuel > Max - getFuel()) {
            System.out.println("\n주유(충전) 가능 연료(배터리)보다 많이 입력하셨습니다. 가득 채우겠습니다.");
            System.out.println("주유(충전)할 연료(배터리) : " + (Max-getFuel()) + "L(%)");
            System.out.println("리터(퍼센트)당 " + priceFuel + "원, 총 " + ((Max-getFuel()) * priceFuel) + "원 입니다.");
            setFuel(Max);
        }
        else {
            System.out.println("\n주유(충전)할 연료(배터리) : " + fuel + "L(%)");
            System.out.println("리터(퍼센트)당 " + priceFuel + "원, 총 " + (fuel * priceFuel) + "원 입니다.");
            setFuel(getFuel() + fuel);
        }
        System.out.println("주유(충전) 후 연료(배터리) : " + getFuel() + "\n");

    }

}