package strategy;

/**
 * 전략 패턴을 시험하는 메인 클래스
 */
public class Main {

	public static void main(String[] args) {
		  ShinhanPay pay1 = new ShinhanPay (new CreditCardStrategy("1234567890123456", "248", "9/30"));
	      pay1.checkout(10000);

	      ShinhanPay pay2 = new ShinhanPay (new PaypalStrategy("Shinhan_Strategy@naver.com", "123456"));
	      pay2.setExchangeRateStrategy(new USDExchangeStrategy());
          pay2.checkout(22000); // '달러'로 변환된 후 결제
          
          ShinhanPay pay3 = new ShinhanPay (new MobilePaymentStrategy("010-1234-5678", "123456"));
          pay3.setExchangeRateStrategy(new GBPExchangeStrategy());
          pay3.checkout(22000); //'파운드'로 변환 후 결제
          
          ShinhanPay pay4 = new ShinhanPay (new BankTransferStrategy("Shinhan", "123456-01-789456"));
          pay4.setExchangeRateStrategy(new EuroExchangeStrategy());
          pay4.checkout(22000); //'유로' 변환 후 결제

	}

}
