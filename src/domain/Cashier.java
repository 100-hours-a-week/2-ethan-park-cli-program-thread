package domain;

public class Cashier {

    private int remainFuelMoney;    //추가 주유비
    private int totalRentMoney;     //총 대여비
    private Customer customer;

    public Cashier(Customer customer) { this.customer = customer; }

    public void setRemainFuelMoney(int remainFuelMoney) {
        this.remainFuelMoney = remainFuelMoney;
    }

    public void setTotalRentMoney(int totalRentMoney) {
        this.totalRentMoney = totalRentMoney;
    }

    public int getTotalRentMoney() { return totalRentMoney; }

    public int getRemainFuelMoney() { return remainFuelMoney; }

    //총 금액 확인
    public void checkMoney(int fuel, int priceFuel, int money) {
        System.out.println("\n총 " + customer.getTime() + "시간을 대여하셨습니다.");
        System.out.println("시간 당 " + money + "원 입니다.");
        setTotalRentMoney(money*customer.getTime());
        System.out.println("대여 요금은 " + getTotalRentMoney() + "원 입니다.");

        if(fuel > 0){
            setRemainFuelMoney(fuel*priceFuel);
            System.out.println("\n주유를 하지 않아 주유비가 추가됩니다.");
            System.out.println("현재 남은 연료 : " + fuel + ", 완충까지 필요한 연료 : " + (100 - fuel));
            System.out.println("총 주유비 " + getRemainFuelMoney() + "원 입니다.\n");

        }
        System.out.println("총 요금은 " + (getTotalRentMoney() + getRemainFuelMoney()) + "원 입니다.");
        System.out.print("지불하실 요금을 입력해주세요 : ");
    }


    //사용자가 입력한 금액으로 계산
    public int calculate(int money_rent) {
        if(getTotalRentMoney() + getRemainFuelMoney() > money_rent) {
            System.out.println("\n대여 요금보다 적게 입력하셨습니다.");
            System.out.println("대여 요금보다 이상의 금액을 입력해주세요.");
            System.out.print("지불하실 요금을 입력해주세요 : ");

            return -1;
        }

        System.out.println("\n지불하신 금액은 " + money_rent + "원 입니다.");
        System.out.println("거스름돈은 " + (money_rent - getTotalRentMoney() - getRemainFuelMoney()) + "원 입니다.");
        System.out.println("감사합니다.");

        return 1;

    }

}
