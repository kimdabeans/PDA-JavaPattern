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
 *
 */
public class RealStockService implements StockService{
    private int price; // 프린터 이름

    /**
     * 생성자 이름을 지정하지 않고 <code>Printer</code> 인스턴스를 생성합니다. 작업 시뮬레이션을 위한 지연을 포함합니다.
     */
    public RealStockService() {heavyJob("Creating Printer Instance");
    }

    /**
     * 생성자 지정된 이름으로 <code>Printer</code> 인스턴스를 생성합니다.
     *
     * @param name
     */
    RealStockService(int price) {
        this.price = price;
        heavyJob("Creating Printer instance(" + price + ")");
    }

    /**
     * 이름을 설정합니다.
     * @param name
     */
    @Override
    public void setStockPrice(int price) {
        this.price = price;

    }

    /**
     * 이름을 취득합니다
     * @return name
     */
    @Override
    public int getStockPrice() {
        return price;
    }

    /**
     * 이름을 붙여서 표시합니다.
     * @param string
     */
    @Override
    public void print(String string) {
        System.out.println("=== " + price + " ===");
        System.out.println(string);

    }

    /**
     * <p>무거운 작업이라고 가정합니다</p>
     * @param msg
     */
    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(".");
        }
        System.out.println("finish");
    }
}
