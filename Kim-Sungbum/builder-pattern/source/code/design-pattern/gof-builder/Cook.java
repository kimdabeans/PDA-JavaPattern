
/**
 * 이 클래스는 피자 빌더를 사용하여 피자를 조리하는 역할을 하는 클래스입니다.
 */
@Getter
public class Cook {
    /**
     * 사용할 피자 빌더를 나타내는 멤버 변수입니다.
     */
    private PizzaBuilder pizzaBuilder;

    /**
     * Cook 객체를 생성할 때 주입받은 피자 빌더를 사용하여 초기화합니다.
     *
     * @param pizzaBuilder 사용할 피자 빌더
     */
    public Cook(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    /**
     * 주어진 피자 빌더를 사용하여 피자를 빌드하고 그 결과를 문자열로 반환합니다.
     *
     * @return 빌드된 피자 정보를 나타내는 문자열
     */
    public String build() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSource();
        pizzaBuilder.buildTopping();

        return pizzaBuilder.getPizza().toString();
    }
}
