package factory_pattern;
/**
 * 심플 팩토리 패턴을 구현한 SimplePhoneFactory 클래스
 * 클라이언트로부터 주문이 들어오면 휴대폰을 생성하는 orderPhone 메서드와,
 * 전달된 parameter에 해당하는 휴대폰을 생성하는 createPhone 메서드로 구성되어 있다. 
 * 
 * @author 서준원
 *
 */
public class SimplePhoneFactory {
	
	/**
	 * 클라이언트로부터 주문이 들어오면 휴대폰을 생성하는 orderPhone 메서드와,
	 * 해당하는 휴대폰을 생성하는 createPhone 메서드로 구성되어 있다. 
	 * 
	 * @param : String type -> 고객이 주문한 휴대폰 타입
	 * @return : createPhone 메서드를 호출해 생성한 Phone 객체 
	 */
	public Phone orderPhone(String type) {
		
	    Phone phone = createPhone(type);
	    phone.complete();
	    
	    return phone;
	}
	
	/**
	 * 고객이 주문한 휴대폰을 직접 생성하는 createPhone 메서드
	 * 
	 * @param : String type -> 고객이 주문한 휴대폰 타입
	 * @return : 넘어온 parameter에 해당하는 휴대폰을 생성한 Phone 객체 
	 */
    private Phone createPhone(String type) {
    	
        return switch (type) {
            case "IPHONE" -> new IPhone();
            case "ANDROID" -> new AndroidPhone();
            default -> null;
        };
        
    }
}
