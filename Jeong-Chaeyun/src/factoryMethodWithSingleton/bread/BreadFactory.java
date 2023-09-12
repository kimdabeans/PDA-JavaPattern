package factoryMethodWithSingleton.bread;

import factoryMethodWithSingleton.framework.Factory;
import factoryMethodWithSingleton.framework.Product;

public class BreadFactory implements Factory {

	private BreadFactory() {
	}

	private static class SingleInstanceHolder {
		private static final BreadFactory INSTANCE = new BreadFactory();
	}

	public static BreadFactory getInstance() {
		return SingleInstanceHolder.INSTANCE;
	}

	@Override
	public Product planProduct(String type) {
		return new Bread(type);
	}

	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 빵을 만들 준비했어요.");
	}
}
