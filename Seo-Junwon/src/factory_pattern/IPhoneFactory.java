package factory_pattern;
/**
 * <p>
 * PhoneFactory 인터페이스를 구현한 IPhoneFactory 클래스이다.<br>
 * 휴대폰을 주문 받고 생성하는 기능이 선언된 PhoneFactory 인터페이스를 구현해<br>
 * 휴대폰 주문을 받고, 휴대폰을 생성한다. <br><br>
 * 
 * Factory 메서드 패턴의 ConcreteCreateor에 해당한다. <br>
 * 어떤 휴대폰을 생성할지 결정하는 클래스이다. 
 * </p>
 * @author 서준원
 *
 */
public class IPhoneFactory implements PhoneFactory{

	/**
	 * 클라이언트의 주문을 받아 createPhone 메서드를 실행해 휴대폰을 생성하는 메서드<br>
	 * 휴대폰을 생성해 Phone 객체의 생성 완료 메서드를 실행한다. 
	 * 
	 * @return : 생성된 Phone 객체
	 */
	@Override
	public Phone orderPhone() {
		Phone phone = createPhone();
		phone.complete();
		return phone;
	}
	
	/**
	 * 아이폰을 생성하는 메서드
	 * 
	 * @return : 생성된 IPhone 객체
	 */
	@Override
    public Phone createPhone() {
        return new IPhone();
    }

}
