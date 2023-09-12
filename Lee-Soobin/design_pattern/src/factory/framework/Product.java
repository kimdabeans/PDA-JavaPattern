
package factory.framework;

/**
 * 모든 제품이 공통으로 가져야할 기능을 정의하는 추상 클래스.
 */
public abstract class Product {

    /**
     * 제품 사용을 위한 추상 메서드. 하위 클래스에서 구체적인 동작을 구현해야 합니다.
     */
    public abstract void use();
}
