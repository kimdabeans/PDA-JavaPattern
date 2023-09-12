package singleton.framework;

/**
 * 패턴 적용 전의 Factory 추상 클래스 
 */
public abstract class FactoryBefore {
	/**
	 * 상품을 생산하는 메서드 
	 * @param name 상품 생산을 위한 이름 
	 * @return 생산된 상품 
	 */
	public final ProductBefore create(String name) {
		return createProduct(name);
	}
	/**
	 * 내부적으로 상품을 생성하는 메서드 
	 * @param name 생성할 상품의 이름 
	 * @return 생성된 상품 
	 */
	protected abstract ProductBefore createProduct(String name);
	/**
	 * 생산기록을 기록할 메서드 
	 * @param product 생산기록 시 생성되는 상품 
	 */
	public abstract void logging(ProductBefore product);
}
