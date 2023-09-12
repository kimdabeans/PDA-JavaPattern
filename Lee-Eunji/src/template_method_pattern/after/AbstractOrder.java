package template_method_pattern.after;

/**
 * 주문 처리 프로세스를 정의하는 추상 클래스입니다.
 */
public abstract class AbstractOrder {

    /**
     * 주문 처리 프로세스를 실행합니다.
     */
    public void executeOrder() {
        validateOrder();
        placeOrder();
        confirmOrder();
    }

    /**
     * 주문 유효성을 검사하는 추상 메서드입니다.
     * 하위 클래스에서 구현해야 합니다.
     */
    public abstract void validateOrder();

    /**
     * 주문을 실행하는 추상 메서드입니다.
     * 하위 클래스에서 구현해야 합니다.
     */
    public abstract void placeOrder();

    /**
     * 주문을 확정 처리하는 추상 메서드입니다.
     * 하위 클래스에서 구현해야 합니다.
     */
    public abstract void confirmOrder();
}
