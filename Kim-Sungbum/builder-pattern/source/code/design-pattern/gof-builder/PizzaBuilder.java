
/**
 * 이 추상 클래스는 피자 객체를 생성하는 빌더 패턴의 기반 클래스입니다.
 */
@Getter
public abstract class PizzaBuilder {
    /**
     * 생성되는 피자 객체를 나타내는 인스턴스 변수입니다.
     */
    protected Pizza pizza;

    /**
     * PizzaBuilder 객체를 생성할 때 주입받은 피자 객체를 사용하여 초기화합니다.
     *
     * @param pizza 생성할 피자 객체
     */
    public PizzaBuilder(Pizza pizza) {
        this.pizza = pizza;
    }

    /**
     * 피자의 도우를 빌드하는 추상 메서드입니다.
     */
    public abstract void buildDough();

    /**
     * 피자의 소스를 빌드하는 추상 메서드입니다.
     */
    public abstract void buildSource();

    /**
     * 피자의 토핑을 빌드하는 추상 메서드입니다.
     */
    public abstract void buildTopping();
}
