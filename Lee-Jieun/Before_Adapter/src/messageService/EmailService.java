package messageService;

/**
 * Adaptee : Email 서비스를 제공하는 클래스  
 * @version 1.0
 * @author Lee Jieun
 * */
public class EmailService {
	/**
	 * 수신인에게 이메일을 전달하는 함수
	 * 
	 * @param subject 이메일 제목 
	 * @param content 이메일 본문 내용
	 * @param from    발신인의 이메일 주소 
	 * @param to      수신인의 이메일 주소 
	 * */
	public void sendEmail(String subject, String content, String from, String to) {
		System.out.printf("발신인: %s\n", from);
		System.out.printf("제목: %s\n", subject);
		System.out.printf("내용: %s\n", content);
		System.out.printf("수신인: %s\n",to);
	}
}
