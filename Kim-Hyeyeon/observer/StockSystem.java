package observer;
import java.util.Set;

public class StockSystem implements Stock {
	private double price;
	private Notify notifier = new NotifyClient();
	
	public StockSystem(double price) {
		this.price = price;
	}

	private void notifyClients() {
		Set<Client> clients = ClientDAO.getAllClients();
			for (Client client : clients) {
				notifier.sendMessage(client, "Stock price updated to " + getPrice());
			}
	}
	
	@Override
	public void update(double updatePrice) {
		this.price = updatePrice;
		notifyClients();
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
}