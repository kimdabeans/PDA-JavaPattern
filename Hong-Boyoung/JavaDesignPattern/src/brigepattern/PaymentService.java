package brigepattern;

import java.util.concurrent.TimeUnit;
/**
 * 결제를 처리하는 서비스에 대한 클래스.
 *
 * 이 서비스는 의류 선택 후 결제를 처리하는 서비스를 수행하며 작업 완료까지의 시간을 계산합니다.
 */
public class PaymentService extends ShoppingService {
    /**
     * 기본 생성자.
     */
    public PaymentService() {
        super();
    }
    /**
     * 주문한 의류에 대한 결제를 처리하는 메서드.
     *
     * @param clothes 주문한 의류에 대한 결제를 처리하는 객체
     */
    @Override
    public void work(Clothes clothes) {
        System.out.print("결제처리 중... ");
        long timeToTake = 50 * clothes.takeTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake);
        } catch (InterruptedException exp) {
        }
        System.out.printf("(소요 시간: %d 밀리초), 완료.\n", timeToTake);
    }

}

