package messageService;

/**
 * Adapter : MessageService 인터페이스를 구현하고, SMSService 클래스를 적용하는 클래스 
 * @version 1.1
 * @author Lee Jieun
 * */
public class SMSServiceAdapter implements MessageService {
	/**
	 * SMSService 인스턴스
	 * */
	private SMSService smsService;

	/**
	 * SMSService 인스턴스를 인자로 받는 SMSServiceAdapter 생성자
	 * 
	 * @param smsService 적용시킬 SMSService 인스턴스 
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
