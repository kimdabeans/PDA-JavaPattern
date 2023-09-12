package Factory.securities;

import Factory.framework.Factory;
import Factory.framework.Product;
/**
 * SecuritiesFactory 클래스입니다.
 * Factory 클래스를 상속 받았으며, 증권 상품을 생성하는 클래스입니다.
 */
public class SecuritiesFactory extends Factory {
    /**
     * 주어진 소유자(owner)와 제품(product) 정보를 사용하여 Securities 클래스의 인스턴스를 생성합니다.
     *
     * @param owner   소유자 정보
     * @param product 제품 정보
     */
    @Override
    protected Product createProduct(String owner, String product) {
        return new Securities(owner, product);
    }
    /**
     * 생성된 증권 상품을 등록하는 메서드입니다.
     *
     * @param product 등록할 제품(Product) 객체
     */
    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "has been registered.");
    }
}
