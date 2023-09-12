package factoryMethod;

/**
 * YongsanStyleChickenBurger 클래스는 John's Burger 용산점에서 제공되는 치킨 버거를 나타내는 클래스입니다.
 * Hamburger 클래스를 상속하며, 치킨 버거를 서빙하는 메서드를 구현합니다.
 */
public class YongsanStyleChickenBurger extends Hamburger {

    public YongsanStyleChickenBurger() {
    }

    public void serve() {
        System.out.println("John's Burger 용산점의 치킨 버거");
        System.out.println("용산점의 치킨 버거는 담백합니다.\n");
    }
}