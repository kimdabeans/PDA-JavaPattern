package strategy_pattern.example1.after;

/**
 * 이 클래스는 주어진 매매 전략을 사용하여 매매를 실행하는 데 사용됩니다.
 */
public class TradingSystem {
    private TradingStrategy strategy;

    /**
     * 사용할 매매 전략을 설정합니다.
     *
     * @param strategy 사용할 매매 전략 객체
     */
    public void setStrategy(TradingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 현재 설정된 매매 전략을 실행합니다.
     */
    public void executeTrading() {
        strategy.executeStrategy();
        // 다른 공통 로직을 수행합니다.
    }
}
