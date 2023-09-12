package brigepattern;
/**
 * 의류 주문의 다양한 서비스에 대한 추상 기본 클래스.
 *
 * 이 클래스는 의류 주문 및 결제를 처리하는 다양한 쇼핑 서비스에 대한 인터페이스를 정의합니다.
 * 구체적인 하위 클래스는 각 의류 카테고리에 대해 수행될 서비스 작업을 구현할 것입니다.

 * @see Clothes
 */
public abstract class ShoppingService {

    public abstract void work(Clothes clothes);
}
