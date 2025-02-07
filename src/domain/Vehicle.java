package domain;

public class Vehicle{

    private int money;

    public Vehicle(int money){
        this.money = money;
    }

    public int getMoney() { return money; }

    public void goMove() {
        System.out.println("\n앞으로 이동합니다.\n");
    }

    public void backMove() {
        System.out.println("\n뒤로 이동합니다.\n");
    }

}