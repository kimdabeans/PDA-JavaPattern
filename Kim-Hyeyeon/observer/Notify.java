package observer;
/**
 * 클라이언트에게 알림을 전송하는 기능을 정의한 인터페이스.
 */
public interface Notify {
	void sendMessage(Client client, String message);
}