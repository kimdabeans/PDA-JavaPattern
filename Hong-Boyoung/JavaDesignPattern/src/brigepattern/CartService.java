package brigepattern;

import java.util.concurrent.TimeUnit;
/**
 * 선택한 의류를 장바구니에 추가하는 서비스에 대한 클래스.
 *
 * 이 서비스는 선택한 의류를 장바구니에 추가하는 서비스를 수행하며 작업 완료까지의 시간을 계산합니다.
 */
public class CartService extends ShoppingService {
    /**
     * 기본 생성자.
     */
    public CartService() {
        super();
    }
    /**
     * 선택한 의류를 장바구니에 추가하는 메서드.
     *
     * @param clothes 선택한 의류를 장바구니에 추가하는 객체
     */
    @Override
    public void work(Clothes clothes) {
        System.out.print("장바구니 추가 중... ");
        long timeToTake = 300 * clothes.takeTime();
        try {
            TimeUnit.MILLISECONDS.sleep(timeToTake);
        } catch (InterruptedException exp) {
        }
        System.out.printf("(소요 시간: %d 밀리초), 완료.\n", timeToTake);
    }

}

