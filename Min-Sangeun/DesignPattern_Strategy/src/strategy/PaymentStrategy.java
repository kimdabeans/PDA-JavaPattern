package strategy;

/**
 * 결제 전략을 정의하는 인터페이스
 */
public interface PaymentStrategy {
    /**
     * 주어진 금액을 결제하는 메소드
     *
     * @param amount 결제할 금액
     */
    void pay(int amount, String currencyUnit);
}
