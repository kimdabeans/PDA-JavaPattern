package proxy;

/**
 * <h1>Main</h1>
 * <p>
 * Main 클래스는 주식 가격 프록시 서비스를 테스트하는 예제를 제공합니다.
 * </p>
 *
 * @version 1.0.1
 * @author harin
 */
// Main 클래스
public class Main {
    /**
     * 주식 가격 프록시 서비스를 테스트하는 메인 메소드입니다.
     *
     * @param args 명령행 인수
     */
    public static void main(String[] args) {
        /**
         * 주식 가격 프록시 서비스 생성
         */
        StockService p = new StockServiceProxy(130);

        /**
         * 현재 주식 가격 표시
         */
        System.out.println("Current price is $" + p.getStockPrice() + ".");

        /**
         * 주식 가격 설정 및 표시
         */
        p.setStockPrice(160);
        System.out.println("Current price is $" + p.getStockPrice() + ".");
        p.print("Real stock services in operation");
    }
}
