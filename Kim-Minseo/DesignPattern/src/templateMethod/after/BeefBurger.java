package templateMethod.after;

/**
 * BeefBurger 클래스는 햄버거를 만드는 템플릿 메소드 패턴을 활용한 클래스입니다.
 * Hamburger 클래스를 상속하며, Hamburger 클래스의 템플릿 메소드를 구체화합니다.
 */
public class BeefBurger extends Hamburger {

    /**
     * 고기 패티를 굽는 메소드를 구체화합니다.
     */
    @Override
    public void cookPatty() {
        System.out.println("고기 패티 굽기");
    }

    /**
     * BeefBurger를 포장하는 메소드를 구체화합니다.
     */
    @Override
    public void packaging() {
        System.out.println("BeefBurger 포장지로 포장하기");
    }
}