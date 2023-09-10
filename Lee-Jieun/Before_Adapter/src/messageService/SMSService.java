package messageService;

public class SMSService {
	public void sendSMS(String text, String from, String to) {
		System.out.printf("발신 번호: %s\n", from);
		System.out.printf("내용: %s\n", text);
		System.out.printf("수신 번호: %s\n", to);
	}
}
