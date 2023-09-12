package proxy;
/**
 * 이 클래스는 프록시 패턴을 사용하여 이미지 출력 예제를 제공합니다.
 * Main 클래스는 프록시 이미지 객체를 생성하고 클라이언트 객체에 주입하여 이미지 출력을 관리합니다.
 */

public class Main {
    /**
     * 프로그램의 진입점입니다.
     * 첫 번째 이미지 출력은 프록시에서 이미지를 로드합니다.
     * 두 번째 이미지 출력은 프록시에 이미지가 이미 로드되어 있으므로 다시 로드하지 않습니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        ProxyImage proxy = new ProxyImage("chickenBurgerImage");
        Homepage homepage = new Homepage(proxy);

        homepage.draw();
        homepage.draw();
    }
}