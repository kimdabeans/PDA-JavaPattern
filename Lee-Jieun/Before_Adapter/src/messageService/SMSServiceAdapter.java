package messageService;

public class SMSServiceAdapter implements MessageService {
	private SMSService smsService;

	public SMSServiceAdapter(SMSService smsService) {
		this.smsService = smsService;
	}
	
	@Override
	public void sendMessage(String msg, String sender, String recipient) {
		String body = msg;
		String from = sender;
		String to = recipient;
		smsService.sendSMS(body, from, to);
	}

}
