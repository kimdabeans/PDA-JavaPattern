package factoryMethod;

/**
 * YongsanStyleBeefBurger 클래스는 John's Burger 용산점에서 제공되는 비프 버거를 나타내는 클래스입니다.
 * Hamburger 클래스를 상속하며, 비프 버거를 서빙하는 메서드를 구현합니다.
 */
public class YongsanStyleBeefBurger extends Hamburger {
    /**
     * 비프 버거를 서빙하는 메서드입니다.
     * 용산점의 비프 버거에 대한 정보를 출력합니다.
     */
    public YongsanStyleBeefBurger() {
    }

    public void serve() {
        System.out.println("John's Burger 용산점의 비프 버거");
        System.out.println("용산점의 비프 버거는 상당히 푸짐합니다.\n");
    }
}