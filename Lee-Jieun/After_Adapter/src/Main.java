import messageService.*;

/**
 * Main Class 
 * @version 1.1
 * @author Lee Jieun
 * */
public class Main {
	/**
     * 주어진 MessageService를 사용하여 메시지를 전달하는 함수 
     * 
     * @param service 메시지를 보낼 MessageService
     * @param msg     Message 객체 
     */
	public static void sendMessage(MessageService service, Message msg) {
		service.sendMessage(msg);
	}

	/**
	 * Adapter Pattern을 테스트하는 메인 함수 
	 * 
	 * @param args 프로그램을 실행할 때 넘겨주는 값
	 * */
	public static void main(String[] args) {
		MessageService emailAdapter = new EmailServiceAdapter(new EmailService());
		MessageService smsAdapter = new SMSServiceAdapter(new SMSService());
		
		// MessageService 인터페이스를 사용하여 메시지를 전송, 이메일 
		System.out.println("============= 이메일 전송 =============");
		Message emailMsg = new Message("이메일 전달드립니다!", "send@gmail.com", "recipient@gmail.com");
		sendMessage(emailAdapter, emailMsg);

		// MessageService 인터페이스를 사용하여 메시지를 전송, SMS  
		System.out.println("============== SMS 전송 ==============");
		Message smsMsg = new Message("메시지 전달드립니다!", "010-1111-2222", "010-1234-5678");
		sendMessage(smsAdapter, smsMsg);
	}
}
