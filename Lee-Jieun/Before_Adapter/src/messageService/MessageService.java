package messageService;

/**
 * Target Interface: 이메일과 SMS 서비스 모두에 대한 공통 인터페이스
 * @version 1.0
 * @author Lee Jieun
 * */
public interface MessageService {
	/**
	 * 메시지를 수신인에게 전달하는 함수
	 * 
	 * @param msg       전송할 메시지 내용
	 * @param sender    발신인의 이메일 주소 또는 전화번호
	 * @param recipient 수신인의 이메일 주소 또는 전화번호
	 * */
	public void sendMessage(String msg, String sender, String recipient);
}
