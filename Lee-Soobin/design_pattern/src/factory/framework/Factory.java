package factory.framework;

/**
 * 제품 생성 및 등록을 위한 추상 팩토리 클래스.
 * 구체적인 제품 생성은 하위 클래스에서 구현되어야 합니다.
 */
public abstract class Factory {

    /**
     * 제품을 생성하고 등록한 후, 생성된 제품을 반환합니다.
     * @param owner 제품의 소유주 정보
     * @return 생성된 Product 객체
     */
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    /**
     * 제품을 생성하는 추상 메서드. 하위 클래스에서 구현되어야 합니다.
     * @param owner 제품의 소유주 정보
     * @return Product 객체
     */
    protected abstract Product createProduct(String owner);

    /**
     * 생성된 제품을 등록하는 추상 메서드. 하위 클래스에서 구현되어야 합니다.
     * @param product 생성된 Product 객체
     */
    protected abstract void registerProduct(Product product);
}