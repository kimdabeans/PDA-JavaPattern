package composite;
/**
 * 주식의 이름과 가격 정보를 표현하는 인터페이스.
 * 
 * @author Hyeyeon Kim
 * @filename Stock.java
 * 
 */
public interface Stock {
    /**
     * 주식 종목명 반환
     * 
     * @return 주식 종목명.
     */
	String getStockName();
	/**
     * 주식의 가격을 반환합니다.
     * 
     * @return 현재 주가.
     */
	double getPrice();	
}
