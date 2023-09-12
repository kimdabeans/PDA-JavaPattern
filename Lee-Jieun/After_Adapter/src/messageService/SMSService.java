package messageService;

/**
 * Adaptee : SMS 서비스를 제공하는 클래스
 * @version 1.1
 * @author Lee Jieun
 * */
public class SMSService {
	/**
	 * 수신인에게 SMS를 보내는 함수
	 * 
	 * @param msg Message 객체
	 * */
	public void sendSMS(Message msg) {
		System.out.printf("발신 번호: %s\n", msg.getSender());
		System.out.printf("내용: %s\n", msg.getContent());
		System.out.printf("수신 번호: %s\n", msg.getRecipient());
	}
}
