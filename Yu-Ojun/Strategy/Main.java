package Strategy;

import java.util.Random;

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
            //살까 말까 결정

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
