package singleton;

import singleton.concrete.RamenFactoryBefore;
import singleton.framework.FactoryBefore;

public class MainBefore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryBefore factory1 = new RamenFactoryBefore("용산");
		FactoryBefore factory2 = new RamenFactoryBefore("서울");
		factory1.create("신라면");
		factory1.create("진라면");
		
		factory2.create("신라면블랙");
		factory2.create("참깨라면");
	}

}
