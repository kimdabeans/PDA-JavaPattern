package Strategy;
/**
 * TradingStrategy 인터페이스입니다.
 * 주식 거래 전략을 정의하는 인터페이스입니다.
 */
public interface TradingStrategy {
    /**
     * 다음 거래(매수 또는 매도)를 결정하는 메서드입니다.
     *
     * @param previousPrice 이전 주식 가격
     * @param stockPrice    현재 주식 가격
     * @return 거래 유형 (매수 또는 매도)
     */
    public abstract Trade nextTrade(int previousPrice, int stockPrice);
}
