package domain;

public class Cashier {

    private int money;
    private int time;
    private int remainFuelMoney;
    private int totalRentMoney;
    private int age;
    private String name;
    private String product;

    public Cashier() {
        this.remainFuelMoney = 0;
        this.totalRentMoney = 0;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setRemainFuelMoney(int remainFuelMoney) {
        this.remainFuelMoney = remainFuelMoney;
    }

    public void setTotalRentMoney(int totalRentMoney) {
        this.totalRentMoney = totalRentMoney;
    }

    public void setAge(int age) { this.age = age; }

    public void setName(String name) { this.name = name; }

    public void setProduct(String product) { this.product = product; }

    public int getTotalRentMoney() { return totalRentMoney; }

    public int getRemainFuelMoney() { return remainFuelMoney; }

    public int getMoney() { return money; }

    public int getTime() { return time; }

    public int getAge() { return age; }

    public String getName() { return name; }

    public String getProduct() { return product; }

    public void checkMoney() {
        System.out.println("총 " + getTime() + "시간을 대여하셨습니다.");
        System.out.println("시간 당 " + getMoney() + "원 입니다.");
        setTotalRentMoney(getMoney()*getTime());
        System.out.println("대여 요금은 " + getTotalRentMoney() + "원 입니다.");
        System.out.println("총 요금은 " + (getTotalRentMoney() + getRemainFuelMoney()) + "원 입니다.");
        System.out.print("지불하실 요금을 입력해주세요 : ");
    }

    public void checkMoney(int fuel, int priceFuel) {
        System.out.println("총 " + getTime() + "시간을 대여하셨습니다.");
        System.out.println("시간 당 " + getMoney() + "원 입니다.");
        setTotalRentMoney(getMoney()*getTime());
        System.out.println("대여 요금은 " + getTotalRentMoney() + "원 입니다.");

        if(fuel > 0){
            setRemainFuelMoney(fuel*priceFuel);
            System.out.println("주유를 하지 않아 주유비가 추가됩니다.");
            System.out.println("현재 남은 연료 : " + fuel + ", 완충까지 필요한 연료 : " + (100 - fuel));
            System.out.println("총 주유비 " + getRemainFuelMoney() + "원 입니다.");

        }
        System.out.println("총 요금은 " + (getTotalRentMoney() + getRemainFuelMoney()) + "원 입니다.");
        System.out.print("지불하실 요금을 입력해주세요 : ");
    }

    public int calculate(int money_rent) {
        if(getTotalRentMoney() + getRemainFuelMoney() > money_rent) {
            System.out.println("대여 요금보다 적게 입력하셨습니다.");
            System.out.println("대여 요금보다 이상의 금액을 입력해주세요.");

            return -1;
        }

        System.out.println("지불하신 금액은 " + money_rent + "원 입니다.");
        System.out.println("거스름돈은 " + (money_rent - getTotalRentMoney() - getRemainFuelMoney()) + "원 입니다.");
        System.out.println("감사합니다.");

        return 1;

    }

    public void show() {
        System.out.println("대여자 정보");
        System.out.println("대여자 이름 : " + getName());
        System.out.println("대여자 연령 : " + getAge());
        System.out.println("대여 시간 : " + getTime());
        System.out.println("대여 제품 : " + getProduct());
    }
}
