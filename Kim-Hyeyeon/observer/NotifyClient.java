package observer;

public class NotifyClient implements Notify {
@Override
public void sendMessage(Client client, String message) {
   System.out.println("Sending message to " + client.getEmail() + " -> " + message);
}
}