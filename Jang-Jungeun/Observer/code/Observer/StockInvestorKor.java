package Observer;

/**
 * ConcreteObserver (구체적인 관찰자) 클래스이다.
 * 한국어로 업데이트 메시지 출력한다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 * 
 */

public class StockInvestorKor implements Investor{
    private String name;

    public StockInvestorKor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(name + " 님께서 업데이트 하셨습니다. : " + stockName + " 의 현재 주가는 $" + price + " 입니다.");
    }
}
