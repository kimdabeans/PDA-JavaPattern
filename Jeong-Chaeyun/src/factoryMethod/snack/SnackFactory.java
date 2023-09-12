package factoryMethod.snack;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

public class SnackFactory implements Factory {

	@Override
	public Product planProduct(String type) {
		return new Snack(type);
	}

	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 과자를 만들 준비했어요.");
	}
}
