package factoryMethodWithSingleton.bread;

import factoryMethodWithSingleton.framework.Factory;
import factoryMethodWithSingleton.framework.Product;

/**
 * 이 클래스는 빵을 생산하는 공장을 나타내는 싱글톤 패턴을 사용한 팩토리 클래스입니다.
 */
public class BreadFactory implements Factory {

	// 싱글톤 패턴을 위한 private 생성자
	private BreadFactory() {
	}

	/**
	 * 내부 클래스를 사용한 싱글톤 패턴의 인스턴스 홀더 클래스.
	 * 스레드 안전한 싱글톤 인스턴스 생성을 지원합니다.
	 */
	private static class SingleInstanceHolder {
		private static final BreadFactory INSTANCE = new BreadFactory();
	}

	/**
	 * 빵 공장의 싱글톤 인스턴스를 반환합니다.
	 *
	 * @return 빵 공장의 싱글톤 인스턴스
	 */
	public static BreadFactory getInstance() {
		return SingleInstanceHolder.INSTANCE;
	}

	/**
	 * 빵 생산 계획을 기반으로 새로운 빵 제품을 생성합니다.
	 *
	 * @param type 빵의 유형을 나타내는 문자열
	 * @return 새로 생성된 빵 제품 객체
	 */
	@Override
	public Product planProduct(String type) {
		return new Bread(type);
	}

	/**
	 * 빵 제품을 생산하기 전에 준비 작업을 수행합니다.
	 *
	 * @param product 빵 제품 객체
	 */
	@Override
	public void readyProduct(Product product) {
		System.out.println(product + "이라는 빵을 만들 준비했어요.");
	}
}
