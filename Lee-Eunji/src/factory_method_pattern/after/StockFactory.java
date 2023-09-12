package factory_method_pattern.after;

/**
 * 주식 제품을 생성하는 팩토리 클래스입니다.
 *
 * @author Lee Eunji
 */
public class StockFactory extends Factory {
    @Override
    protected Product createProduct(String name, int maturityYear, String strategy) {
        return new Stock(name);
    }
}
