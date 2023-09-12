package beforeProxy;

public class StockMarket {
	String stock;
	
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
	
	public void successfulStockTrading() {
		System.out.printf("%s 거래 완료!\n", stock);
	}
	
}
