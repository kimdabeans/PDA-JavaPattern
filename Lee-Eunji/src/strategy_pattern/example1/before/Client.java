package strategy_pattern.example1.before;

/**
 * 거래 시스템을 사용하는 클라이언트 클래스입니다.
 */
public class Client {

    public static void main(String[] args) {

        TradingSystem tradingSystem = new TradingSystem();

        // 주식(Stock) 전략을 선택하고 실행합니다.
        tradingSystem.setStrategy(TradingSystem.STOCK);
        tradingSystem.executeTrading();

        // 선물(Futures) 전략을 선택하고 실행합니다.
        tradingSystem.setStrategy(TradingSystem.FUTURES);
        tradingSystem.executeTrading();
    }
}
