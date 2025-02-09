package domain.Motorized;

public interface Move {

    public void goMove();

    public void backMove();

    public void lackFuel();

    public void inforDistance(int beforeFuel);
}
