package factory_method_pattern.after;


/**
 * 채권 클래스는 Product 클래스를 상속받아 채권 제품을 구현합니다.
 */
public class Bond extends Product {
    private int maturityYear;

    /**
     * 채권 제품을 생성하는 생성자입니다.
     *
     * @param maturityYear 채권의 만기 연도
     */
    public Bond(int maturityYear) {
        this.maturityYear = maturityYear;
    }

    @Override
    public void use() {
        System.out.println("채권을 매수합니다. (만기 연도: " + maturityYear + ")");
    }

    @Override
    public void explain() {
        System.out.println("채권은 고정수익을 제공합니다.");
    }
}
