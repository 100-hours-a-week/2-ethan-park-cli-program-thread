public class ElectronicCar extends Car {

    public ElectronicCar() {
        super(500, 5);
    }

    public void autoMove() {
        System.out.println("자동 운전을 선택하셨습니다.");
        System.out.println("연료(배터리)가 15 감소합니다.");
        setFuel(getFuel() - 15);
    }

    public void autoParking() {
        System.out.println("자동 주차를 선택하셨습니다.");
        System.out.println("연료(배터리)가 3만큼 감소합니다.");
        setFuel(getFuel() - 3);
    }
}
