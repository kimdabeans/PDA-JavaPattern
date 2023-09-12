package strategy_pattern.example1.after;

/**
 * 주식 매매 전략을 나타내는 구체적인 클래스입니다.
 */

public class StockTradingStrategy implements TradingStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("주식 매매 전략을 실행합니다.");
        // 주식 매매에 대한 구체적인 로직을 구현합니다.
    }
}
