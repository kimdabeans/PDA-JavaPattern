package factoryMethod.bread;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

/**
 * 이 클래스는 빵(Product)을 생성하는 공장(Factory) 클래스입니다.
 * Factory 인터페이스를 구현하여 빵 제품을 생성하고 관리합니다.
 */
public class BreadFactory implements Factory {

	/**
	 * 주어진 유형(type)에 따라 빵(Product)을 생성합니다.
	 *
	 * @param type 생성할 빵의 유형을 나타내는 문자열
	 * @return 생성된 빵(Product) 객체
	 */
	@Override
	public Product planProduct(String type) {
		return new Bread(type);
	}

	/**
	 * 제품을 생산하기 전에 필요한 준비 작업을 수행합니다.
	 *
	 * @param product 생산할 제품(Product) 객체
	 */
	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 빵을 만들 준비했어요.");
	}
}
