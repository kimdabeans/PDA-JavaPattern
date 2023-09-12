package Observer;


/**
 * ConcreteSubject(구체적인 관찰 대상자) 클래스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class StockExchange implements StockMarket {
    private List<Investor> investors = new ArrayList<>();

    @Override
    public void registerObserver(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeObserver(Investor investor) {
        investors.remove(investor);
    }

    @Override
    public void notifyObservers(String stockName, double price) {
        for (Investor investor : investors) {
            investor.update(stockName, price);
        }
    }
    /**
     * 주식 거래가 이루어질 때, 모든 투자자에게 알리는 메서드
     *
     * @param stockName 주식 이름
     * @param price     주식 가격
     */
    public void tradeStock(String stockName, double price) {
        // 주식 거래가 이루어질 때, 모든 투자자에게 알림
        notifyObservers(stockName, price);
    }
}
