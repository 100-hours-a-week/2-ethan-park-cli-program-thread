package domain.Circle;

import domain.Vehicle;

public class NormalCircle extends Vehicle {

    private boolean door;

    public NormalCircle() { super(0, 0, 2000); }

    public NormalCircle(int priceFuel, int useFuel, int money) {
        super(priceFuel, useFuel, money);
    }

}
