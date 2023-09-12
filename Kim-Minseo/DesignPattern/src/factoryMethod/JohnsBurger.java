package factoryMethod;

/**
 * JohnsBurger 추상 클래스는 버거 주문과 생성을 관리하는 팩토리 메소드를 포함합니다.
 */
abstract class JohnsBurger {
    /**
     * 주어진 버거 유형에 따라 버거를 주문하고 생성하는 메소드입니다.
     *
     * @param type 주문하려는 버거의 유형
     * @return 생성된 버거 객체
     */
    public Hamburger orderBurger(String type) {
        Hamburger hamburger = createBurger(type);
        hamburger.serve();
        return hamburger;
    }

    /**
     * 구체적인 팩토리 서브클래스에서 구현해야 하는 팩토리 메소드입니다.
     * 주어진 유형에 따라 적절한 버거를 생성합니다.
     *
     * @param type 생성할 버거의 유형
     * @return 생성된 버거 객체
     */
    abstract Hamburger createBurger(String type);
}