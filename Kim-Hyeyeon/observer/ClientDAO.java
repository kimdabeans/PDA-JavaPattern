package observer;
import java.util.HashSet;
import java.util.Set;
/**
 * 클라이언트 데이터를 관리하는 클래스.
 */
public class ClientDAO {
private static Set<Client> clients = new HashSet<>();
/**
 * 고객 등록.
 *
 * @param client 등록할 클라이언트
 */
public static void registerClient(Client client) {
   clients.add(client);
}
/**
 * 모든 클라이언트 정보를 반환.
 * 
 * @return 모든 클라이언트의 집합
 */
public static Set<Client> getAllClients() {
   return clients;
}
}
