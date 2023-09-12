package factory_pattern;

/**
 * <p>
 * 유저가 주문을 위해 시나리오가 포함된 메인 클래스이다.<br>
 * Factory 메서드 패턴을 활용해 IPhone, AndroidPhone을 생성하고 기능을 실행한다.  
 * </p>
 * @author 서준원
 *
 */
public class FactoryClient {
	
	public static void main(String[] args){
		

        IPhoneFactory iPhoneFactory = new IPhoneFactory();
        Phone iPhone = iPhoneFactory.orderPhone();
        iPhone.call();

        AndroidPhoneFactory androidPhoneFactory = new AndroidPhoneFactory();
        Phone androidPhone = androidPhoneFactory.orderPhone();
        androidPhone.call();
        
    }
}
