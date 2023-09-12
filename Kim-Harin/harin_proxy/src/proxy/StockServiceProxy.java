package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>StockServiceProxy</h1>
 * <p>
 * StockServiceProxy 클래스는 주식 가격 데이터에 대한 프록시 역할을 수행합니다.
 * </p>
 *
 * @version 1.0.1
 * @author harin
 */
public class StockServiceProxy implements StockService {
    private int price; // 가격
    private RealStockService real; // 실제 주식 서비스

    /**
     * StockServiceProxy의 기본 생성자입니다. 가격을 0으로 초기화하고 실제 서비스 객체를 초기화합니다.
     */
    public StockServiceProxy() {
        this.price = 0;
        this.real = null;
    }

    /**
     * StockServiceProxy를 주어진 가격으로 초기화합니다. 실제 서비스 객체는 아직 초기화되지 않습니다.
     *
     * @param price 초기 주식 가격
     */
    public StockServiceProxy(int price) {
        this.price = price;
        this.real = null;
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
     * 주식 가격을 설정합니다. 설정된 주식 가격은 실제 서비스 객체에도 전달됩니다.
     *
     * @param price 설정할 주식 가격
     */
    @Override
    public synchronized void setStockPrice(int price) {
        if (real != null) {
            // 본인 에게도 설정한다
            real.setStockPrice(price);
        }
        this.price = price;
    }

    /**
     * 주어진 문자열을 출력합니다. 출력 전에 실제 서비스 객체를 초기화합니다.
     *
     * @param string 출력할 문자열
     */
    @Override
    public void print(String string) {
        realService();
        real.print(string);

    }

    /**
     * 실제 주식 서비스 객체를 생성합니다. 이미 생성되어 있다면 새로 생성하지 않습니다.
     */
    private synchronized void realService() {
        if (real == null) {
            real = new RealStockService(price);
        }

    }
}
