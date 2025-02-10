import domain.*;
import domain.Choice.Choice_Behavior;
import domain.Choice.Choice_Vehicle;
import domain.Motorized.ElectronicCar;
import domain.Motorized.GasolineCar;
import domain.Motorized.ElectronicBicycle;
import domain.NonMotorized.NormalBicycle;
import domain.User.Cashier;
import domain.User.Customer;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        int choice_car; //차 선택
        int fuel;   //충전할 양
        int time;   //렌트할 시간
        int choice_behavior;    //차량 행동 선택
        int money_rent; //지불할 렌트비
        int age;    //대여하는 사람 나이
        String name;    //대여하는 사람 이름
        String product;


        GasolineCar nomalCar = new GasolineCar();
        ElectronicCar electronicCar = new ElectronicCar();
        NormalBicycle circle = new NormalBicycle();
        ElectronicBicycle electronicBicycle = new ElectronicBicycle();

        Validator validator = new Validator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("안녕하세요, 이동 수단 대여점입니다.");
        System.out.println("어떤 이동 수단을 대여하시겠습니까?");

        //차량 선택
        while(true){
            System.out.println("가솔린차 : 1");
            System.out.println("전기차 : 2");
            System.out.println("일반 자전거 : 3");
            System.out.println("전기 자전거 : 4");

            try{
                //이동 수단 선택
                System.out.print("번호 입력 : ");
                choice_car = Integer.parseInt(br.readLine());

                //입력한 번호가 대칭되는 이동수단 매칭
                Choice_Vehicle choiceVehicle = Choice_Vehicle.fromChoice(choice_car);

                //선택지 외 번호 입력할 경우
                if(choiceVehicle == null){
                    System.out.println("\n보기에 있는 선택지를 고르세요.\n");
                    continue;
                }

                //사용자 나이 입력
                System.out.print("나이를 입력하세요 : ");
                age = Integer.parseInt(br.readLine());

                //입력값이 0 또는 음수인지 확인
                if(!validator.checkNumNegative(age))
                    continue;

                //10살 미만 제한
                if(!validator.checkRentCircle(age))
                    continue;

                if(choiceVehicle.name().equals("GASOLINECAR") || choiceVehicle.name().equals("ELECTRONICCAR"))
                        //20세 미만은 자전거 종류만 대여 가능
                        if (!validator.checkRentCarAge(age))
                            continue;

                //대여 시간
                System.out.print("대여 시간을 입력해주세요 : ");
                time = Integer.parseInt(br.readLine());

                //입력값이 0 또는 음수인지 확인
                if(!validator.checkNumNegative(time))
                    continue;

                //대여자 이름
                System.out.print("대여자의 이름을 입력하세요 : ");
                name = br.readLine();

                //이름 유효성 검사(한글, 영어만 입력)
                if(!validator.checkName(name))
                    continue;

                //이동 수단명 저장
                product = choiceVehicle.name();
                break;

            } catch (NumberFormatException e) { //parseInt로 정수형 받기 때문에 문자열 입력하면 예외
                System.out.println("\n잘못된 입력 형식으로 이전 단계로 돌아갑니다.\n");
            }

        }

        //손님 객체 생성(손님 정보 입력)
        Customer customer = new Customer(age, name, time);

        //렌트비 계산할 직원 객체 생성
        Cashier cashier = new Cashier(customer);

        //행동 선택
        while(true) {

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

            try{
                choice_behavior = Integer.parseInt(br.readLine());
                //선택지 올바른지 검사
                if(!validator.checkBehavior(choice_behavior))
                    continue;

                //입력한 선택지 정수값 열거형으로 저장된 값으로 변경
                Choice_Behavior choiceBehavior = Choice_Behavior.fromChoice(choice_behavior);

                if(choiceBehavior == null) {
                    System.out.println("\n보기에 있는 선택지를 고르세요.\n");
                    continue;
                }

                //Choice_Behavior형을 String형으로 변경
                String behavior = String.valueOf(choiceBehavior);

                switch (behavior) {

                    //주유 선택
                    case "CHARGE" :
                        switch (product){
                            case "GASOLINECAR" :
                                if (nomalCar.checkFuel() == 1) {
                                    fuel = Integer.parseInt(br.readLine());
                                    nomalCar.chargeFuel(fuel);
                                }
                                break;
                            case "ELECTRONICCAR" :
                                if (electronicCar.checkFuel() == 1) {
                                    fuel = Integer.parseInt(br.readLine());
                                    electronicCar.chargeFuel(fuel);
                                }
                                break;
                            case "NOMALCIRCLE" :
                                System.out.println("일반 자전거는 사용 불가능한 옵션입니다.");
                                break;
                            case "ELECTRONICCIRCLE" :
                                if (electronicBicycle.checkFuel() == 1) {
                                    fuel = Integer.parseInt(br.readLine());
                                    electronicBicycle.chargeFuel(fuel);
                                }
                                break;
                        }
                        break;

                        //시동 켜기 선택
                    case "ON" :
                        switch (product){
                            case "GASOLINECAR" :
                                nomalCar.onEngine();
                                break;
                            case "ELECTRONICCAR" :
                                electronicCar.onEngine();
                                break;
                            case "NOMALCIRCLE" :
                                System.out.println("일반 자전거는 사용 불가능한 옵션입니다.");
                                break;
                            case "ELECTRONICCIRCLE" :
                                electronicBicycle.onEngine();
                                break;
                        }
                        break;

                    //시동 끄기
                    case "OFF" :
                        switch (product){
                            case "GASOLINECAR" :
                                nomalCar.offEngine();
                                break;
                            case "ELECTRONICCAR" :
                                electronicCar.offEngine();
                                break;
                            case "NOMALCIRCLE" :
                                System.out.println("일반 자전거는 사용 불가능한 옵션입니다.");
                                break;
                            case "ELECTRONICCIRCLE" :
                                electronicBicycle.offEngine();
                                break;
                        }
                        break;

                        //앞으로 가기
                    case "GO" :
                        switch (product){
                            case "GASOLINECAR" :
                                nomalCar.goMove();
                                break;
                            case "ELECTRONICCAR" :
                                electronicCar.goMove();
                                break;
                            case "NOMALCIRCLE" :
                                circle.goMove();
                                break;
                            case "ELECTRONICCIRCLE" :
                                electronicBicycle.goMove();
                                break;
                        }
                        break;

                        //뒤로 가기
                    case "BACK" :
                        switch (product){
                            case "GASOLINECAR" :
                                nomalCar.backMove();
                                break;
                            case "ELECTRONICCAR" :
                                electronicCar.backMove();
                                break;
                            case "NOMALCIRCLE" :
                                circle.backMove();
                                break;
                            case "ELECTRONICCIRCLE" :
                                electronicBicycle.backMove();
                                break;
                        }
                        break;

                        //자동 운전
                    case "AUTOMOVE" :
                        if(!product.equals("ELECTRONICCAR"))
                            System.out.println("자동 운전 옵션은 전기차만 가능합니다.");

                        else
                            electronicCar.autoMove();

                        break;

                        //자동 주차
                    case "AUTOPARKING" :
                        if(!product.equals("ELECTRONICCAR"))
                            System.out.println("자동 주차 옵션은 전기차만 가능합니다.");

                        else
                            electronicCar.autoParking();

                        break;

                        //대여자 정보 확인
                    case "SHOWUSER" :
                        customer.show(product);
                        break;

                        //반납
                    case "RETURN" :
                        switch (product){
                            case "GASOLINECAR" :
                                cashier.checkMoney(nomalCar.getMax() - nomalCar.getFuel(), nomalCar.getPriceFuel(), nomalCar.getMoney());
                                break;
                            case "ELECTRONICCAR" :
                                cashier.checkMoney(nomalCar.getMax() - electronicCar.getFuel(), electronicCar.getPriceFuel(), electronicCar.getMoney());
                                break;
                            case "NOMALCIRCLE" :
                                cashier.checkMoney(circle.getMoney());
                                break;
                            case "ELECTRONICCIRCLE" :
                                cashier.checkMoney(electronicBicycle.getMax() - electronicBicycle.getFuel(), electronicBicycle.getPriceFuel(), electronicBicycle.getMoney());
                                break;
                        }

                        while(true) {
                            money_rent = Integer.parseInt(br.readLine());   //사용자가 지불할 돈
                            int result = cashier.calculate(money_rent);     //총 금액보다 적게 냈는지 확인

                            if(result == 1)
                                break;
                        }
                        return;

                }
            } catch (NumberFormatException e){  //옵션 숫자가 아닌 것을 입력할 경우
                System.out.println("\n잘못된 입력입니다.\n");
            }

        }
    }


}