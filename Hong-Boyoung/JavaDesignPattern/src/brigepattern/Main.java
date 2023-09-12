package brigepattern;
/**
 * 브릿지 패턴(Bridge Pattern)을 활용한 예제의 메인 클래스.
 *
 * 이 클래스는 여러 종류의 의류를 선택하고 주문 및 결제 등 다양한 서비스 작업을 수행하는 예제를 실행합니다.
 */
public class Main {
    /**
     * 메인 메서드. 여러 종류의 의류를 선택하고 주문 및 결제 등 다양한 작업을 수행하는 예제를 실행합니다.
     *
     * @param args 명령행 인수 (사용하지 않음).
     */
    public static void main(String[] args) {
        // 상의(Tops) 선택 및 주문 처리 수행 예제
        Clothes tops=new Tops();
        tops.addShoppingService(new CartService());
        tops.addShoppingService(new OrderService());
        tops.addShoppingService(new PaymentService());
        tops.selectService();

        // 하의(Bottoms) 선택 및 주문 처리 수행 예제
        Clothes bottoms=new Bottoms();
        bottoms.addShoppingService(new CartService());
        bottoms.addShoppingService(new OrderService());
        bottoms.addShoppingService(new InvoiceService());
        bottoms.addShoppingService(new PaymentService());
        bottoms.selectService();

        // 아우터(Outers) 선택 및 주문 처리 수행 예제
        Clothes outers=new Outers();
        outers.addShoppingService(new ShippingService());
        outers.addShoppingService(new OrderService());
        outers.addShoppingService(new PaymentService());
        outers.selectService();
    }

}
