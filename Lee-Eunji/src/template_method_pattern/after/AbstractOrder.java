package template_method_pattern.after;

/**
 * 추상 주문 클래스입니다.
 * 이 클래스는 매수 및 매도 주문 클래스에 공통된 주문 처리 프로세스를 제공합니다.
 *
 * @author Lee Eunji
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
     */
    public abstract void validateOrder();

    /**
     * 주문을 실행하는 추상 메서드입니다.
     */
    public abstract void placeOrder();

    /**
     * 주문을 확정 처리하는 추상 메서드입니다.
     */
    public abstract void confirmOrder();
}
