package Before;

/**
 *  Account 객체를 직접 생성하여 계좌를 만들고 출력하는 FactoryMethodTest 클래스이다.
 *  Factory Method 디자인 패턴을 쓰긴 전 코드이다.
 *  
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
 */

public class FactoryMethodTest {
    public static void main(String[] args) {
        Account account1 = new Account("Jang Jeong Eun");
        Account account2 = new Account("Son Heung Min");
        Account account3 = new Account("Go ho");

        /**
         *  각 계좌를 사용한다.
         */
        account1.use();
        account2.use();
        account3.use();
    }
}