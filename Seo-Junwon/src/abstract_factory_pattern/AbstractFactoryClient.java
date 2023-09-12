package abstract_factory_pattern;
/**
 * <p>
 * AbstractFactory 패턴을 테스트 할 수 있는 Client 클래스<br>
 * 패턴을 활용해 아이폰과 안드로이드 폰을 주문하는 기능을 테스트 할 수 있다. 
 * </p>
 * 
 * @author 서준원
 *
 */
public class AbstractFactoryClient {
	public static void main(String[] args) {
        PhoneFactoryOfFactory phoneFactoryOfFactory = new DefaultPhoneFactoryOfFactory();
        PhoneFactory iphoneFactory= phoneFactoryOfFactory.requestPhone("IPHONE");   
        Phone iphone = iphoneFactory.createPhone();
        iphone.call();
        iphone.playGame();

        PhoneFactory androidPhoneFactory = phoneFactoryOfFactory.requestPhone("ANDROID");   
        Phone androidPhone = androidPhoneFactory.createPhone();
        androidPhone.call();
        androidPhone.playGame();
    }
}
