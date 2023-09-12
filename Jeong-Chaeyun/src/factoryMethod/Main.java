package factoryMethod;

import factoryMethod.bread.BreadFactory;
import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;
import factoryMethod.snack.SnackFactory;

public class Main {

	public static void main(String[] args) {

		System.out.println("================== 과자 공장 ==================");
		Factory snackFactory = new SnackFactory();
		Product popcorn = snackFactory.create("Popcorn");
		Product nachos = snackFactory.create("Nachos");
		popcorn.make();
		nachos.make();

		System.out.println("================== 빵 공장 ==================");
		Factory breadFactory = new BreadFactory();
		Product pastry = breadFactory.create("Pastry");
		Product sandwich = breadFactory.create("Sandwich");
		pastry.make();
		sandwich.make();
	}
}
