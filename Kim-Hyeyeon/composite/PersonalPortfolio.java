package composite;
import java.util.ArrayList;
import java.util.List;
/**
 * 개인의 주식 포트폴리오를 나타내는 클래스.
 * 주식 포트폴리오는 여러 개의 주식(Stock)을 포함할 수 있다.
 * @filename PersonalPortfolio.java
 * 
 */
public class PersonalPortfolio implements Stock {
	private final String buyer;
    private final List<Stock> stocks = new ArrayList<>();

    /**
     * PersonalPortfolio 생성자.
     * 
     * @param buyer 포트폴리오 소유자의 이름
     */
    public PersonalPortfolio(String buyer) {
        this.buyer = buyer;
    }
    
    /**
     * 포트폴리오에 주식 추가
     * 
     * @param stock 추가할 주식명
     */
    public void add(Stock stock) {
        stocks.add(stock);
    }
    
    
    @Override
    public double getPrice() {
    	double sum = 0;
        for (Stock stock: stocks) {
        	sum += stock.getPrice();
        }
    	return sum;
    }

	@Override
	public String getStockName() {
		String stockNames ="";
		for (Stock stock: stocks) {
			stockNames+=stock.getStockName();
			stockNames+=", ";
		}
		return stockNames;
	}
	
	/**
     * 포트폴리오 소유자의 이름을 반환
     * 
     * @return 포트폴리오 소유자의 이름
     */
	public String getBuyer() {
		return buyer;
	}
}
