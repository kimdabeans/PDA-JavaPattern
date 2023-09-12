package afterProxy;

/**
 * 주식 거래를 대리하는 Proxy 클래스입니다.
 */
public class StockProxy implements ITrading {
	private StockMarket proxyStock;
	private String type;

	/**
	 * StockProxy 클래스 생성자입니다.
	 *
	 * @param type 거래할 주식의 종류
	 */
	StockProxy(String type){
		this.type = type;
	}
	
	@Override
	public void successfulStockTrading() {
		proxyStock = new StockMarket(type);
		proxyStock.successfulStockTrading();
	}
}
