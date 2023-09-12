package factory_method_pattern.after;


/**
 * 추상 클래스 Factory는 제품(Product)을 생성하는 메서드를 정의합니다.
 * 실제 제품 팩토리 클래스는 이 클래스를 상속받아 구체적인 제품 생성 방법을 구현해야 합니다.
 *
 * @author Lee Eunji
 */
public abstract class Factory {

    /**
     * 제품을 생성하는 메서드입니다.
     *
     * @param name 제품의 이름
     * @param maturityYear 채권의 만기 연도 (채권인 경우에만 사용)
     * @param strategy 펀드의 전략 (펀드인 경우에만 사용)
     * @return 생성된 제품 객체
     */
    public Product create(String name, int maturityYear, String strategy) {
        Product p = createProduct(name, maturityYear, strategy);
        return p;
    }

    /**
     * 구체적인 제품을 생성하는 메서드입니다.
     *
     * @param name 제품의 이름
     * @param maturityYear 채권의 만기 연도 (채권인 경우에만 사용)
     * @param strategy 펀드의 전략 (펀드인 경우에만 사용)
     * @return 생성된 제품 객체
     */
    protected abstract Product createProduct(String name, int maturityYear, String strategy);
}
