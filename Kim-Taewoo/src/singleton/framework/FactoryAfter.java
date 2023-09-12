package singleton.framework;

/**
 * 패턴 적용 후의 Factory 추상 클래스 
 */
public abstract class FactoryAfter {
	/**
	 * 상품을 생산하는 메서드 
	 * @param name 상품 생산을 위한 이름 
	 * @return 생산된 상품 
	 */
	public final ProductAfter create(String name) {
		return createProduct(name);
	}
	/**
	 * 내부적으로 상품을 생성하는 메서드 
	 * @param name 생성할 상품의 이름 
	 * @return 생성된 상품 
	 */
	protected abstract ProductAfter createProduct(String name);
	/**
	 * 생산 기록을 하는 메서드 
	 * @param log 기록할 로그 
	 */
	public abstract void logging(ProductAfter product);
}
