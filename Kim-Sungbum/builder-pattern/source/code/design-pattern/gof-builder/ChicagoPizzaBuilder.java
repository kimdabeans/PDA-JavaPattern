
/**
 * 이 클래스는 시카고 피자 스타일을 생성하기 위한 피자 빌더 클래스입니다.
 * PizzaBuilder를 상속하여 시카고 피자의 도우, 소스, 토핑을 빌드합니다.
 */
public class ChicagoPizzaBuilder extends PizzaBuilder {

    /**
     * ChicagoPizzaBuilder 객체를 생성할 때 주입받은 피자 객체를 사용하여 초기화합니다.
     *
     * @param pizza 생성할 피자 객체
     */
    public ChicagoPizzaBuilder(Pizza pizza) {
        super(pizza);
    }

    /**
     * 시카고 피자의 도우를 빌드합니다.
     */
    @Override
    public void buildDough() {
        pizza.setDough("thick");
    }

    /**
     * 시카고 피자의 소스를 빌드합니다.
     */
    @Override
    public void buildSource() {
        pizza.setSauce("mild");
    }

    /**
     * 시카고 피자의 토핑을 빌드합니다.
     */
    @Override
    public void buildTopping() {
        pizza.setTopping("cheese");
    }
}
