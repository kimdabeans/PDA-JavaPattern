package factory_method_pattern.after;

/**
 * 메인 클래스는 제품을 생성하고 사용하는 테스트를 수행합니다.
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new StockFactory();

        // 주식 제품 생성 및 사용
        Product stock1 = factory.create("AAPL", 0, "ETF");
        stock1.use();
        stock1.explain();

        // 또 다른 주식 제품 생성 및 사용
        Product stock2 = factory.create("GOOGL", 0, "PER");
        stock2.use();
        stock2.explain();

        System.out.println();

        factory = new BondFactory();

        // 채권 제품 생성 및 사용
        Product bond1 = factory.create("이표채", 5, "active");
        bond1.use();
        bond1.explain();

        // 또 다른 주식 제품 생성 및 사용
        Product bond2 = factory.create("복리채", 10, "passive");
        bond2.use();
        bond2.explain();

        System.out.println();

        factory = new FundFactory();

        // 펀드 제품 생성 및 사용
        Product fund1 = factory.create("에셋플러스", 0, "안정");
        fund1.use();
        fund1.explain();

        // 또 다른 펀드 제품 생성 및 사용
        Product fund2 = factory.create("마이다스", 0, "고수익");
        fund2.use();
        fund2.explain();
    }
}
