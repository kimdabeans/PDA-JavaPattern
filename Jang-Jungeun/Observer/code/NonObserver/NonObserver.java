package NonObserver;

/**
 * Observer pattern을 사용하기 전 코드이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
 */

public class NonObserver {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();
        StockInvestorKor investor1 = new StockInvestorKor("관리자 1");
        StockInvestorEng investor2 = new StockInvestorEng("Admin");

        // 주식 거래가 발생할 때마다 각각의 투자자에게 직접 업데이트 메시지 전송
        stockExchange.tradeStock("Apple", 60.0);
        investor1.update("Apple", 60.0);
        investor2.update("Apple", 60.0);
    }
}
