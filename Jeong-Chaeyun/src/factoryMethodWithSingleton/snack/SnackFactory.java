package factoryMethodWithSingleton.snack;

import factoryMethodWithSingleton.framework.Factory;
import factoryMethodWithSingleton.framework.Product;

/**
 * 이 클래스는 과자를 생산하는 공장을 나타내는 싱글톤 패턴을 사용한 팩토리 클래스입니다.
 */
public class SnackFactory implements Factory {

	// 싱글톤 패턴을 위한 private 생성자
	private SnackFactory() {
	}

	/**
	 * 내부 클래스를 사용한 싱글톤 패턴의 인스턴스 홀더 클래스.
	 * 스레드 안전한 싱글톤 인스턴스 생성을 지원합니다.
	 */
	private static class SingleInstanceHolder {
		private static final SnackFactory INSTANCE = new SnackFactory();
	}

	/**
	 * 과자 공장의 싱글톤 인스턴스를 반환합니다.
	 *
	 * @return 과자 공장의 싱글톤 인스턴스
	 */
	public static SnackFactory getInstance() {
		return SingleInstanceHolder.INSTANCE;
	}

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
