package factoryMethod.bread;

import factoryMethod.framework.Product;

public class Bread implements Product {

	private String type;

	Bread(String type) {
		System.out.println(type + "이라는 빵을 만들기로 했어요.");
		this.type = type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void make() {
		System.out.println("짠! " + this + "이라는 빵을 만들었습니다!");
	}

	@Override
	public String toString() {
		return "Bread{" +
			"type='" + type + '\'' +
			'}';
	}
}