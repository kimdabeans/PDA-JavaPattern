package observer;
/**
 * 주가 변동과 관련하여 클라이언트에게 알림을 보내는 시스템.
 */
public class StockSystem implements Stock {
	private double price;
	private Notify notifier = new NotifyClient();
	
	public StockSystem(double initialprice) {
		this.price = initialprice;
	}

	private void notifyAllClients() {
		for (Client client : ClientDAO.getAllClients()) {
            notifier.sendMessage(client, "주식 가격이 " + getPrice() + "로 변동 되었습니다. ");
        }
	}
	
	@Override
	public void updatePrice(double newPrice) {
		this.price = newPrice;
		notifyAllClients();
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
}