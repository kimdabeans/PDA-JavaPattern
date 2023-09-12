package brigepattern;

import java.util.concurrent.TimeUnit;
/**
 * 영수증을 청구하는 서비스에 대한 클래스.
 *
 * 이 서비스는 의류 선택 후 영수증을 청구하는 서비스를 수행하며 작업 완료까지의 시간을 계산합니다.
 */
public class InvoiceService extends ShoppingService {
    /**
     * 기본 생성자.
     */
    public InvoiceService() {
        super();
    }
    /**
     * 의류 선택 후 영수증 청구 작업을 수행하는 메서드.
     *
     * @param clothes 영수증을 청구할 의류 객체
     */
    @Override
    public void work(Clothes clothes) {
        System.out.print("영수중 청구 중... ");
        long timeToTake = 100 * clothes.takeTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake);
        } catch (InterruptedException exp) {
            // 현재는 아무 작업도 수행하지 않습니다.
        }
        System.out.printf("(소요 시간: %d 밀리초), 완료.\n", timeToTake);
    }

}
