package factoryMethodWithSingleton.bread;

import factoryMethodWithSingleton.framework.Product;

/**
 * 이 클래스는 빵을 나타내는 구체적인 제품(Product) 클래스입니다.
 * 특정 유형(type)의 빵을 만들고 관리합니다.
 */
public class Bread implements Product {

	private final String type;

	/**
	 * 새로운 빵 객체를 생성하고 주어진 유형(type)의 빵을 만듭니다.
	 *
	 * @param type 빵의 유형을 나타내는 문자열
	 */
	Bread(String type) {
		System.out.println(type + "이라는 빵을 만들기로 했어요.");
		this.type = type;
	}

	/**
	 * 빵을 만드는 작업을 수행합니다.
	 */
	@Override
	public void make() {
		System.out.println("짠! " + this + "이라는 빵을 만들었습니다!");
	}

	/**
	 * 현재 빵 객체를 문자열로 표현합니다.
	 *
	 * @return 빵 객체의 문자열 표현
	 */
	@Override
	public String toString() {
		return "Bread{" +
			"type='" + type + '\'' +
			'}';
	}
}