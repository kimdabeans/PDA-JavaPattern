package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * StockMarket 클래스는 주식 가격 주제(Subject)를 구현합니다.
 */
public class StockMarket implements StockSubject {
    private List<StockObserver> observers = new ArrayList<>();
    private double currentPrice;

    /**
     * 주식 관찰자(Observer)를 등록합니다.
     *
     * @param observer 등록할 주식 관찰자 객체
     */
    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    /**
     * 주식 관찰자(Observer)의 등록을 취소합니다.
     *
     * @param observer 취소할 주식 관찰자 객체
     */
    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    /**
     * 주식 가격이 변경될 때 등록된 모든 주식 관찰자에게 알립니다.
     *
     * @param price 새로운 주식 가격
     */
    @Override
    public void notifyObservers(double price) {
        for (StockObserver observer : observers) {
            observer.update(price);
        }
    }

    /**
     * 주식 가격을 업데이트하고 관련된 주식 관찰자들에게 알립니다.
     *
     * @param newPrice 새로운 주식 가격
     */
    public void updateStockPrice(double newPrice) {
        currentPrice = newPrice;
        notifyObservers(newPrice);
    }
}