package strategy_pattern.example1.after;

/**
 * 이 인터페이스는 다양한 매매 전략을 구현하는 데 사용됩니다.
 * 구체적인 전략 클래스는 executeStrategy() 메소드를 구현해야 합니다.
 */
public interface TradingStrategy {
    /**
     * 현재 전략을 실행합니다.
     */
    public abstract void executeStrategy();
}
