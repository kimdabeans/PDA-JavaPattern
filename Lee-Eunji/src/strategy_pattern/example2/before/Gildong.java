package strategy_pattern.example2.before;

/**
 * Gildong 클래스는 StockTrader를 상속받아 구체적인 주식 거래자인 길동의 거래 전략을 구현합니다.
 */
class Gildong extends StockTrader {
    /**
     * ROE(자기자본이익률)를 기반으로 주식을 구매하는 메서드입니다.
     */
    @Override
    public void buy() {
        System.out.println("by ROE");
    }

    /**
     * 목표 가격에 도달하면 주식을 판매하는 메서드입니다.
     */
    @Override
    public void sell() {
        System.out.println("by target");
    }
}
