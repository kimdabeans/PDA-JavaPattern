package observer;

/**
 * StockObserver 인터페이스는 주식 관찰자(Observer)의 행동을 정의합니다.
 */
public interface StockObserver {
    /**
     * 주식 가격이 변경될 때 호출되는 메서드입니다.
     *
     * @param price 새로운 주식 가격
     */
    void update(double price);
}