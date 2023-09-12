package factory_method_pattern.before;

/**
 * 이 클래스는 간단한 금융 상품을 나타내는 클래스입니다.
 * 주어진 종류(type)에 따라 다양한 금융 상품을 생성하고 사용합니다.
 */
public class Product {
    private String type;

    /**
     * 금융 상품의 종류를 설정합니다.
     *
     * @param type 금융 상품의 종류를 나타내는 문자열
     */
    public Product(String type) {
        this.type = type;
    }

    /**
     * 금융 상품을 사용합니다. 종류(type)에 따라 다른 동작을 수행합니다.
     *
     * @see Product#explain()
     */
    public void use() {
        if (type.equalsIgnoreCase("Stock")) {
            System.out.println("증권을 매수합니다.");
        } else if (type.equalsIgnoreCase("Bond")) {
            System.out.println("채권을 매수합니다.");
        } else if (type.equalsIgnoreCase("Fund")) {
            System.out.println("펀드를 매수합니다.");
        }
    }

    /**
     * 금융 상품에 대한 설명을 출력합니다. 종류(type)에 따라 다른 설명을 제공합니다.
     *
     * @see Product#use()
     */
    public void explain() {
        if (type.equalsIgnoreCase("Stock")) {
            System.out.println("증권은 자본금 증식 및 배당금 수익을 제공합니다.");
        } else if (type.equalsIgnoreCase("Bond")) {
            System.out.println("채권은 고정수익을 제공합니다.");
        } else if (type.equalsIgnoreCase("Fund")) {
            System.out.println("펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.");
        }
    }
}