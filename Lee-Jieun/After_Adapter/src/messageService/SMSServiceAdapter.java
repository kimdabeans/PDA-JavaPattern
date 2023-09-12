package messageService;

/**
 * Adapter : MessageService 인터페이스를 구현하고, SMSService 클래스를 적용하는 클래스 
 * @version 1.1
 * @author Lee Jieun
 * */
public class SMSServiceAdapter implements MessageService {
	/**
	 * SMSService 객체
	 * */
	private SMSService smsService;

	/**
	 * SMSServiceAdapter 생성자
	 * 
	 * @param smsService SMSService 객체  
	 * */
	public SMSServiceAdapter(SMSService smsService) {
		this.smsService = smsService;
	}
	
	@Override
	public void sendMessage(Message msg) {
		// SMS 메시지를 SMS 서비스에 맞게 변화하고 전송 
		smsService.sendSMS(msg);
	}

}
