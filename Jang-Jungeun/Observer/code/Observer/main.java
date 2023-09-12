package Observer;

/**
 * 동작 테스트용 main 클래스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class main {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();
        Investor investor1 = new StockInvestorKor("장정은");
        Investor investor2 = new StockInvestorEng("Heung Min");

        stockExchange.registerObserver(investor1);
        stockExchange.registerObserver(investor2);

        // 주식 거래가 발생하면 모든 투자자에게 알림
        stockExchange.tradeStock("SAMSUNG", 59.0);
    }
}
