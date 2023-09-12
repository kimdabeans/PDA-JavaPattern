
/**
 * 이 클래스는 피자 빌더 패턴을 사용하여 다양한 지역 스타일의 피자를 생성하고 출력하는 메인 클래스입니다.
 */
public class Main {
    /**
     * 메인 메서드에서는 ChicagoPizzaBuilder와 NewYorkPizzaBuilder를 사용하여 피자를 빌드하고 출력합니다.
     *
     * @param args 커맨드 라인 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        Pizza pizza = new Pizza();

        PizzaBuilder chicagoPizza = new ChicagoPizzaBuilder(pizza);
        Cook cook1 = new Cook(chicagoPizza);
        String pizza1 = cook1.build();
        System.out.println("pizza1 = " + pizza1);

        PizzaBuilder newyorkPizza = new NewYorkPizzaBuilder(pizza);
        Cook cook2 = new Cook(newyorkPizza);
        String pizza2 = cook2.build();
        System.out.println("pizza2 = " + pizza2);
    }
}
