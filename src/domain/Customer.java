package domain;

public class Customer {

    private int age;
    private String name;
    private int time;
    private String product;

    public Customer(int age, String name, int time){
        this.age = age;
        this.name = name;
        this.time = time;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public int getTime() { return time; }

    public int getAge() { return age; }

    public String getName() { return name; }

    public String getProduct() { return product; }

    public void show() {
        System.out.println("====================================");
        System.out.println("대여자 정보");
        System.out.println("대여자 이름 : " + getName());
        System.out.println("대여자 연령 : " + getAge());
        System.out.println("대여 시간 : " + getTime());
        System.out.println("대여 제품 : " + getProduct());
        System.out.println("====================================");
    }
}
