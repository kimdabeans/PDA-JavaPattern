import messageService.*;

public class Main {
	public static void sendMessage(MessageService service, String msg, String sender, String recipient) {
		service.sendMessage(msg, sender, recipient);
	}

	public static void main(String[] args) {
		MessageService emailAdapter = new EmailServiceAdapter(new EmailService());
		MessageService smsAdapter = new SMSServiceAdapter(new SMSService());
		
		System.out.println("============= 이메일 전송 =============");
		sendMessage(emailAdapter, "이메일 전달드립니다!", "send@gmail.com", "recipient@gmail.com");

		System.out.println("============== SMS 전송 ==============");
		sendMessage(smsAdapter, "메시지 전달드립니다!", "010-1111-2222", "010-1234-5678");
	}
}
