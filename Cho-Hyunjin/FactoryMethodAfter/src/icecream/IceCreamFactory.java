package icecream;

import framework.Factory;
import framework.Product;

/**
 * 아이스크림 제품을 생성하는 구체적인 팩토리 클래스입니다.
 */
public class IceCreamFactory extends Factory {
    /**
     * 특정 맛의 아이스크림 제품을 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     * @return 생성된 아이스크림 제품.
     */
    @Override
    protected Product createProduct(String flavor) {
        return new IceCream(flavor);
    }

    /**
     * 아이스크림 제품을 등록합니다.
     *
     * @param product 등록할 아이스크림 제품.
     */
    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 아이스크림 데이터베이스에 등록했습니다.");
    }
}
