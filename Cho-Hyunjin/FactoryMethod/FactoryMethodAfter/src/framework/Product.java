package framework;

/**
 * 제품에 대한 추상 베이스 클래스입니다.
 * 이 클래스는 제품의 사용 방법을 정의합니다.
 */
public abstract class Product {
    /**
     * 제품을 사용하는 메소드입니다. 각 구체적인 제품 클래스에서 구현됩니다.
     */
    public abstract void use();
}
