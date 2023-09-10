package messageService;

public class EmailService {
	public void sendEmail(String subject, String body, String from, String to) {
		System.out.printf("발신인: %s\n", from);
		System.out.printf("제목: %s\n", subject);
		System.out.printf("내용: %s\n", body);
		System.out.printf("수신인: %s\n",to);
	}
}
