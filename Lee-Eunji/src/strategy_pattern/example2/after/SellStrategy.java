package strategy_pattern.example2.after;

/**
 * 주식 매도 전략을 정의하는 인터페이스입니다.
 *
 * @author Lee Eunji
 */
public interface SellStrategy {
    /**
     * 매도 작업을 수행하는 메서드입니다.
     */
    public abstract void sell();
}
