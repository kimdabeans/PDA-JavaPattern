package observer;

/**
 * StockSubject 인터페이스는 주식 가격 주제(Subject)의 행동을 정의합니다.
 */
public interface StockSubject {
    /**
     * 주식 관찰자(Observer)를 등록합니다.
     *
     * @param observer 등록할 주식 관찰자 객체
     */
    void registerObserver(StockObserver observer);

    /**
     * 주식 관찰자(Observer)의 등록을 취소합니다.
     *
     * @param observer 취소할 주식 관찰자 객체
     */
    void removeObserver(StockObserver observer);

    /**
     * 주식 가격이 변경될 때 등록된 모든 주식 관찰자에게 알립니다.
     *
     * @param price 새로운 주식 가격
     */
    void notifyObservers(double price);
}