package domain.NonMotorized;

import java.util.Scanner;

public class NormalCircle extends NonMotorizedVehicle implements Move {

    //일반 자전거는 연료 부분 0으로 설정, 대여비 2000원
    public NormalCircle() { super(2000, 1); }

    @Override
    public void goMove() {
        MoveNonEngine moveNonEngine = new MoveNonEngine(this);

        System.out.println("\n앞으로 이동합니다.");

        moveNonEngine.start();
        Scanner input = new Scanner(System.in);
        System.out.println("자전거를 멈추려면 엔터를 누르세요");

        input.nextLine();
        moveNonEngine.interrupt();

        inforDistance();
    }

    @Override
    public void backMove() {
        MoveNonEngine moveNonEngine = new MoveNonEngine(this);

        System.out.println("\n뒤로 이동합니다.");

        moveNonEngine.start();
        Scanner input = new Scanner(System.in);
        System.out.println("자전거를 멈추려면 엔터를 누르세요");

        input.nextLine();
        moveNonEngine.interrupt();

        inforDistance();
    }

    @Override
    public void inforDistance() {
        System.out.println("금일 이동한 거리는 총 " + getMove_totalDistance() + "m 입니다.");
    }

}
