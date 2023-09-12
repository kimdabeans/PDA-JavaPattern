
/**
 * 이 클래스는 뉴욕 피자 스타일을 생성하기 위한 피자 빌더 클래스입니다.
 * PizzaBuilder를 상속하여 뉴욕 피자의 도우, 소스, 토핑을 빌드합니다.
 */
public class NewYorkPizzaBuilder extends PizzaBuilder {

    /**
     * NewYorkPizzaBuilder 객체를 생성할 때 주입받은 피자 객체를 사용하여 초기화합니다.
     *
     * @param pizza 생성할 피자 객체
     */
    public NewYorkPizzaBuilder(Pizza pizza) {
        super(pizza);
    }

    /**
     * 뉴욕 피자의 도우를 빌드합니다.
     */
    @Override
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    /**
     * 뉴욕 피자의 소스를 빌드합니다.
     */
    @Override
    public void buildSource() {
        pizza.setSauce("hot");
    }

    /**
     * 뉴욕 피자의 토핑을 빌드합니다.
     */
    @Override
    public void buildTopping() {
        pizza.setTopping("pepperoni");
    }
}
