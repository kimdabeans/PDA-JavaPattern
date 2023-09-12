package factory_pattern;

public class SimpleFactoryClient {

	public static void main(String[] args){
		
        SimplePhoneFactory simplePhoneFactory = new SimplePhoneFactory();
                
        Phone androidPhone = simplePhoneFactory.orderPhone("ANDROID");
        androidPhone.call();
        
        Phone iPhone = simplePhoneFactory.orderPhone("IPHONE");
        iPhone.call();
        
    }

}
