package domain.Choice;

public enum Choice_Behavior {
    CHARGE(0), ON(1), OFF(2), GO(3), BACK(4), AUTOMOVE(5), AUTOPARKING(6), SHOWUSER(7), RETURN(8);

    private int choice;

    Choice_Behavior(int choice) {
        this.choice = choice;
    }

    public int getChoice() { return choice; }

    public static Choice_Behavior fromChoice (int choice_user) {
        for (Choice_Behavior choiceBehavior : Choice_Behavior.values()) {
            if (choiceBehavior.getChoice() == choice_user) {
                return choiceBehavior;
            }
        }
        return null; // 예외 처리를 위해 null 반환
    }

    public static void choiceMenu () {
        System.out.println("====================================");
        System.out.println("무엇을 하겠습니까?");
        System.out.println("주유/충전 : 0");
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
    }

}
