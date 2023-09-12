package NonObserver;

/**
 * Observer pattern을 사용하기 전 코드이다.
 * 투자자들의 공통 업데이트 메서드를 정의하는 인터페이스이다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
 */

public interface Investor {
    void update(String stockName, double price);
}
