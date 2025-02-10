package domain.User;

public class Customer {

    private int age;    //대여자 나이
    private String name;    //대여자 이름
    private int time;   //대여한 시간

    public Customer(int age, String name, int time){
        this.age = age;
        this.name = name;
        this.time = time;
    }

    public int getTime() { return time; }

    public int getAge() { return age; }

    public String getName() { return name; }

    //대여자 정보 확인
    public void show(String product) {
        System.out.println("====================================");
        System.out.println("대여자 정보");
        System.out.println("대여자 이름 : " + getName());
        System.out.println("대여자 연령 : " + getAge());
        System.out.println("대여 시간 : " + getTime());
        System.out.println("대여 제품 : " + product);
        System.out.println("====================================");
    }
}
