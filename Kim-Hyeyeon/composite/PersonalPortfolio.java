package composite;
import java.util.ArrayList;
import java.util.List;

public class PersonalPortfolio implements Stock {
	private final String buyer;
    private final List<Stock> stocks = new ArrayList<>();

    public PersonalPortfolio(String buyer) {
        this.buyer = buyer;
    }

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

	public String getBuyer() {
		return buyer;
	}
}
