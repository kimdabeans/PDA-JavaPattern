package strategy;

/**
 * 미국 달러 환율 변환 전략을 구현한 클래스
 */
public class USDExchangeStrategy implements ExchangeRateStrategy {

    // 1달러가 1100원으로 가정한 환율 상수
    private static final double USD_RATE = 1100; 

    /**
     * 주어진 원화 금액을 미국 달러로 변환하는 메서드
     * 
     * @param amount 변환하려는 원화 금액
     * @return 변환된 미국 달러 금액
     */
    @Override
    public double convert(double amount) {
        return amount / USD_RATE;
    }

    /**
     * 해당 환율 전략의 화폐 단위를 반환하는 메서드
     * 
     * @return 화폐 단위 문자열 (이 경우 "달러")
     */
    @Override
    public String getCurrencyUnit() {
        return "달러";
    }
}
