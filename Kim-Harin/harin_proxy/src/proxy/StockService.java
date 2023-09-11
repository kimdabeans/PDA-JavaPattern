package proxy;

/**
 * <h1>StockService Interface</h1>
 * <p>
 * StockService 인터페이스는 주식 가격 데이터를 가져오는 역할을 정의합니다.
 * </p>
 *
 * @version 1.0.1
 * @author harin
 *
 */
public interface StockService {
    /**
     * 주식 가격을 가져옵니다.
     *
     * @param stockSymbol 주식 심볼
     * @return 주식 가격
     */
    public abstract void setStockPrice(int price); //가격 설정

    public abstract int getStockPrice(); // 가격 취득

    public abstract void print(String string); // 문자열 표시(프린트 아웃)

}

