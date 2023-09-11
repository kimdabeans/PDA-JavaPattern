package composite;

public class PersonalStock implements Stock{
	private String stockName;
	private double price;
	
	public PersonalStock(String stockName, double price) {
		this.stockName = stockName;
		this.price = price;
	}

	@Override
	public String getStockName() {
		// TODO Auto-generated method stub
		return stockName;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
