package account;

import framework.Product;

/**
 * 고객의 계좌(Account)를 나타내는 Account 클래스이다.
 * Product 클래스를 상속하며, 계좌 소유자 정보와 계좌 생성 및 사용에 관한 메서드를 제공한다.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */

public class Account extends Product{
	private String owner;
	
    /**
     * 주어진 소유자 정보로 계좌(Account) 객체를 생성한다.
     *
     * @param owner 계좌의 소유자 정보
     */
	Account(String owner){
		System.out.println( owner + "의 계좌를 만듭니다.");
		this.owner = owner;
	}
	
    /**
     * 계좌를 사용하는 메서드이다.
     */
	@Override
	public void use() {
		System.out.println(this + "을 사용합니다.");
	}
	
    /**
     * 객체를 문자열로 표현한다.
     * toString()은 Object의 기본 메서드이기 때문에 Override 됨.
     *
     * @return 계좌 정보를 포함한 문자열
     */
	@Override
	public String toString() {
		return "[Shinhan accounts:" + owner + "]";
	}
	
    /**
     * 계좌의 소유자 정보를 반환한다.
     *
     * @return 계좌의 소유자 정보
     */
	public String getOwner() {
		return owner;
	}
}
