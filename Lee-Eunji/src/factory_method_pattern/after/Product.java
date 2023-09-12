package factory_method_pattern.after;

/**
 * 추상 클래스 Product는 제품(Product)의 기본 특성을 정의합니다.
 * 실제 제품 클래스는 이 클래스를 상속받아 구체적인 동작을 구현해야 합니다.
 */
public abstract class Product {

    /**
     * 제품을 사용하는 메서드입니다.
     */
    public abstract void use();

    /**
     * 제품의 설명을 표시하는 메서드입니다.
     */
    public abstract void explain();
}
