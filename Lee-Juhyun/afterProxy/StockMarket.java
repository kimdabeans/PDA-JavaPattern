package afterProxy;

/**
 * 실제 주식 거래를 수행하는 클래스입니다. ITrading 인터페이스를 구현하며,
 * 특정 종류의 주식 거래를 시뮬레이션합니다.
 */
public class StockMarket implements ITrading {
	private String stock;

	/**
	 * StockMarket 클래스 생성자입니다.
	 *
	 * @param type 거래할 주식의 종류
	 */
	StockMarket(String type){
		stockTrading(type);
	}
	private void stockTrading(String type) {
		try {
			Thread.sleep(3000);
			stock = type;
		}
		catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("-- %s 거래중 --\n", type);
	}
	
	@Override
	public void successfulStockTrading() {
		System.out.printf("%s 거래 완료!\n", stock);
	}
	
}
