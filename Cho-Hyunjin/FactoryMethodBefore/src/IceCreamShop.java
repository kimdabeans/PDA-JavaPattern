public class IceCreamShop {
    public IceCream orderIceCream(String flavor) {
        IceCream iceCream = createIceCream(flavor);
        prepareIceCream(iceCream);
        return iceCream;
    }

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

    private void prepareIceCream(IceCream iceCream) {
        System.out.println(iceCream.getFlavor() + " 아이스크림을 준비합니다.");
    }

    public static void main(String[] args) {
        IceCreamShop shop = new IceCreamShop();
        IceCream iceCream1 = shop.orderIceCream("초콜릿");
        IceCream iceCream2 = shop.orderIceCream("바닐라");

        iceCream1.eat(); // 출력: 초콜릿 아이스크림을 먹습니다!
        iceCream2.eat(); // 출력: 바닐라 아이스크림을 먹습니다!
    }
}