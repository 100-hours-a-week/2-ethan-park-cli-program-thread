package domain.Circle;

import domain.Vehicle;

public class NormalCircle extends Vehicle {

    //일반 자전거는 연료 부분 0으로 설정, 대여비 2000원
    public NormalCircle() { super(0, 0, 2000); }

    public NormalCircle(int priceFuel, int useFuel, int money) {
        super(priceFuel, useFuel, money);
    }

    public void goMove() {
        System.out.println("\n앞으로 이동합니다.\n");
    }

    public void backMove() {
        System.out.println("\n뒤로 이동합니다.\n");
    }

}
