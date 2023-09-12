package afterProxy;

/**
 * 주식 거래를 시뮬레이션하는 메인 클래스입니다.
 */
public class Main {
	public static void main(String[] args) {
		ITrading ITStock = new StockProxy("IT 주식");
		ITrading CarStock = new StockProxy("자동차 주식");
		ITrading USAStock = new StockProxy("미국 주식");
		
		ITStock.successfulStockTrading();
	}
}
