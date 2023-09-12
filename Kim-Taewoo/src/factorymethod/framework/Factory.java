package factorymethod.framework;

/**
 * 상품을 생산하는 공장 추상 클래스 
 */
public abstract class Factory {
	/**
	 * 상품을 생산하는 메서드 
	 * @param name 생산할 상품의 이름 
	 * @return 생산된 상품 
	 */
	public final Product create(String name) {
		return createProduct(name);
	}
	/**
	 * 내부적으로 상품을 생성하는 추상 메서드 
	 * @param name 생성할 상품의 이름 
	 * @return 생성된 상품 
	 */
	protected abstract Product createProduct (String name);
}
