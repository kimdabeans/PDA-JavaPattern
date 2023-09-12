package factorymethod.concreteProduct;

import factorymethod.framework.Factory;
import factorymethod.framework.Product;

/**
 * 패턴을 적용한 신라면 생산 공장 
 */
public class ShinRamenFactoryAfter extends Factory {
	/**
	 * 신라면 상품을 생산하는 메서드
	 * @return 생산된 신라면 
	 */
	@Override
	protected Product createProduct(String name) {
		// TODO Auto-generated method stub
		return new ShinRamenAfter(name);
	}

}
