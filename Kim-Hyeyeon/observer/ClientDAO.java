package observer;

import java.util.HashSet;
import java.util.Set;

public class ClientDAO {
private static Set<Client> clients = new HashSet<>();

public static void registerClient(Client client) {
   clients.add(client);
}

public static Set<Client> getAllClients() {
   return clients;
}
}
