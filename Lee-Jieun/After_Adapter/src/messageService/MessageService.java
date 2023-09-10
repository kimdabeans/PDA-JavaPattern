package messageService;

/**
 * Target Interface: 이메일과 SMS 서비스 모두에 대한 공통 인터페이스
 * @version 1.1
 * @author Lee Jieun
 * */
public interface MessageService {
	/**
	 * 메시지를 수신인에게 전달하는 함수
	 * 
	 * @param msg 본문, 발신인, 수신인이 담긴 Message 객체 
	 * */
	public void sendMessage(Message msg);
}
