package Adapter;
/**
 * CurrencyConverter를 사용하여 원화를 다른 통화로 변환하는 메소드를 실행하는 main 클래스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class main {
	public static void main(String[] args) {
		/**
		 * CurrencyConverter의 인스턴스를 CurrencyConverter인터페이스형 변수에 대입한다.
		 * 1000은 변환하고 싶은 원화. 1324.65는 현재 달러 환율, 1423.93은 현재 유로 환율, 9.03은 현재 엔화 환율이다.
		 */
		CurrencyConverter c = new Adapter(1000, 1324.65, 1423.93, 9.03);
		
	    c.convertToDollar();
	    c.convertToEuro();
	    c.convertToYen();
	}
}
