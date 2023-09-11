package beforeProxy;

public class Main {
	public static void main(String[] args) {
		StockMarket ITStock = new StockMarket("IT 주식");
		StockMarket CarStock = new StockMarket("자동차 주식");
		StockMarket USAStock = new StockMarket("미국 주식");
		
		ITStock.successfulStockTrading();
	}
}
