package singleton;

import singleton.concrete.*;
import singleton.framework.*;

public class MainAfter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryAfter factory1 = new RamenFactoryAfter("용산");
		FactoryAfter factory2 = new RamenFactoryAfter("서울");
		factory1.create("신라면");
		factory1.create("진라면");
		
		factory2.create("신라면블랙");
		factory2.create("참깨라면");
		
		System.out.print(FactoryLogger.getLog());
	}

}
