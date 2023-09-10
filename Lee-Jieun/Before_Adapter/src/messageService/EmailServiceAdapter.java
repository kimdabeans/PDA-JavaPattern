package messageService;

public class EmailServiceAdapter implements MessageService {
	private EmailService emailService;

	public EmailServiceAdapter(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public void sendMessage(String msg, String sender, String recipient) {
		String subject = "message";
		String body = msg;
		String from = sender;
		String to = recipient;
		emailService.sendEmail(subject, body, from, to);
	}

}
