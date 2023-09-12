package Factory.framework;
/**
 * Product 클래스입니다.
 * 추상 클래스이며, 이 클래스를 상속하여 구체적인 제품 클래스를 정의하면,해당 제품 클래스의 인스턴스를 사용할 수 있습니다.
 */
public abstract class Product {
    /**
     * 제품을 사용하는 메서드입니다.
     * 구체적인 제품 클래스에서 이 메서드를 구현하여 해당 제품을 사용하는 동작을 정의할 수 있습니다.
     */
    public abstract void use();
}
