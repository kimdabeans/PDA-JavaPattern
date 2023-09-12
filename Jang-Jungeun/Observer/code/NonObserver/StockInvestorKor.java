package NonObserver;

/**
 * Observer pattern을 사용하기 전 코드이다.
 * 한국어로 업데이트 메시지를 출력하는 클래스.
 * 
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
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
