package BeforeAdapter;

/**
 * Adapter pattern을 사용하기 전 코드이다.
 * 환율 변환을 수행하는 클래스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
 */

public class BeforeAdapter {
    private double exchangeRateToDollar;
    private double exchangeRateToEuro;
    private double exchangeRateToYen;

    /**
     * 환율 정보를 초기화하는 생성자이다.
     *
     * @param exchangeRateToDollar 현재 원화와 비교한 달러 환율
     * @param exchangeRateToEuro   현재 원화와 비교한 유로 환율
     * @param exchangeRateToYen    현재 원화와 비교한 엔화 환율
     */
    
    public BeforeAdapter(double exchangeRateToDollar, double exchangeRateToEuro, double exchangeRateToYen) {
    	this.exchangeRateToDollar = exchangeRateToDollar;
        this.exchangeRateToEuro = exchangeRateToEuro;
        this.exchangeRateToYen = exchangeRateToYen;
    }

    /**
     * 원화 금액을 달러로 환율 변환하여 출력한다.
     *
     * @param wonAmount 원화 금액
     */
    
    public void convertToDollar(double wonAmount) {
        double dollarAmount = wonAmount * exchangeRateToDollar;
        System.out.println("원화: " + wonAmount + " 원 -> 달러: $" + dollarAmount);
    }
    
    /**
     * 원화 금액을 유로로 환율 변환하여 출력한다.
     *
     * @param wonAmount 원화 금액
     */

    public void convertToEuro(double wonAmount) {
        double euroAmount = wonAmount * exchangeRateToEuro;
        System.out.println("원화: " + wonAmount + " 원 -> 유로: €" + euroAmount);
    }

    /**
     * 원화 금액을 엔화로 환율 변환하여 출력합니다.
     *
     * @param wonAmount 원화 금액
     */
    
    public void convertToYen(double wonAmount) {
        double yenAmount = wonAmount * exchangeRateToYen;
        System.out.println("원화: " + wonAmount + " 원 -> 엔화: ¥" + yenAmount);
    }
    
    /**
     * main 메서드로 프로그램을 실행합니다.
     */
    
    public static void main(String[] args) {
        double exchangeRateToDollar = 1324.65;
        double exchangeRateToEuro = 1423.93;
        double exchangeRateToYen = 9.03;

        BeforeAdapter converter = new BeforeAdapter(exchangeRateToDollar, exchangeRateToEuro, exchangeRateToYen);

        double wonAmount = 1;
        converter.convertToDollar(wonAmount);
        converter.convertToEuro(wonAmount);
        converter.convertToYen(wonAmount);
    }
}