package factory_method_pattern.after;

/**
 * 주식 클래스는 Product 클래스를 상속받아 주식 제품을 구현합니다.
 *
 * @author Lee Eunji
 */
public class Stock extends Product {
    private String name;

    /**
     * 주식 제품을 생성하는 생성자입니다.
     *
     * @param name 주식의 이름
     */
    public Stock(String name) {
        this.name = name;
    }

    @Override
    public void use() {
        System.out.println("증권을 매수합니다. (이름: " + name + ")");
    }

    @Override
    public void explain() {
        System.out.println("증권은 자본금 증식 및 배당금 수익을 제공합니다.");
    }
}
