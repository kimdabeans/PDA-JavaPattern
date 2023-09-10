package messageService;

/**
 * Adaptee : SMS 서비스를 제공하는 클래스
 * @version 1.0
 * @author Lee Jieun
 * */
public class SMSService {
	/**
	 * 수신인에게 SMS를 보내는 함수
	 * 
	 * @param content SMS 내용
	 * @param from 발신인의 전화번호 
	 * @param to   수신인의 전화번호 
	 * */
	public void sendSMS(String content, String from, String to) {
		System.out.printf("발신 번호: %s\n", from);
		System.out.printf("내용: %s\n", content);
		System.out.printf("수신 번호: %s\n", to);
	}
}
