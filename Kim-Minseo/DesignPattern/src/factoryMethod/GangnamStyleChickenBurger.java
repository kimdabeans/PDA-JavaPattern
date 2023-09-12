package factoryMethod;

/**
 * GangnamStyleChickenBurger 클래스는 John's Burger 강남점에서 제공되는 치킨 버거를 나타내는 클래스입니다.
 * Hamburger 클래스를 상속하며, 치킨 버거를 서빙하는 메서드를 구현합니다.
 */
public class GangnamStyleChickenBurger extends Hamburger {
    /**
     * 치킨 버거를 서빙하는 메서드입니다.
     * 강남점의 치킨 버거에 대한 정보를 출력합니다.
     */
    @Override
    public void serve() {
        System.out.println("John's Burger 강남점의 치킨 버거");
        System.out.println("강남점의 치킨 버거는 꽤나 짭잘합니다.\n");
    }
}