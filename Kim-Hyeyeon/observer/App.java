package observer;

public class App {
	
public static void main(String[] args) {
   StockSystem shinhanStock = new StockSystem(150.0);
   Client john = new Client("John", "john@gmail.com");
   ClientDAO.registerClient(john);
   shinhanStock.update(155.0);
   }
}

