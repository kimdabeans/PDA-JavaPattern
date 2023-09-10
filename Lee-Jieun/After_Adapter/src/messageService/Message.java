package messageService;

/**
 * 메시지를 나타내는 클래스
 * @version 1.1
 * @author Lee Jieun
 * */
public class Message {
	/**
	 *메시지 내용 
	 * */
	private String content;
	/**
	 * 발신인 
	 * */
	private String sender;
	/**
	 * 수신인
	 * */
	private String recipient;
	
	/**
	 * Message 클래스의 생성자
	 * 
	 * @param content   메시지 내용
	 * @param sender    발신인
	 * @param recipient 수신인
	 * */
	public Message(String content, String sender, String recipient) {
		this.content = content;
		this.sender = sender;
		this.recipient = recipient;
	}

	/**
	 * 메시지 내용을 반환 
	 * 
	 * @return 메시지 내용 
	 * */
	public String getContent() {
		return content;
	}

	/**
	 * 발신인을 반환 
	 * 
	 * @return 발신인 
	 * */
	public String getSender() {
		return sender;
	}

	/**
	 * 수신인을 반환 
	 * 
	 * @return 수신인 
	 * */
	public String getRecipient() {
		return recipient;
	}
}
