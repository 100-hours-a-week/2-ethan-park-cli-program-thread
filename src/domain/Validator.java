package domain;

public class Validator {

    public boolean checkNumNegative(int num) {
        if(num <= 0){
            System.out.println("0 또는 음수는 허용되지 않습니다.");
            return false;
        }

        return true;
    }

    public boolean checkRentCircle(int age) {

        if(age < 10){
            System.out.println("최소 대여 나이는 10살입니다.");
            return false;
        }

        return true;
    }

    public boolean checkRentCarAge(int age) {
        if(age < 20) {
            System.out.println("미성년자는 자동차를 대여할 수 없습니다.");
            return false;
        }

        return true;
    }

    public boolean checkBehavior(int behavior) {
        if(!(behavior >= 0 && behavior <=8)){
            System.out.println("보기에 있는 옵션을 선택해주세요.");
            return false;
        }
        return true;
    }

    //이름 형식에 한글, 알파벳만 들어가도록 설정
    public boolean checkName(String name){
        if (!name.matches("[a-zA-Z가-힣]+")) {
            System.out.println("정확한 이름을 작성해주세요.");
            return false;
        }

        return true;
    }

}
