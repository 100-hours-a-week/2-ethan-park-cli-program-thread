package domain.Motorized;

public class ElectronicCar extends MotorizedVehicle implements ChargeFuel {

    public ElectronicCar() {
        super(500, 5, 15000);
    }

    public int autoMove() {
        if(getEngine()) {
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
        if(getEngine()) {
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

    //주유 전 연료 확인
    @Override
    public int checkFuel(){
        if(getFuel() >= getMax()) {
            System.out.println("\n배터리가 다 찼습니다.\n");
            return -1;
        }
        else{
            System.out.println("\n배터리 : " + getFuel());
            System.out.println("충전 가능 배터리 : " + (getMax() - getFuel()));
        }

        System.out.print("충전할 배터리를 입력하세요 : ");

        return 1;
    }

    //연료 충전
    @Override
    public void chargeFuel(int fuel) {

        if(fuel > getMax() - getFuel()) {
            System.out.println("\n충전 가능 배터리보다 많이 입력하셨습니다. 풀충전하겠습니다.");
            System.out.println("충전할 배터리 : " + (getMax()-getFuel()) + "%");
            System.out.println("리터(퍼센트)당 " + getPriceFuel() + "원, 총 " + ((getMax()-getFuel()) * getPriceFuel()) + "원 입니다.");
            setFuel(getMax());
        }
        else {
            System.out.println("\n충전할 배터리 : " + fuel + "%");
            System.out.println("퍼센트당 " + getPriceFuel() + "원, 총 " + (fuel * getPriceFuel()) + "원 입니다.");
            setFuel(getFuel() + fuel);
        }

        System.out.println("충전 후 배터리 : " + getFuel() + "\n");

    }

}
