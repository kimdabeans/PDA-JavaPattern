package account;

import framework.Factory;
import framework.Product;

/**
 * 계좌(Account) 객체를 생성하고 등록하는 AccountFactory클래스이다.
 * Factory 클래스를 상속하여 계좌 객체를 생성하고 등록하는 메서드를 구현한다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class AccountFactory extends Factory{
	/**
	 * 주어진 소유자 정보를 사용하여 계좌(Account) 객체를 생성한다.
	 *
	 * @param owner 계좌의 소유자 정보
	 * @return 생성된 계좌 객체
	 */
	@Override
	protected Product createProduct(String owner) {
		return new Account(owner);
	}
	
    /**
     * 생성된 제품을 등록한다.
     *
     * @param product 등록할 제품 객체
     */
	@Override
	protected void registerProduct(Product product) {
		System.out.println(product + "을 등록했습니다.");
	}
}
