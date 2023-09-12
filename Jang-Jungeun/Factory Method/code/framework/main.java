
package framework;

import framework.Factory;
import framework.Product;
import account.AccountFactory;

/**
 * 메인 클래스이다.
 * Factory와 Product 클래스를 사용하여 계좌(Account) 객체를 생성하고 사용한다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class main {
	public static void main(String[] args) {
		/**
		 * Factory 객체를 생성한다.
		 */
		Factory factory = new AccountFactory();
		
		/**
		 *  AccountFactory의 create 메서드를 통해 Account 객체를 생성하고 계좌를 등록한다.
		 */
		Product account1 = factory.create("Jang Jeong Eun");
		Product account2 = factory.create("Son Heung Min");
		Product account3 = factory.create("Kim Su Hyun");
		
		/**
		 * 등록한 계좌를 사용한다.
		 */
		account1.use();
		account2.use();
		account3.use();
	}
}
