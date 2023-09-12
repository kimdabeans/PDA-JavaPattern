package Strategy;

import java.util.Random;
/**
 * 투자 전략에 따라 주어진 호가에 맞춰 투자하는 것을 구현한 Strategy 패턴을 사용하는 서비스의 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Trader trader1 = new Trader("Ojun", new PassiveInvestmentTradingStrategy(),10000);
        Trader trader2 = new Trader("Jordan", new ActiveInvestmentTradingStrategy(),10000);
        int previousStockPrice = 0;

        for (int i = 0; i < 10; i++) {
            int stockPrice = new Random().nextInt((10000 - 0) / 2000 + 1) * 2000;
            //랜덤으로 주식 호가
            System.out.println("Stock Price is " + stockPrice);
            Trade trade1 = trader1.nextTrade(previousStockPrice, stockPrice);
            Trade trade2 = trader2.nextTrade(previousStockPrice, stockPrice);

            trader1.trade(trade1, stockPrice);
            trader2.trade(trade2, stockPrice);

            previousStockPrice = stockPrice;

            trader1.setBalance(trader1.getBalance());
            trader2.setBalance(trader2.getBalance());
            trader1.printProperty();
            trader2.printProperty();
            System.out.println();
        }
    }
}
