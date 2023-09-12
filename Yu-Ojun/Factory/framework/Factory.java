package Factory.framework;
/**
 * Factory 클래스입니다.
 * 추상 클래스이며, 이 클래스를 상속하여 구체적인 클래스를 정의하면, 제품을 생성하고 등록할 수 있습니다.
 */
public abstract class Factory {
    /**
     * 제품을 생성 및 등록을 수행하는 메서드입니다.
     *
     * @param owner   제품 소유자 이름
     * @param product 제품 정보
     * @return 생성된 제품(Product) 객체
     */
    public final Product create(String owner, String product){
        Product p = createProduct(owner, product);
        registerProduct(p);
        return p;
    }
    /**
     * 구체적인 제품을 생성하는 추상 메서드입니다.
     *
     * @param owner   제품 소유자 정보
     * @param product 제품 정보
     * @return 생성된 제품(Product) 객체
     */
    protected abstract Product createProduct(String owner, String product);
    /**
     * 생성된 제품을 등록하는 추상 메서드입니다.
     *
     * @param product 등록할 제품(Product) 객체
     */
    protected abstract void registerProduct(Product product);
}
