package Strategy;

public class Trader {
    private String name;
    private TradingStrategy tradingStrategy;
    private int balance;
    private int stock;

    public Trader(String name, TradingStrategy tradingStrategy, int balance){
        this.name = name;
        this.tradingStrategy = tradingStrategy;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Trade nextTrade(int previousPrice, int stockPrice) {
        Trade trade = tradingStrategy.nextStrategy(previousPrice, stockPrice);
        System.out.println("selling/buying, " + name + " chose "+trade);
        return trade;
    }

    public void printProperty() {
       System.out.println(name + "'s strategy is " + tradingStrategy.toString() + ", the balance is " + balance + ", and the stock price is " + stock);
    }

    public void trade(Trade trade, int stockPrice) {
        if(trade == Trade.BUY){
            buy(stockPrice);
        }
        else{
            sell(stockPrice);
        }
    }

    public void sell(int stockPrice) {
        this.stock -= stockPrice;
        this.balance += stockPrice;
    }

    public void buy(int stockPrice) {
        this.stock += stockPrice;
        this.balance -= stockPrice;
    }
}
