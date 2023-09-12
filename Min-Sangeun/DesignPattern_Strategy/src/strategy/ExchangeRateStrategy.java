package strategy;

/**
 * 환율 변환 전략을 정의하는 인터페이스
 */
public interface ExchangeRateStrategy {
    /**
     * 주어진 금액을 변환된 화폐로 계산하는 메소드
     *
     * @param amount 원래의 금액
     * @return 변환된 금액
     */
    double convert(double amount);
    String getCurrencyUnit();
}
