package strategy_pattern.example2.after;

/**
 * 주식 거래자를 나타내는 추상 클래스입니다.
 *
 * @author Lee Eunji
 */
public abstract class StockTrader {
    private SellStrategy sellStrategy;
    private BuyStrategy buyStrategy;

    /**
     * StockTrader 클래스를 초기화하는 생성자입니다.
     *
     * @param buyStrategy  주식 매수 전략
     * @param sellStrategy 주식 매도 전략
     */
    public StockTrader(BuyStrategy buyStrategy, SellStrategy sellStrategy) {
        this.buyStrategy = buyStrategy;
        this.sellStrategy = sellStrategy;
    }

    /**
     * 주식 매수 전략을 설정하는 메소드입니다.
     *
     * @param buyStrategy 새로운 주식 매수 전략
     */
    public void setBuyStrategy(BuyStrategy buyStrategy) {
        this.buyStrategy = buyStrategy;
    }

    /**
     * 주식 매도 전략을 설정하는 메소드입니다.
     *
     * @param sellStrategy 새로운 주식 매도 전략
     */
    public void setSellStrategy(SellStrategy sellStrategy) {
        this.sellStrategy = sellStrategy;
    }

    /**
     * 주식을 매수하는 메소드입니다.
     */
    public void buy() {
        buyStrategy.buy();
    }

    /**
     * 주식을 매도하는 메소드입니다.
     */
    public void sell() {
        sellStrategy.sell();
    }
}
