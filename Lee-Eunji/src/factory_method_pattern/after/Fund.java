package factory_method_pattern.after;

/**
 * 펀드 클래스는 Product 클래스를 상속받아 펀드 제품을 구현합니다.
 */
public class Fund extends Product {
    private String strategy;

    /**
     * 펀드 제품을 생성하는 생성자입니다.
     *
     * @param strategy 펀드의 전략
     */
    public Fund(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public void use() {
        System.out.println("펀드를 매수합니다. (전략: " + strategy + ")");
    }

    @Override
    public void explain() {
        System.out.println("펀드는 포트폴리오 분산 및 수익 증식을 제공합니다.");
    }
}
