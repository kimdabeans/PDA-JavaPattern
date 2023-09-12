package factoryMethodWithSingleton.snack;

import factoryMethodWithSingleton.framework.Factory;
import factoryMethodWithSingleton.framework.Product;

public class SnackFactory implements Factory {

	private SnackFactory() {
	}

	private static class SingleInstanceHolder {
		private static final SnackFactory INSTANCE = new SnackFactory();
	}

	public static SnackFactory getInstance() {
		return SingleInstanceHolder.INSTANCE;
	}

	@Override
	public Product planProduct(String type) {
		return new Snack(type);
	}

	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 과자를 만들 준비했어요.");
	}
}
