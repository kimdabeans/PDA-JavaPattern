package icecream;

import framework.Product;

/**
 * 아이스크림을 나타내는 구체적인 제품 클래스입니다.
 */
public class IceCream extends Product {
    private String flavor;

    /**
     * 특정 맛의 아이스크림을 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     */
    public IceCream(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 아이스크림을 사용합니다.
     */
    @Override
    public void use() {
        System.out.println(flavor + " 아이스크림을 즐깁니다!");
    }

    /**
     * 아이스크림의 맛을 반환합니다.
     *
     * @return 아이스크림의 맛 정보.
     */
    public String getFlavor() {
        return flavor;
    }
}
