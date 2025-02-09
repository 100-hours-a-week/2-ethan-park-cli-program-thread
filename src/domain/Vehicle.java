package domain;

public class Vehicle{

    private int money;
    private int move_totalDistance;
    private int move_oneDistnace;

    public Vehicle(int money, int move_oneDistnace){
        this.money = money;
        this.move_oneDistnace = move_oneDistnace;
    }

    public int getMoney() { return money; }

    public int getMove_oneDistnace() { return move_oneDistnace; }

    public int getMove_totalDistance() { return move_totalDistance; }

    public void setMove_totalDistance(int move_totalDistance) { this.move_totalDistance = move_totalDistance; }

    public void goMove() {
        System.out.println("\n앞으로 이동합니다.\n");
    }

    public void backMove() throws InterruptedException {
        System.out.println("\n뒤로 이동합니다.\n");
    }

}