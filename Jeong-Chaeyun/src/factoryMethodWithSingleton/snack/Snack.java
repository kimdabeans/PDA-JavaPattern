package factoryMethodWithSingleton.snack;

import factoryMethodWithSingleton.framework.Product;

/**
 * 이 클래스는 과자를 나타내는 공장 메서드 패턴의 제품 클래스입니다.
 * 각각 다른 유형의 과자를 생성할 수 있습니다.
 */
public class Snack implements Product {

	private final String type;

	/**
	 * 과자 객체를 생성하는 생성자입니다.
	 *
	 * @param type 과자의 유형을 나타내는 문자열
	 */
	Snack(String type) {
		System.out.println(type + "이라는 과자를 만들기로 했어요.");
		this.type = type;
	}

	/**
	 * 과자를 만드는 메서드입니다.
	 */
	@Override
	public void make() {
		System.out.println("짠! " + this + "이라는 과자를 만들었습니다!");
	}

	/**
	 * 과자 객체를 문자열로 표현하는 메서드입니다.
	 *
	 * @return 과자 객체의 문자열 표현
	 */
	@Override
	public String toString() {
		return "Snack{" +
			"type='" + type + '\'' +
			'}';
	}
}