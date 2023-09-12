package proxy;


/**
 * <h1>StockService Interface</h1>
 * <p>
 * StockService 인터페이스는 주식 가격 데이터를 가져오는 역할을 정의합니다.
 * </p>
 *
 */
public interface StockService {
    /**
     * 주식 가격을 설정합니다.
     *
     * @param price 주식 가격
     */
    public abstract void setStockPrice(int price); //가격 설정
    /**
     * 주식 가격을 취득합니다.
     *
     * @return 주식 가격
     */
    public abstract int getStockPrice(); // 가격 취득

    /**
     * 주어진 문자열을 출력합니다.
     *
     * @param string 출력할 문자열
     */
    public abstract void print(String string); // 문자열 표시(프린트 아웃)

}

