package abstract_factory_pattern;

public class AbstractFactoryClient {
	public static void main(String[] args) {
        PhoneFactoryOfFactory phoneFactoryOfFactory = new DefaultPhoneFactoryOfFactory();
        PhoneFactory iphoneFactory= phoneFactoryOfFactory.requestPhone("IPHONE");   //아이폰을 산다.
        Phone iphone = iphoneFactory.createPhone();
        iphone.call();
        iphone.playGame();

        PhoneFactory androidPhoneFactory = phoneFactoryOfFactory.requestPhone("ANDROID");   //안드로이드폰을 산다.
        Phone androidPhone = androidPhoneFactory.createPhone();
        androidPhone.call();
        androidPhone.playGame();
    }
}
