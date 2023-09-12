package factoryMethod.bread;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

public class BreadFactory implements Factory {

	@Override
	public Product planProduct(String type) {
		return new Bread(type);
	}

	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 빵을 만들 준비했어요.");
	}
}
