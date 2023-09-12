package strategy_pattern.example1.after;

/**
 * 이 클래스는 매매 전략 시스템을 사용하는 클라이언트 예제를 제공합니다.
 */
public class Client {
    public static void main(String[] args) {
        TradingSystem tradingSystem = new TradingSystem();

        // 주식 매매 전략 사용
        tradingSystem.setStrategy(new StockTradingStrategy());
        tradingSystem.executeTrading();

        // 선물 매매 전략 사용
        tradingSystem.setStrategy(new FuturesTradingStrategy());
        tradingSystem.executeTrading();

        // 옵션 매매 전략 사용
        tradingSystem.setStrategy(new OptionsTradingStrategy());
        tradingSystem.executeTrading();
    }
}
