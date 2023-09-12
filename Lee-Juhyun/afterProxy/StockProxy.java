package afterProxy;

/**
 * ITrading 인터페이스를 구현하여 주식 거래를 대리하는 프록시 클래스입니다.
 * 실제 주식 거래를 StockMarket 클래스에 위임하며, 거래 종류를 설정합니다.
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
