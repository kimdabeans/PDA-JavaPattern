package afterProxy;

public class StockProxy implements ITrading {
	private StockMarket proxyStock;
	private String type;
	
	StockProxy(String type){
		this.type = type;
	}
	
	@Override
	public void successfulStockTrading() {
		proxyStock = new StockMarket(type);
		proxyStock.successfulStockTrading();
	}
}
