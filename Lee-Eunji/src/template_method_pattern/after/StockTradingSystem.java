package template_method_pattern.after;

/**
 * 주식 거래 시스템 시뮬레이션을 위한 클래스입니다.
 * 이 클래스는 매수 및 매도 주문을 생성하고 실행하여 주식 거래를 시뮬레이션합니다.
 *
 * @author Lee Eunji
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
