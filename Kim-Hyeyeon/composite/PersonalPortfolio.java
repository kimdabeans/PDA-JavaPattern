package composite;
import java.util.ArrayList;
import java.util.List;

public class PersonalPortfolio implements Stock {
	private String name;
    private List<Stock> stocks = new ArrayList<>();

    public PersonalPortfolio(String name) {
        this.name = name;
    }

    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public double price() {
    	double sum = 0;
        for (Stock stock: stocks) {
        	sum += stock.price();
        }
    	return sum;
    }

    @Override
    public String name() {
        return name;
    }
}
