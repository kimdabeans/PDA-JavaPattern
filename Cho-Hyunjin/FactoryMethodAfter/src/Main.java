import framework.Factory;
import framework.Product;
import icecream.IceCreamFactory;

/**
 * 아이스크림 팩토리를 사용하는 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new IceCreamFactory();
        Product iceCream1 = factory.create("초콜릿");
        Product iceCream2 = factory.create("바닐라");

        iceCream1.use(); // 출력: 초콜릿 아이스크림을 즐깁니다!
        iceCream2.use(); // 출력: 바닐라 아이스크림을 즐깁니다!
    }
}
