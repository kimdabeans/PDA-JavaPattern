package factoryMethodWithSingleton.framework;

/**
 * 이 인터페이스는 제품(Product)을 나타내는 인터페이스입니다.
 * 제품을 만드는 메서드를 정의합니다.
 */
public interface Product {

	/**
	 * 제품을 만드는 작업을 수행합니다.
	 */
	void make();
}