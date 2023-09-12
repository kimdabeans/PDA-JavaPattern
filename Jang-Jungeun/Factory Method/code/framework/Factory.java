package framework;

/**
 * 추상 Factory 클래스는 제품을 생성하고 등록하는 기능을 제공한다.
 * 이 클래스를 상속받는 하위 클래스에서 구체적인 제품 생성 및 등록 로직을 구현해야 한다.
 * 
 * @author	Jang Jeong Eun
 * @version	1.1, 08 Sep 2023
 */


public abstract class Factory {
    /**
     * 주어진 소유자 정보를 사용하여 제품을 생성하고 등록한 후 해당 제품을 반환한다.
     *
     * @param owner 제품의 소유자 정보
     * @return 생성된 제품
     */
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registerProduct(p);
		return p;
	}
    /**
     * 하위 클래스에서 구체적인 제품 생성 로직을 구현해야 합니다.
     * protected 자기 자식 클래스까지는 유지하며 상속.
     * 
     * @param owner 제품의 소유자 정보
     * @return 생성된 제품
     */
	protected abstract Product createProduct(String owner);
    /**
     * 하위 클래스에서 구체적인 제품 등록 로직을 구현해야 합니다.
     *
     * @param product 등록할 제품
     */
	protected abstract void registerProduct(Product product);
}
