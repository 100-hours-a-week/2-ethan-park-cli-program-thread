import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int choice_car; //차 선택
        int fuel;   //충전할 양
        int time;   //렌트할 시간
        int choice_behavior;    //차량 행동 선택
        int money_rent; //지불할 렌트비

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("안녕하세요, 차량 대여점입니다.");
        System.out.println("어떤 차를 대여하시겠습니까?");


        //차량 선택
        while(true){
            System.out.println("가솔린차 : 1");
            System.out.println("전기차 : 2");
            System.out.println("일반 자전거 : 3");
            System.out.println("전기 자전거 : 4");
            choice_car = Integer.parseInt(br.readLine());

            if(choice_car >= 1 && choice_car <= 4)
                break;

            System.out.println("보기에 있는 선택지를 고르세요.");
        }

        //대여 시간 입력
        System.out.print("대여 시간을 입력해주세요.");
        time = Integer.parseInt(br.readLine());

        Car nomalCar = new Car();
        ElectronicCar electronicCar = new ElectronicCar();
        Circle circle = new Circle();
        ElectronicCircle electronicCircle = new ElectronicCircle();
        Cashier cashier = new Cashier();

        //렌트비 정산할 cashier 객체에 값 입력
        if(choice_car == 1) {
            cashier.setMoney(10000);
            cashier.setTime(time);
        }
        else if(choice_car == 2){
            cashier.setMoney(15000);
            cashier.setTime(time);
        }
        else if(choice_car == 3){
            cashier.setMoney(2000);
            cashier.setTime(time);
        }
        else{
            cashier.setMoney(4000);
            cashier.setTime(time);
        }

        //행동 선택
        while(true) {
            if (choice_car >= 1 && choice_car <= 4) {
                System.out.println("무엇을 하겠습니까?");
                System.out.println("주유 : 0");
                System.out.println("앞으로 이동 : 1");
                System.out.println("뒤로 이동 : 2");
                System.out.println("자동 주차(전기차만 가능) : 3");
                System.out.println("자동 주차(전기차만 가능) : 4");
                System.out.println("반납 : 5");

                choice_behavior = Integer.parseInt(br.readLine());

                switch (choice_behavior) {
                    case 0 :
                        if(choice_car == 1) {
                            if (nomalCar.checkFuel() == 1) {
                                fuel = Integer.parseInt(br.readLine());
                                nomalCar.chargeFuel(fuel);
                            }
                        }
                        else if(choice_car == 2){
                            if (electronicCar.checkFuel() == 1) {
                                fuel = Integer.parseInt(br.readLine());
                                electronicCar.chargeFuel(fuel);
                            }
                        }
                        else if(choice_car == 3){
                            System.out.println("일반 자전거는 주유를 하지 못합니다.");
                        }
                        else{
                            if (electronicCircle.checkFuel() == 1) {
                                fuel = Integer.parseInt(br.readLine());
                                electronicCircle.chargeFuel(fuel);
                            }
                        }
                        break;
                    case 1:
                        if(choice_car == 1)
                            nomalCar.goMove();
                        else if(choice_car == 2)
                            electronicCar.goMove();
                        else if(choice_car == 3)
                            circle.goMove();
                        else
                            electronicCircle.goMove();
                        break;
                    case 2:
                        if(choice_car == 1)
                            nomalCar.backMove();
                        else if(choice_car == 2)
                            electronicCar.backMove();
                        else if(choice_car == 3)
                            circle.backMove();
                        else
                            electronicCircle.backMove();
                        break;
                    case 3 :
                        if(choice_car != 2)
                            System.out.println("자동 운전 옵션은 전기차만 가능합니다.");
                        else
                            electronicCar.autoMove();
                        break;
                    case 4 :
                        if(choice_car != 2)
                            System.out.println("자동 주차 옵션은 전기차만 가능합니다.");
                        else
                            electronicCar.autoParking();
                        break;

                    case 5:
                        if(choice_car == 1) {
                            cashier.checkMoney(nomalCar.getMax() - nomalCar.getFuel(), nomalCar.getPriceFuel());
                        }
                        else if(choice_car == 2){
                            cashier.checkMoney(nomalCar.getMax() - electronicCar.getFuel(), electronicCar.getPriceFuel());
                        }
                        else if(choice_car == 3){
                            cashier.checkMoney();
                        }
                        else {
                            cashier.checkMoney(electronicCircle.getMax() - electronicCircle.getFuel(), electronicCircle.getPriceFuel());
                        }

                        while(true) {
                            money_rent = Integer.parseInt(br.readLine());
                            int result = cashier.calculate(money_rent);

                            if(result == 1)
                                break;
                        }
                        return;
                    default:
                        System.out.println("보기에 있는 선택지를 골라주세요.");
                }
            } else {
                while (true) {
                    System.out.println("제시된 선택지 중 골라주세요.");
                    choice_car = Integer.parseInt(br.readLine());
                    if (choice_car >= 1 && choice_car <= 4)
                        break;
                }
            }
        }
    }
}