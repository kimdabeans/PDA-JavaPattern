package templateMethod.after;

/**
 * Main 클래스는 템플릿 메소드 패턴을 활용한 햄버거 제작 예시를 보여줍니다.
 */
public class Main {
    /**
     * Main 메서드는 프로그램의 진입점입니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        Hamburger chickenBurger = new ChickenBurger();
        Hamburger beefBurger = new BeefBurger();

        chickenBurger.cook();
        System.out.println("");
        beefBurger.cook();
    }
}