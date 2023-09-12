package factory_method_pattern.before;

/**
 * Product 클래스의 간단한 테스트를 수행하는 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Product stock = new Product("Stock");
        stock.use();
        stock.explain();

        Product bond = new Product("Bond");
        bond.use();
        bond.explain();

        Product fund = new Product("Fund");
        fund.use();
        fund.explain();
    }
}
