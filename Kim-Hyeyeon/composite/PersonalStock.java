package composite;
/**
 * 개별 주식을 나타내는 클래스.
 * @filename PersonalStock.java
 */
public class PersonalStock implements Stock{
	private String stockName;
	private double price;
	
	/**
     * PersonalStock 생성자.
     * 
     * @param stockName 주식 이름
     * @param price 주식의 가격
     */
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
