package domain.Car;

import domain.Vehicle;

public class GasolineCar extends Vehicle {

    public GasolineCar(){
        super(1000, 10, 10000);
    }

    public GasolineCar(int priceFuel, int useFuel, int money){
        super(priceFuel, useFuel, money);
    }




}


