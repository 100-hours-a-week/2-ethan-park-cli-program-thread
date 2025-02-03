package domain.Car;

public class ElectronicCar extends GasolineCar {

    public ElectronicCar() {
        super(500, 5, 15000);
    }

    public int autoMove() {
        if(getStartup()) {
            if(getFuel() > 0) {
                System.out.println("\n자동 운전을 선택하셨습니다.");
                System.out.println("배터리가 3만큼 감소합니다.\n");
                setFuel(getFuel() - 3);
                return 1;
            }
            else
                lackFuel();
        }
        else{
            warning();
        }

        return -1;
    }

    public int autoParking() {
        if(getStartup()) {
            if(getFuel() > 0) {
                System.out.println("\n자동 주차를 선택하셨습니다.");
                System.out.println("배터리가 3만큼 감소합니다.\n");
                setFuel(getFuel() - 3);
                return 1;
            }
            else lackFuel();
        }
        else{
            warning();
        }

        return -1;
    }

}
