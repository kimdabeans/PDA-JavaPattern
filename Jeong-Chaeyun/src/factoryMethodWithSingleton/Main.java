package factoryMethodWithSingleton;

import factoryMethodWithSingleton.bread.BreadFactory;
import factoryMethodWithSingleton.framework.Factory;
import factoryMethodWithSingleton.framework.Product;
import factoryMethodWithSingleton.snack.SnackFactory;

public class Main {

	public static void main(String[] args) {

		Factory snackFactory = SnackFactory.getInstance();

		Product popcorn = snackFactory.create("Popcorn");
		Product nachos = snackFactory.create("Nachos");

		popcorn.make();
		nachos.make();

		System.out.println("=========================================");

		Factory breadFactory = BreadFactory.getInstance();

		Product pastry = breadFactory.create("Pastry");
		Product sandwich = breadFactory.create("Sandwich");

		pastry.make();
		sandwich.make();
	}
}
