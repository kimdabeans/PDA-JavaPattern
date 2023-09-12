package framework;

/**
 * Factory에서 만들고자 하는 새로운 Product를 생성할 때, 부모 클래스로서 사용합니다.
 */
public abstract class Product {
	/**
	 * Product의 사용 결과를 콘솔에 출력합니다.
	 */
	public abstract void use();
}
