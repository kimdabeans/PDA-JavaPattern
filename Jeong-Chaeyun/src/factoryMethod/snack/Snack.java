package factoryMethod.snack;

import factoryMethod.framework.Product;

public class Snack implements Product {

	private String type;

	Snack(String type) {
		System.out.println(type + "이라는 과자를 만들기로 했어요.");
		this.type = type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void make() {
		System.out.println("짠! " + this + "이라는 과자를 만들었습니다!");
	}

	@Override
	public String toString() {
		return "Snack{" +
			"type='" + type + '\'' +
			'}';
	}
}