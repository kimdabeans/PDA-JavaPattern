package strategy_pattern.example2.after;

/**
 * 길동의 주식 거래자 클래스입니다.
 *
 * @author Lee Eunji
 */
class Gildong extends StockTrader {
    /**
     * Gildong 객체를 초기화하는 생성자입니다.
     *
     * @param buyStrategy  주식 매수 전략
     * @param sellStrategy 주식 매도 전략
     */
    public Gildong(BuyStrategy buyStrategy, SellStrategy sellStrategy) {
        super(buyStrategy, sellStrategy);
    }
}
