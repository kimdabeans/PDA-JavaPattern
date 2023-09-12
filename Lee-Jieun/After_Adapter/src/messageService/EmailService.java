package messageService;

/**
 * Adaptee : Email 서비스를 제공하는 클래스  
 * @version 1.1
 * @author Lee Jieun
 * */
public class EmailService {
	/**
	 * 수신인에게 이메일을 전달하는 함수
	 * 
	 * @param subject 이메일 제목 
	 * @param msg Message 객체 
	 * */
	public void sendEmail(String subject, Message msg) {
		System.out.printf("발신인: %s\n", msg.getSender());
		System.out.printf("제목: %s\n", subject);
		System.out.printf("내용: %s\n", msg.getContent());
		System.out.printf("수신인: %s\n", msg.getRecipient());
	}
}
