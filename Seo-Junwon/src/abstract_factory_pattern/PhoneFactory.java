package abstract_factory_pattern;

/**
 * <p>
 * 휴대폰을 생성하는데 필요한 기능을 정의한 PhoneFactory 인터페이스이다.<br> 
 * 휴대폰을 생성하는 createPhone 메서드와,<br>
 * 휴대폰에 필요한 OS를 생성하는 createOS 메서드로 구성된다. 
 * </p>
 * @author 서준원
 *
 */
public interface PhoneFactory {
	
	/**
	 * 휴대폰을 생성하는 메서드
	 * 
	 * @return : 생성한 Phone 객체
	 */
	Phone createPhone();
	
	/**
	 * OS를 생성하는 메서드
	 * 
	 * @return : 생성한 OS 객체 
	 */
    OS createOS();
    
}
