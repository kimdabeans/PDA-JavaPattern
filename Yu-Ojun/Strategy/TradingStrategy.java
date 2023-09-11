package Strategy;

public interface TradingStrategy {

    public abstract Trade nextStrategy(int previousPrice, int stockPrice);
}
