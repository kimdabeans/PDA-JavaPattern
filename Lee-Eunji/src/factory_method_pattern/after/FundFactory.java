package factory_method_pattern.after;

/**
 * 펀드 제품을 생성하는 팩토리 클래스입니다.
 */
public class FundFactory extends Factory {
    @Override
    protected Product createProduct(String name, int maturityYear, String strategy) {
        return new Fund(strategy);
    }
}
