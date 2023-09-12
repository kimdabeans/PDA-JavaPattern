package Adapter;
/**
 * 화폐 금액을 변환하는 메서드를 정의하는 currencyConverter 인터페이스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public interface CurrencyConverter {
	public abstract void convertToDollar();
	public abstract void convertToEuro();
	public abstract void convertToYen();
}
