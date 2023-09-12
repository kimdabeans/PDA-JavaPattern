package Adapter;

/**
 * 환율 변환을 수행하는 Client 클래스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class Client {

    	private int wonAmount; // 변환할 원화 금액
    	private double exchangeRateToDollar; // 원화를 달러로 변환하는 환율
    	private double exchangeRateToEuro; // 원화를 유로로 변환하는 환율
    	private double exchangeRateToYen; // 원화를 엔화로 변환하는 환율
    	
        /**
         * Client 객체를 생성한다.
         *
         * @param wonAmount            변환할 원화 금액
         * @param exchangeRateToDollar 원화를 달러로 변환하는 환율
         * @param exchangeRateToEuro   원화를 유로로 변환하는 환율
         * @param exchangeRateToYen    원화를 엔화로 변환하는 환율
         */
    	
        public Client(int wonAmount, double exchangeRateToDollar, double exchangeRateToEuro, double exchangeRateToYen) {
            this.wonAmount = wonAmount;
            this.exchangeRateToDollar = exchangeRateToDollar;
            this.exchangeRateToEuro = exchangeRateToEuro;
            this.exchangeRateToYen = exchangeRateToYen;
        }
    	
        /**
         * 원화를 달러로 변환하여 출력한다. 출력결과로 입력한 원화와 환율 계산이 된 달러가 출력된다.
         */

    	public void exchangeDollar() {
    		System.out.println("원화: " + wonAmount + "원 => " + "달러: $" + exchangeRateToDollar * wonAmount);
    	}
    	
        /**
         * 원화를 유로로 변환하여 출력한다. 출력결과로 입력한 원화와 환율 계산이 된 유로가 출력된다.
         */
    	
    	public void exchangeEuro() {
    		System.out.println("원화: " + wonAmount + "원 => " + "유로: €" + exchangeRateToEuro * wonAmount);
    	}
    	
        /**
         * 원화를 엔화로 변환하여 출력한다. 출력결과로 입력한 원화와 환율 계산이 된 엔화가 출력된다.
         */
    	
    	public void exchangeYen() {
    		System.out.println("원화: " + wonAmount + "원 => " + "엔화: €" + exchangeRateToYen * wonAmount);
    	}
         
    }

