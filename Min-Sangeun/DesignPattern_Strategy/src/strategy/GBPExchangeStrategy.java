package strategy;

/**
 * 영국 파운드 환율 변환 전략을 구현한 클래스
 */
public class GBPExchangeStrategy implements ExchangeRateStrategy {

    // 1파운드가 1500원으로 가정한 환율 상수
    private static final double GBP_RATE = 1500; 

    /**
     * 주어진 원화 금액을 영국 파운드로 변환하는 메서드
     * 
     * @param amount 변환하려는 원화 금액
     * @return 변환된 영국 파운드 금액
     */
    @Override
    public double convert(double amount) {
        return amount / GBP_RATE;
    }

    /**
     * 해당 환율 전략의 화폐 단위를 반환하는 메서드
     * @return 화폐 단위 문자열 (이 경우 "파운드")
     */
    @Override
    public String getCurrencyUnit() {
        return "파운드";
    }
}
