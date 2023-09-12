package template_method_pattern.after;

/**
 * 주식 거래 시스템을 시뮬레이션하는 클래스입니다.
 */
public class StockTradingSystem {
    public static void main(String[] args) {
        // 매수 주문
        AbstractOrder buyOrder = new BuyOrder("AAPL", 100, 150.0);
        buyOrder.executeOrder();

        // 매도 주문
        AbstractOrder sellOrder = new SellOrder("GOOGL", 50, 2500.0);
        sellOrder.executeOrder();
    }
}
