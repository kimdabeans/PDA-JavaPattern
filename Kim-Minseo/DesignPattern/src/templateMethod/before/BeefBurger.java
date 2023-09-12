package templateMethod.before;

/**
 * BeefBurger 클래스는 구체적인 햄버거 제작 과정을 정의하고 있습니다.
 */
public class BeefBurger {

    /**
     * 비프 버거를 만드는 일련의 단계를 순차적으로 수행합니다.
     *
     * 1. 비프 패티를 굽는다.
     * 2. 빵을 자른다.
     * 3. 토핑을 추가한다.
     * 4. BeefBurger 포장지로 포장한다.
     */
    void cook() {
        grillBeef();
        cutBread();
        addToppings();
        beefPackaging();
    }

    public void grillBeef() {
        System.out.println("비프 패티 굽기");
    }

    public void cutBread() {
        System.out.println("빵 자르기");
    }

    public void addToppings() {
        System.out.println("토핑 추가하기");
    }

    public void beefPackaging() {
        System.out.println("BeefBurger 포장지로 포장하기");
    }
}