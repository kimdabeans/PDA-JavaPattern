package Strategy;

public class ActiveInvestmentTradingStrategy implements TradingStrategy {

    @Override
    public Trade nextStrategy(int previousPrice, int stockPrice) {
        //과거가 현재보다 비싸면 사기
        return previousPrice < stockPrice ? Trade.BUY : Trade.SELL;
    }

    @Override
    public String toString() {
        return "ActiveStrategy";
    }
}
