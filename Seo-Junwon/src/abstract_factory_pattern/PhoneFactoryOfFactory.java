package abstract_factory_pattern;

/**
 * <p>
 * 추상 팩토리 패턴 구현을 위해 PhoneFactory를 한 번 더 감싼 PhoneFactoryOfFactory 인터페이스이다. <br>
 * Factory 패턴을 한 번 더 감싸 하나의 Factory에서 여러 개의 조합을 생성할 수 있도록 하는 패턴이다.   <br>
 * 클라이언트의 요구사항을 받아 적절한 PhoneFactory를 반환한다. 
 * </p>
 * @author 서준원
 *
 */
public interface PhoneFactoryOfFactory {
	
	/**
	 * 클라이언트의 요구사항을 받아 적절한 PhoneFactory를 리턴하는 메서드이다.
	 * 
	 * @param : String company -> 유저가 원하는 휴대폰의 제조사 
	 * @return : parameter로 넘어온 회사의 PhoneFactory 객체 
	 */
	PhoneFactory requestPhone(String company);
}
