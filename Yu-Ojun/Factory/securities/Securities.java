package Factory.securities;

import Factory.framework.Product;
/**
 * Securities 클래스입니다.
 * Product 클래스를 상속 받았으며, 증권 상품을 나타내는 클래스입니다.
 */
public class Securities extends Product {
    private String owner;
    private String product;
    /**
     * 주어진 소유자(owner)와 제품(product) 정보를 사용하여 Securities 클래스의 인스턴스를 생성하는 생성자입니다.
     *
     * @param owner   소유자 정보
     * @param product 제품 정보
     */
    Securities(String owner, String product){
        System.out.println("Make " + owner + "'s account");
        this.owner = owner;
        this.product = product;
    }
    /**
     * 제품을 사용하는 메서드입니다.
     */
    @Override
    public void use() {
        System.out.println(getOwner() +"'s " + getProduct() + " use.");
    }
    /**
     * 제품 정보를 문자열로 반환합니다.
     *
     * @return 제품 정보를 나타내는 문자열
     */
    @Override
    public String toString() {
        return "[Product:" + getProduct() + "] ";
    }
    /**
     * 소유자 정보를 반환합니다.
     *
     * @return 소유자 정보
     */
    public String getOwner() {
        return owner;
    }
    /**
     * 제품 정보를 반환합니다.
     *
     * @return 제품 정보
     */
    public String getProduct() {
        return product;
    }
}
