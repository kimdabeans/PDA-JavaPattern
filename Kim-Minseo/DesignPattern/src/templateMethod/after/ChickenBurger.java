package templateMethod.after;

/**
 * ChickenBurger 클래스는 햄버거를 만드는 템플릿 메소드 패턴을 활용한 클래스입니다.
 * Hamburger 클래스를 상속하며, Hamburger 클래스의 템플릿 메소드를 구체화합니다.
 */
public class ChickenBurger extends Hamburger {

    /**
     * 치킨 패티를 튀기는 메소드를 구체화합니다.
     */
    @Override
    public void cookPatty() {
        System.out.println("치킨 패티 튀기기");
    }

    /**
     * ChickenBurger를 포장하는 메소드를 구체화합니다.
     */
    @Override
    public void packaging() {
        System.out.println("ChickenBurger 포장지로 포장하기");
    }
}