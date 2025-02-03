import domain.*;
import domain.Car.ElectronicCar;
import domain.Car.GasolineCar;
import domain.Circle.ElectronicCircle;
import domain.Circle.NormalCircle;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int choice_car; //차 선택
        int fuel;   //충전할 양
        int time;   //렌트할 시간
        int choice_behavior;    //차량 행동 선택
        int money_rent; //지불할 렌트비
        int age;    //대여하는 사람 나이
        String name;    //대여하는 사람 이름

        GasolineCar nomalCar = new GasolineCar();
        ElectronicCar electronicCar = new ElectronicCar();
        NormalCircle circle = new NormalCircle();
        ElectronicCircle electronicCircle = new ElectronicCircle();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("안녕하세요, 이동 수단 대여점입니다.");
        System.out.println("어떤 이동 수단을 대여하시겠습니까?");

        //차량 선택
        while(true){
            System.out.println("가솔린차 : 1");
            System.out.println("전기차 : 2");
            System.out.println("일반 자전거 : 3");
            System.out.println("전기 자전거 : 4");
            System.out.print("번호 입력 : ");
            choice_car = Integer.parseInt(br.readLine());

            if(!(choice_car >= 1 && choice_car <= 4)){
                System.out.println("보기에 있는 선택지를 고르세요.");
                continue;
            }

            System.out.print("나이를 입력하세요 : ");
            age = Integer.parseInt(br.readLine());

            //20세 미만은 자전거 종류만 대여 가능
            switch (choice_car) {
                case 1:
                case 2:
                    if (age < 20) {
                        System.out.println("미성년자는 대여가 불가능합니다.");
                        System.out.println("다른 옵션을 선택해주세요");
                        continue;
                    }
            }

            break;
        }

        System.out.print("대여자의 이름을 입력하세요 : ");
        name = br.readLine();

        System.out.print("대여 시간을 입력해주세요 : ");
        time = Integer.parseInt(br.readLine());

        //손님 객체 생성(손님 정보 입력)
        Customer customer = new Customer(age, name, time);

        //렌트비 계산할 직원 객체 생성
        Cashier cashier = new Cashier(customer);

        if(choice_car == 1)
            customer.setProduct("가솔린차");

        else if(choice_car == 2)
            customer.setProduct("전기차");

        else if(choice_car == 3)
            customer.setProduct("자전거");

        else
            customer.setProduct("전기자전거");


        //행동 선택
        while(true) {
            if (choice_car >= 1 && choice_car <= 4) {
                System.out.println("====================================");
                System.out.println("무엇을 하겠습니까?");
                System.out.println("주유 : 0");
                System.out.println("시동 켜기(자동차, 전기자전거만 가능) : 1");
                System.out.println("시동 끄기(자동차, 전기자전거만 가능) : 2");
                System.out.println("앞으로 이동 : 3");
                System.out.println("뒤로 이동 : 4");
                System.out.println("자동 운전(전기차만 가능) : 5");
                System.out.println("자동 주차(전기차만 가능) : 6");
                System.out.println("대여 정보 확인 : 7");
                System.out.println("반납 : 8");
                System.out.println("====================================");
                System.out.print("옵션 선택 : ");

                choice_behavior = Integer.parseInt(br.readLine());

                switch (choice_behavior) {

                    //주유
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

                        //시동 켜기
                    case 1 :

                        if(choice_car == 1)
                            nomalCar.onCar();
                        else if(choice_car == 2)
                            electronicCar.onCar();
                        else if(choice_car == 3)
                            System.out.println("일반 자전거는 사용 불가능한 옵션입니다.");
                        else
                            electronicCircle.onCar();
                        break;

                    //시동 끄기
                    case 2 :
                        if(choice_car == 1)
                            nomalCar.offCar();
                        else if(choice_car == 2)
                            electronicCar.offCar();
                        else if(choice_car == 3)
                            System.out.println("일반 자전거는 사용 불가능한 옵션입니다.");
                        else
                            electronicCircle.offCar();
                        break;

                        //앞으로 가기
                    case 3:
                        if(choice_car == 1)
                            nomalCar.goMove();
                        else if(choice_car == 2)
                            electronicCar.goMove();
                        else if(choice_car == 3)
                            circle.goMove();
                        else
                            electronicCircle.goMove();
                        break;

                        //뒤로 가기
                    case 4:
                        if(choice_car == 1)
                            nomalCar.backMove();
                        else if(choice_car == 2)
                            electronicCar.backMove();
                        else if(choice_car == 3)
                            circle.backMove();
                        else
                            electronicCircle.backMove();
                        break;

                        //자동 운전
                    case 5 :
                        if(choice_car != 2)
                            System.out.println("자동 운전 옵션은 전기차만 가능합니다.");
                        else
                            electronicCar.autoMove();
                        break;

                        //자동 주차
                    case 6 :
                        if(choice_car != 2)
                            System.out.println("자동 주차 옵션은 전기차만 가능합니다.");
                        else
                            electronicCar.autoParking();
                        break;

                        //대여자 정보 확인
                    case 7 :
                        customer.show();
                        break;

                        //반납
                    case 8 :
                        if(choice_car == 1) {
                            cashier.checkMoney(nomalCar.getMax() - nomalCar.getFuel(), nomalCar.getPriceFuel(), nomalCar.getMoney());
                        }
                        else if(choice_car == 2){
                            cashier.checkMoney(nomalCar.getMax() - electronicCar.getFuel(), electronicCar.getPriceFuel(), electronicCar.getMoney());
                        }
                        else if(choice_car == 3){
                            cashier.checkMoney(circle.getMoney());
                        }
                        else {
                            cashier.checkMoney(electronicCircle.getMax() - electronicCircle.getFuel(), electronicCircle.getPriceFuel(), electronicCircle.getMoney());
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
            }
        }
    }
}