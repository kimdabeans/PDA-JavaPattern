package framework;

/**
 * 객체를 생성하는 메서드를 정의하는 추상 Factory 클래스입니다.
 */
public abstract class Factory {
    /**
     * 제품을 생성합니다.
     *
     * @param owner 제품의 소유자 정보.
     * @return 생성된 제품.
     */
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    /**
     * 구체적인 제품을 생성합니다.
     *
     * @param owner 제품의 소유자 정보.
     * @return 생성된 제품.
     */
    protected abstract Product createProduct(String owner);

    /**
     * 제품을 등록합니다.
     *
     * @param product 등록할 제품.
     */
    protected abstract void registerProduct(Product product);
}
