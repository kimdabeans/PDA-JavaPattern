package templateMethod.before;

/**
 * ChickenBurger 클래스는 구체적인 치킨 버거 제작 과정을 정의하고 있습니다.
 */
public class ChickenBurger {

    /**
     * 치킨 버거를 만드는 일련의 단계를 순차적으로 수행합니다.
     *
     * 1. 치킨 패티를 튀긴다.
     * 2. 빵을 자른다.
     * 3. 토핑을 추가한다.
     * 4. ChickenBurger 포장지로 포장한다.
     */
    void cook() {
        fryChicken();
        cutBread();
        addToppings();
        chickenPackaging();
    }

    public void fryChicken() {
        System.out.println("치킨 패티 튀기기");
    }

    public void cutBread() {
        System.out.println("빵 자르기");
    }

    public void addToppings() {
        System.out.println("토핑 추가하기");
    }

    public void chickenPackaging() {
        System.out.println("ChickenBurger 포장지로 포장하기");
    }
}