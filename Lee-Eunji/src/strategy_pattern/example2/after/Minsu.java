package strategy_pattern.example2.after;

/**
 * 민수의 주식 거래자 클래스입니다.
 *
 * @author Lee Eunji
 */
class Minsu extends StockTrader {
    /**
     * Minsu 객체를 초기화하는 생성자입니다.
     *
     * @param buyStrategy  주식 매수 전략
     * @param sellStrategy 주식 매도 전략
     */
    public Minsu(BuyStrategy buyStrategy, SellStrategy sellStrategy) {
        super(buyStrategy, sellStrategy);
    }
}
