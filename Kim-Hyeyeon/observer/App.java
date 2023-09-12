package observer;
/**
 * 알림 메시지를 전달하는 앱 - 메인 메소드.
 */
public class App {
	
public static void main(String[] args) {
   StockSystem shinhanStock = new StockSystem(150.0);
   Client john = new Client("John", "john@gmail.com");
   ClientDAO.registerClient(john);
   shinhanStock.updatePrice(155.0);
   }
}

