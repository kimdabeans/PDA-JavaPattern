package NonObserver;

/**
 * Observer pattern을 사용하기 전 코드이다.
 * 영어로 업데이트 메시지를 출력하는 클래스.
 * 
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
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
