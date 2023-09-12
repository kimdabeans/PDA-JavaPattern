package Observer;

/**
 * ConcreteObserver(구체적인 관찰자) 클래스이다.
 * 영어로 업데이트 메시지를 출력한다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class StockInvestorEng implements Investor{
    private String name;

    public StockInvestorEng(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(name + " received an update. : " + "The current stock price of " + stockName + " is $" + price);
    }
}
