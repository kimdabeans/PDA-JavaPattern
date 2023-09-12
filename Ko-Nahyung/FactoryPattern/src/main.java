import food.FishBreadFactory;
import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;

/**
 * Main 클래스
 */
public class main {

	/**
	 * main 메소드로, 실제 Factory Method Pattern을 적용하여 작업을 수행하고 생성된 인스턴스를 사용합니다.
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product idcard1 = factory.create("Kangin Lee");
		Product idcard2 = factory.create("Heungmin Son");
		Product idcard3 = factory.create("MinJae Kim");
		idcard1.use();
		idcard2.use();
		idcard3.use();
		System.out.println("");
		
		Factory foodfactory = new FishBreadFactory();
		Product fishbread1 = foodfactory.create("팥");
		Product fishbread2 = foodfactory.create("슈크림");
		Product fishbread3 = foodfactory.create("반반");		
		fishbread1.use();
		fishbread2.use();
		fishbread3.use();
		
	}

}
