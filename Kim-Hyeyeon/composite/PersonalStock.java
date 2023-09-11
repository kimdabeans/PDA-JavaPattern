package composite;

public class PersonalStock implements Stock{
	private String name;
	private double price;
	
	public PersonalStock(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return price;
	}
	
	
}
