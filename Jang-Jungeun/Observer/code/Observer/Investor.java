package Observer;

/**
 * Observer(관찰자) 인터페이스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 * 
 */

public interface Investor {
    /**
     * 관찰 대상의 변경 사항을 업데이트하는 메서드
     *
     * @param stockName 주식 이름
     * @param price     주식 가격
     */
	void update(String stockName, double price);
}
