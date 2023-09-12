package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>RealStockService</h1>
 * <p>
 * RealStockService 클래스는 실제 주식 가격 데이터를 가져오는 역할을 수행합니다.
 * </p>
 *
 * @version 1.0.1
 * @author harin
 */

public class RealStockService implements StockService{
    /**
     * 프린터 이름
     */
    private int price;

    /**
     * RealStockService의 생성자입니다.
     */
    public RealStockService() {
        heavyJob("Creating RealStockService");
    }

    /**
     * 실제 주식 서비스 객체를 생성합니다.
     * 주식 데이터를 외부 공급자로부터 가져오는데 시간이 오래 걸리는 것을 heavyJob이라고 정의합니다.
     *
     * @param price 초기 주식 가격
     */
    RealStockService(int price) {
        this.price = price;
        heavyJob("Creating RealStockService instance($" + price + ")");
    }

    /**
     * 주식 가격을 설정합니다.
     *
     * @param price 설정할 주식 가격
     */
    @Override
    public void setStockPrice(int price) {
        this.price = price;

    }

    /**
     * 현재 주식 가격을 반환합니다.
     *
     * @return 현재 주식 가격
     */
    @Override
    public int getStockPrice() {
        return price;
    }

    /**
     * 주어진 문자열을 출력합니다. 출력 시 주식 가격을 함께 표시합니다.
     *
     * @param string 출력할 문자열
     */
    @Override
    public void print(String string) {
        System.out.println("=== $" + price + " ===");
        System.out.println(string);
    }

    /**
     * 무거운 작업을 수행한다고 가정한 메소드입니다.
     *
     * @param msg 작업 메시지
     */
    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("finish");
    }
}
