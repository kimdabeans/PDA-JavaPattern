package factoryMethod.snack;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

/**
 * 이 클래스는 과자를 생산하는 공장을 나타내는 팩토리 클래스입니다.
 * Factory 인터페이스를 구현하여 과자 생산을 관리합니다.
 */
public class SnackFactory implements Factory {

	/**
	 * 과자 생산 계획을 기반으로 새로운 과자 제품을 생성합니다.
	 *
	 * @param type 과자의 유형을 나타내는 문자열
	 * @return 새로 생성된 과자 제품 객체
	 */
	@Override
	public Product planProduct(String type) {
		return new Snack(type);
	}

	/**
	 * 과자 제품을 생산하기 전에 준비 작업을 수행합니다.
	 *
	 * @param product 과자 제품 객체
	 */
	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 과자를 만들 준비했어요.");
	}
}
