import framework.Factory;
import framework.Product;
import icecream.IceCreamFactory;

/**
 * 아이스크림 팩토리를 사용하는 메인 클래스입니다.
 * 이 클래스는 아이스크림 팩토리를 생성하고 아이스크림 제품을 생성하여 사용하는 예제를 제공합니다.
 */
public class Main {
    /**
     * 주 애플리케이션 진입점입니다. 이 메소드에서는 {@link IceCreamFactory} 객체를 생성하고,
     * 아이스크림 제품을 생성하여 사용하는 예제를 수행합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        // 아이스크림 팩토리 생성
        Factory factory = new IceCreamFactory();

        // 아이스크림 제품 생성
        Product iceCream1 = factory.create("초콜릿");
        Product iceCream2 = factory.create("바닐라");

        // 아이스크림 제품 사용
        iceCream1.use(); // 출력: 초콜릿 아이스크림을 즐깁니다!
        iceCream2.use(); // 출력: 바닐라 아이스크림을 즐깁니다!
    }
}
