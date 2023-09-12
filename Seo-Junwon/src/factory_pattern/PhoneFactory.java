package factory_pattern;
/**
 * <p>
 * 휴대폰을 생성하는 기능을 정의한 PhoneFactory 인터페이스이다.<br>
 * 클라이언트로부터 휴대폰 주문을 받는 orderPhone 메서드와,<br>
 * 주문 받은 휴대폰을 생성하는 createPhone 메서드가 선언되어 있다.<br><br>
 * 
 * Factory 메서드 패턴의 Creator 클래스에 해당한다.<br>
 * 어떤 휴대폰을 만들지를 서브 클래스에서 결정하도록 한다. 
 * </p>
 * @author 서준원
 *
 */
public interface PhoneFactory {

	/**
	 * 클라이언트로부터 휴대폰의 주문을 받는 메서드 
	 * 
	 * @return : 주문을 받아 생성된 Phone 객체
	 */
	Phone orderPhone();
	
	/**
	 * 클라이언트로부터 받은 휴대폰 주문을 통해 휴대폰을 생성하는 메서드
	 * 
	 * @return : 생성된 Phone 객체
	 */
    Phone createPhone();
}
