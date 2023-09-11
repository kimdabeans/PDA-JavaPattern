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
 *
 */
public class StockServiceProxy implements StockService {
    private int price; // 가격
    private RealStockService real; // 본인

    public StockServiceProxy() {
        this.price = 0;
        this.real = null;
    }

    public StockServiceProxy(int price) {
        this.price = price;
        this.real = null;
    }


    @Override
    public int getStockPrice() {
        return price;
    }

    @Override
    public synchronized void setStockPrice(int price) {
        if (real != null) {
            // 본인 에게도 설정한다
            real.setStockPrice(price);
        }
        this.price = price;
    }
    @Override
    public void print(String string) {
        realService();
        real.print(string);

    }

    /**
     * 실제 프린터 객체를 생성합니다. 이미 생성되어 있다면 생성하지 않습니다.
     */
    private synchronized void realService() {
        if (real == null) {
            real = new RealStockService(price);
        }

    }
}
