package strategy;

/**
 * 신한페이를 이용하여 결제를 처리하는 클래스
 */
public class ShinhanPay {
    
    private PaymentStrategy paymentStrategy;             // 결제 전략을 저장하는 변수
    private ExchangeRateStrategy exchangeRateStrategy;   // 환율 변환 전략을 저장하는 변수

    /**
     * 신한페이 객체를 생성하며 사용할 결제 전략을 초기화하는 생성자
     * 
     * @param paymentStrategy 초기화할 결제 전략
     */
    public ShinhanPay (PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * 환율 변환 전략을 설정하는 메서드
     * 
     * @param exchangeRateStrategy 설정할 환율 변환 전략
     */
    public void setExchangeRateStrategy(ExchangeRateStrategy exchangeRateStrategy) {
        this.exchangeRateStrategy = exchangeRateStrategy;
    }

    /**
     * 결제를 진행하는 메서드 
     * 환율 변환 전략이 설정되어 있을 경우, 주어진 금액을 해당 전략에 따라 변환한 후 결제 전략을 이용하여 결제 진행
     * 
     * @param amount 결제할 원화 금액
     */
    public void checkout(int amount) {
        String currencyUnit = "원"; // 기본 단위
        if(exchangeRateStrategy != null) {
            amount = (int) exchangeRateStrategy.convert(amount);
            currencyUnit = exchangeRateStrategy.getCurrencyUnit();
        }
        paymentStrategy.pay(amount, currencyUnit);
    }
}

