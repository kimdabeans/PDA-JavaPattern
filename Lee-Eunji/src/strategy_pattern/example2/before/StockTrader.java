package strategy_pattern.example2.before;

/**
 * 추상 클래스 StockTrader는 주식 거래자의 기본 틀을 제공합니다.
 * 실제 주식 거래자 클래스는 이 클래스를 상속받아 구체적인 거래 전략을 구현해야 합니다.
 */

public abstract class StockTrader {
    /**
     * 주식을 구매하는 추상 메서드입니다.
     * 구체적인 거래 전략은 하위 클래스에서 구현되어야 합니다.
     */
    public abstract void buy();

    /**
     * 주식을 판매하는 메소드입니다.
     * 구체적인 판매 전략은 각 서브클래스에서 구현되어야 합니다.
     */
    public abstract void sell();
}
