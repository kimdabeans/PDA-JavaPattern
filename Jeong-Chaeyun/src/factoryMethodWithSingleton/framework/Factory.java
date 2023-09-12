package factoryMethodWithSingleton.framework;

/**
 * 이 인터페이스는 제품(Product)을 생성하는 팩토리(Factory)를 나타내는 인터페이스입니다.
 * 팩토리 메서드를 통해 제품을 생성하고 준비 작업을 수행할 수 있습니다.
 */
public interface Factory {

	/**
	 * 주어진 유형(type)에 따라 제품(Product)을 계획하고 생성합니다.
	 *
	 * @param type 생성할 제품의 유형을 나타내는 문자열
	 * @return 생성된 제품(Product) 객체
	 */
	Product planProduct(String type);

	/**
	 * 제품을 생산하기 전에 필요한 준비 작업을 수행합니다.
	 *
	 * @param product 생산할 제품(Product) 객체
	 */
	void readyProduct(Product product);

	/**
	 * 주어진 유형(type)에 따라 제품(Product)을 생성하고 준비 작업을 수행한 후 반환합니다.
	 *
	 * @param type 생성할 제품의 유형을 나타내는 문자열
	 * @return 생성된 제품(Product) 객체
	 */
	default Product create(String type) {
		Product p = planProduct(type);
		readyProduct(p);
		return p;
	}
}
