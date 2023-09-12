package factoryMethodWithSingleton;

import factoryMethodWithSingleton.bread.BreadFactory;
import factoryMethodWithSingleton.framework.Factory;
import factoryMethodWithSingleton.framework.Product;
import factoryMethodWithSingleton.snack.SnackFactory;

/**
 * 이 클래스는 팩토리 메서드 패턴과 싱글톤 패턴을 사용하여 과자와 빵을 생산하는 공장을 시뮬레이션하는 메인 애플리케이션입니다.
 */
public class Main {

	/**
	 * 메인 메서드는 과자와 빵을 생산하는 두 가지 공장을 시뮬레이션합니다.
	 */
	public static void main(String[] args) {

		System.out.println("================== 과자 공장 ==================");
		Factory snackFactory = SnackFactory.getInstance();
		Product popcorn = snackFactory.create("Popcorn");
		Product nachos = snackFactory.create("Nachos");
		popcorn.make();
		nachos.make();

		System.out.println("================== 빵 공장 ==================");
		Factory breadFactory = BreadFactory.getInstance();
		Product pastry = breadFactory.create("Pastry");
		Product sandwich = breadFactory.create("Sandwich");
		pastry.make();
		sandwich.make();
	}
}
