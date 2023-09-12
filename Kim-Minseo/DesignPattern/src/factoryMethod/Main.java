package factoryMethod;

/**
 * Main 클래스는 팩토리 메소드 패턴을 활용하여 햄버거 주문 및 생성을 시연하는 클래스입니다.
 */
public class Main {
    /**
     * Main 메서드는 프로그램의 진입점입니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        JohnsBurger yongsanStore = new JohnsBurgerYongsan();
        JohnsBurger gangnamStore = new JohnsBurgerGangnam();

        Hamburger yongsanChickenBurger = yongsanStore.orderBurger("chicken");
        Hamburger yongsanBeefBurger = yongsanStore.orderBurger("beef");
        Hamburger gangnamChickenBurger = gangnamStore.orderBurger("chicken");
        Hamburger gangnamBeefBurger = gangnamStore.orderBurger("beef");

    }
}