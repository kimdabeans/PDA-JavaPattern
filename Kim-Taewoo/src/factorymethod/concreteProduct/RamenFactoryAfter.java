package factorymethod.concreteProduct;

import factorymethod.framework.Factory;
import factorymethod.framework.Product;

/**
 * 패턴을 적용한 라면 생산 공장 
 */
public class RamenFactoryAfter extends Factory {
	/**
	 * 라면 상품을 생산하는 메서드
	 * @return 생산된 라면 
	 */
	@Override
	protected Product createProduct(String name) {
		// TODO Auto-generated method stub
		return new RamenAfter(name);
	}

}
