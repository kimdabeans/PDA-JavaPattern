package factoryMethod;

/**
 * JohnsBurgerYongsan 클래스는 Yongsan 지점에서 제공되는 햄버거 생성을 관리하는 팩토리 서브클래스입니다.
 */
public class JohnsBurgerYongsan extends JohnsBurger {
    /**
     * 주어진 버거 유형에 따라 Yongsan 지점에서 햄버거를 생성하는 메소드입니다.
     *
     * @param type 생성할 버거의 유형 (치킨 또는 비프)
     * @return 생성된 Yongsan 스타일 햄버거 객체
     */
    @Override
    Hamburger createBurger(String type) {
        if ("chicken".equals(type)) {
            return new YongsanStyleChickenBurger();
        } else if ("beef".equals(type)) {
            return new YongsanStyleBeefBurger();
        }
        return null;
    }
}