package messageService;

/**
 * Adapter : MessageService 인터페이스를 구현하고, EmailService 클래스를 적용하는 클래스 
 * @version 1.0
 * @author Lee Jieun
 * */
public class EmailServiceAdapter implements MessageService {
	/**
	 * EmailService 객체
	 * */
	private EmailService emailService;

	/**
	 * EmailServiceAdapter 생성자
	 * 
	 * @param emailService EmailService 객체  
	 * */
	public EmailServiceAdapter(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public void sendMessage(String content, String sender, String recipient) {
		// 이메일 메시지를 이메일 서비스에 맞게 변화하고 전송 
		String subject = "이메일 확인부탁드립니다~";
		String body = content;
		String from = sender;
		String to = recipient;
		emailService.sendEmail(subject, body, from, to);
	}
}
