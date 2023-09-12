package Adapter;

/**
 * {@link Client} 클래스를 확장하여 {@link CurrencyConverter} 인터페이스를 구현한 Adapter 클래스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class Adapter extends Client implements CurrencyConverter {

    public Adapter(int wonAmount, double exchangeRateToDollar, double exchangeRateToEuro, double exchangeRateToYen) {
        super(wonAmount, exchangeRateToDollar, exchangeRateToEuro, exchangeRateToYen);

    }

    /**
     * CurrencyConverter 인터페이스에서 선언된 메소드를 오버라이드하여 구현한다.
     */
    @Override
    public void convertToDollar() {
    	exchangeDollar();
    }

    @Override
    public void convertToEuro() {
    	exchangeEuro();
    }
    @Override
    public void convertToYen() {
    	exchangeYen();
    }
}