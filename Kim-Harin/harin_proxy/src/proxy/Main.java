package proxy;

/**
 * <h1>Main</h1>
 * <p>
 * Main 클래스는 주식 가격 프록시 서비스를 테스트하는 예제를 제공합니다.
 * </p>
 *
 * @version 1.0.1
 * @author harin
 *
 */
// Main 클래스
public class Main {
    public static void main(String[] args) {
        StockService p = new StockServiceProxy(130);
        System.out.println("Current price is " + p.getStockPrice() + ".");
        p.setStockPrice(160);
        System.out.println("Current price is " + p.getStockPrice() + ".");
        p.print("Hello world");
    }
}
