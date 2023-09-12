package brigepattern;

import java.util.concurrent.TimeUnit;
/**
 * 주문한 의류에 대한 배송정보를 입력하는 클래스.
 *
 * 이 서비스는 주문한 의류에 대한 배송정보를 수집하는 서비스를 수행하며 작업 완료까지의 시간을 계산합니다.
 */
public class ShippingService extends ShoppingService {
    /**
     * 기본 생성자.
     */
    public ShippingService() {
        super();
    }
    /**
     * 주문한 의류에 대한 배송정보를 수집하는 메서드.
     *
     * @param clothes 배송정보를 입력하는 의류 객체
     */
    @Override
    public void work(Clothes clothes) {
        System.out.print("배송지 입력 중... ");
        long timeToTake = 150 * clothes.takeTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake);
        } catch (InterruptedException exp) {
        }
        System.out.printf("(소요 시간: %d 밀리초), 완료.\n", timeToTake);
    }

}

