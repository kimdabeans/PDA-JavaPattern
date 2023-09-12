package factorymethod;

import factorymethod.concreteProduct.*;
import factorymethod.framework.*;

public class MainAfter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory shinramenFactory = new RamenFactoryAfter();
		
		Product shinramenProduct = shinramenFactory.create("신라면");

		shinramenProduct.packaging();
		shinramenProduct.deliver("America");
		shinramenProduct.packaging();
		shinramenProduct.deliver("Japen");
		
		Factory sesameramenFactory = new RamenFactoryAfter();
		
		Product sesameramenProduct = sesameramenFactory.create("참깨라면");
		
		sesameramenProduct.packaging();
		sesameramenProduct.deliver("Mexico");
		sesameramenProduct.packaging();
		sesameramenProduct.deliver("마장동");
	}

}
