package strategy_pattern.example2.after;

/**
 * 주식 거래 전략을 정의하는 인터페이스입니다.
 */
public interface BuyStrategy {
    /**
     * 매수 전략을 실행합니다.
     */
    public abstract void buy();
}
