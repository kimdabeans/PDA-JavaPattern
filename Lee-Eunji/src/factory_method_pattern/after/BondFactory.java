package factory_method_pattern.after;

/**
 * 채권 제품을 생성하는 팩토리 클래스입니다.
 */
public class BondFactory extends Factory {
    @Override
    protected Product createProduct(String name, int maturityYear, String strategy) {
        return new Bond(maturityYear);
    }
}
