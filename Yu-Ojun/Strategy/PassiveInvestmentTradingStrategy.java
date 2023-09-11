package Strategy;

public class PassiveInvestmentTradingStrategy implements TradingStrategy {
    @Override
    public Trade nextStrategy(int previousPrice, int stockPrice) {
        //과거 보다 현재가 비싸면 SELL
        return previousPrice < stockPrice ? Trade.SELL : Trade.BUY;
    }

    @Override
    public String toString() {
        return "PassiveStrategy";
    }
}
