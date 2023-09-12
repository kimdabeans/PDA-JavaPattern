package brigepattern;
/**
 * 의류 중 하의(Bottoms)를 나타내는 클래스입니다.
 *
 * 이 클래스는 {@link Clothes} 클래스를 상속하여 하의 주문 및 결제 작업을 관리합니다.
 */
public class Bottoms extends Clothes {
    /**
     * 하의 선택 및 주문을 처리하는 메서드입니다.
     *
     * 작업은 등록된 {@link ShoppingService} 인터페이스를 구현한 서비스에서 수행됩니다.
     */
    @Override
    public void selectService() {
        System.out.println("하의 선택");
        shoppingServices.stream().forEach(shoppingService -> shoppingService.work(this));
        System.out.println("완료.");
        System.out.println();
    }
    /**
     * 걸리는 작업 시간을 반환하는 메서드입니다.
     *
     * @return 작업 시간 (분 단위)
     */
    @Override
    public int takeTime() {
        return 20;
    }

}

