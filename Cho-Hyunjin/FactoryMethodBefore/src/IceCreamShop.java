/**
 * 아이스크림을 주문하고 제공하는 아이스크림 가게 클래스입니다.
 */
public class IceCreamShop {
    /**
     * 주어진 맛의 아이스크림을 주문하고 반환합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     * @return 주문한 아이스크림 객체.
     * @throws IllegalArgumentException 지원하지 않는 아이스크림 맛을 주문한 경우 발생합니다.
     */
    public IceCream orderIceCream(String flavor) {
        IceCream iceCream = createIceCream(flavor);
        prepareIceCream(iceCream);
        return iceCream;
    }

    /**
     * 주어진 맛에 따라 아이스크림 객체를 생성합니다.
     *
     * @param flavor 아이스크림의 맛 정보.
     * @return 생성된 아이스크림 객체.
     * @throws IllegalArgumentException 지원하지 않는 아이스크림 맛을 주문한 경우 발생합니다.
     */
    private IceCream createIceCream(String flavor) {
        switch (flavor) {
            case "초콜릿":
                return new ChocolateIceCream();
            case "바닐라":
                return new VanillaIceCream();
            default:
                throw new IllegalArgumentException("지원하지 않는 아이스크림 맛입니다: " + flavor);
        }
    }

    /**
     * 주어진 아이스크림을 준비하는 동작을 나타냅니다.
     *
     * @param iceCream 준비할 아이스크림 객체.
     */
    private void prepareIceCream(IceCream iceCream) {
        System.out.println(iceCream.getFlavor() + " 아이스크림을 준비합니다.");
    }

    /**
     * 주 애플리케이션 진입점입니다. 아이스크림 가게를 생성하고 아이스크림을 주문하는 예제를 수행합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        IceCreamShop shop = new IceCreamShop();
        IceCream iceCream1 = shop.orderIceCream("초콜릿");
        IceCream iceCream2 = shop.orderIceCream("바닐라");

        iceCream1.eat(); // 출력: 초콜릿 아이스크림을 먹습니다!
        iceCream2.eat(); // 출력: 바닐라 아이스크림을 먹습니다!
    }
}