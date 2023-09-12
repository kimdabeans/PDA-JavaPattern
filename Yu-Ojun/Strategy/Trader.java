package Strategy;
/**
 * Trader 클래스입니다.
 * 투자자를 나타내는 클래스입니다.
 */
public class Trader {
    private String name;
    private TradingStrategy tradingStrategy;
    private int balance;
    private int stock;

    /**
     * 주어진 이름, 거래 전략, 초기 자본으로 Trader 클래스의 인스턴스를 생성하는 생성자입니다.
     *
     * @param name            거래자의 이름
     * @param tradingStrategy 거래자의 거래 전략
     * @param balance         거래자의 초기 자본
     */
    public Trader(String name, TradingStrategy tradingStrategy, int balance){
        this.name = name;
        this.tradingStrategy = tradingStrategy;
        this.balance = balance;
    }
    /**
     * 거래자의 현재 잔고를 반환합니다.
     *
     * @return 현재 잔고
     */
    public int getBalance() {
        return balance;
    }
    /**
     * 거래자의 잔고를 설정합니다.
     *
     * @param balance 설정할 잔고
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    /**
     * 다음 거래(매수 또는 매도)를 결정하는 메서드이며, 고객이 어떤 전략을 택했는지 출력합니다.
     *
     * @param previousPrice 이전 주식 가격
     * @param stockPrice    현재 주식 가격
     * @return 거래 유형 (매수 또는 매도)
     */
    public Trade nextTrade(int previousPrice, int stockPrice) {
        Trade trade = tradingStrategy.nextTrade(previousPrice, stockPrice);
        System.out.println("selling/buying, " + name + " chose "+trade);
        return trade;
    }
    /**
     * 거래자의 정보를 출력하는 메서드입니다.
     */
    public void printProperty() {
       System.out.println(name + "'s strategy is " + tradingStrategy.toString() + ", the balance is " + balance + ", and the stock price is " + stock);
    }
    /**
     * 주어진 거래 유형에 따라 거래를 수행하는 메서드입니다.
     *
     * @param trade      거래 유형 (매수 또는 매도)
     * @param stockPrice 주식 가격
     */
    public void trade(Trade trade, int stockPrice) {
        if(trade == Trade.BUY)
            buy(stockPrice);
        else
            sell(stockPrice);
    }
    /**
     * 주식을 판매하고 자본을 업데이트합니다.
     *
     * @param stockPrice 주식 가격
     */
    public void sell(int stockPrice) {
        this.stock -= stockPrice;
        this.balance += stockPrice;
    }
    /**
     * 주식을 구매하고 자본을 업데이트합니다.
     *
     * @param stockPrice 주식 가격
     */
    public void buy(int stockPrice) {
        this.stock += stockPrice;
        this.balance -= stockPrice;
    }
}
