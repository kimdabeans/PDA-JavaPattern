package Strategy;
/**
 * PassiveInvestmentTradingStrategy 클래스입니다.
 * TradingStrategy 인터페이스를 구현했으며, 수동적 투자 전략을 구현하는 클래스입니다.
 * 이 전략은 주식 가격에 따라 매수 또는 매도 결정을 내립니다.
 */
public class PassiveInvestmentTradingStrategy implements TradingStrategy {
    /**
     * 다음 거래(매수 또는 매도)를 결정하는 메서드입니다.
     * 현재 가격이 과거 가격보다 높은 경우에는 주식을 매수하고, 현재 가격이 과거 가격보다 낮은 경우에는 주식을 매도합니다.
     *
     * @param previousPrice 이전 주식 가격
     * @param stockPrice    현재 주식 가격
     * @return 거래 유형 (매수 또는 매도)
     */
    @Override
    public Trade nextTrade(int previousPrice, int stockPrice) {
        return previousPrice < stockPrice ? Trade.SELL : Trade.BUY;
    }
    /**
     * 객체를 문자열로 표현하는 메서드입니다.
     *
     * @return 객체의 문자열 표현 ("PassiveStrategy")
     */
    @Override
    public String toString() {
        return "PassiveStrategy";
    }
}
