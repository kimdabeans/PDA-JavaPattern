package observer;

/**
 * 주식 시장 시스템을 실행하는 메인 클래스입니다.
 */
public class main {

    public static void main(String[] args) {
        // 주식 시장 객체 생성
        StockMarket stockMarket = new StockMarket();

        // 다양한 투자자 객체 생성 및 주식 시장 주제에 등록
        StockObserver investor1 = new Investor("John");
        stockMarket.registerObserver(investor1);

        StockObserver investor2 = new Investor("Alice");
        stockMarket.registerObserver(investor2);

        // 주식 가격 업데이트
        stockMarket.updateStockPrice(150.0); // 주식 가격 상승
        stockMarket.updateStockPrice(130.0); // 주식 가격 하락
    }
}