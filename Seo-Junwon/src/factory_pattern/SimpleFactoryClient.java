package factory_pattern;
/**
 * <p>
 * SimpleFactory Pattern을 테스트할 수 있는 Client 클래스이다.<br>
 * 심플 팩토리 패턴을 사용해 안드로이드와 아이폰을 주문한다. 
 * </p>
 * @author 서준원
 *
 */
public class SimpleFactoryClient {

	public static void main(String[] args){
		
        SimplePhoneFactory simplePhoneFactory = new SimplePhoneFactory();
                
        Phone androidPhone = simplePhoneFactory.orderPhone("ANDROID");
        androidPhone.call();
        
        Phone iPhone = simplePhoneFactory.orderPhone("IPHONE");
        iPhone.call();
        
    }

}
