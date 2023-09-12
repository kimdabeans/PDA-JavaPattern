package Observer;

/**
 * 
 * Subject(주체) 역할을 하는 인터페이스이다.
 * registerObserver, removeObserver, notifyObservers 메서드를 정의하며,이 메서드들을 구현하여 관찰자(Investor) 객체들을 등록한다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public interface StockMarket {
    /**
     * Observer를 등록하는 메서드
     *
     * @param investor Observer로 등록할 Investor 객체
     */
    void registerObserver(Investor investor);
    /**
     * Observer를 제거하는 메서드
     *
     * @param investor Observer로부터 제거할 Investor 객체
     */
    void removeObserver(Investor investor);    
    /**
    * Observer들에게 주식 가격 업데이트를 알리는 메서드
    *
    * @param stockName 주식 이름
    * @param price     주식 가격
    */
    void notifyObservers(String stockName, double price);
}
