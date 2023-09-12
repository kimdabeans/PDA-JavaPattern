package framework;

/**
 * 특정 Product를 생성하고자하는 Factory를 생성할 때, 부모 클래스로서 사용합니다.
 */
public abstract class Factory {
	/**
	 * Product의 생성 및 등록 과정을 통합하여 수행합니다.
	 * 
	 * @param owner Product의 주체 또는 소유자 정보입니다.
	 * @return 생성 및 등록된 Product p를 리턴합니다.
	 */
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
	
	/**
	 * Product를 생성합니다.
	 * 
	 * @return 새롭게 동적 할당하여 생성한 Product를 리턴합니다.
	 */
	protected abstract Product createProduct(String pname);
	
	/**
	 * Product를 등록합니다.
	 * Product에 따라서 서로 다른 등록 결과를 콘솔에 출력합니다.
	 */
	protected abstract void registerProduct(Product product);
}
