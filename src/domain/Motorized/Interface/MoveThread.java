package domain.Motorized.Interface;

//스레드에서 사용
public interface MoveThread {

    public void useFuel();

    public int increaseDistance(int meter);

    public void warningShow();
}
