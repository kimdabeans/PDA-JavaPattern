package abstract_factory_pattern;

/**
 * PhoneFactoryOfFactory 인터페이스를 구현한 DefaultPhoneFactoryOfFactory 구현체이다. 
 * requestPhone 메서드를 통해 클라이언트가 요청한 회사에 해당하는 PhoneFactory를 리턴한다.
 * 
 * @author 서준원
 *
 */
public class DefaultPhoneFactoryOfFactory implements PhoneFactoryOfFactory{
	
	/**
	 * 클라이언트가 요청한 회사에 해당하는 PhoneFactory를 리턴하는 메서드 
	 * 적절하지 않은 요청에 대해선 에러를 리턴한다. 
	 * 
	 * @param : String company -> 클라이언트가 요청한 휴대폰의 제조사
	 * @throws : 아이폰과 안드로이드 폰이 아닌 다른 요청이 들어오면 throw 처리
	 * @return : parameter로 넘어온 제조사의 PhoneFactory
	 */
    @Override
    public PhoneFactory requestPhone(String company) {
        switch (company) {
            case "IPHONE":
                return new IPhoneFactory();
            case "ANDROID":
                return new AndroidPhoneFactory();
        }
        throw new IllegalArgumentException();
    }
}
