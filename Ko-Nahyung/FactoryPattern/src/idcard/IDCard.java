package idcard;

import framework.Product;

/**
 * Product 클래스를 상속하여 만든, Factory에서 만들고자 하는 IDCard 클래스입니다.
 */
public class IDCard extends Product {
	
	/**
	 * IDCard의 owner값을 담을 변수입니다.
	 */
	private String owner;
	
	/**
	 * IDCard 생성자
	 * 
	 * @param owner IDCard의 소유자
	 */
	IDCard(String owner) {
		System.out.println(owner + "의 카드를 만듭니다.");
		this.owner = owner;
	}
	
	/**
	 * Product에 정의된 추상 메소드 use를 Override합니다.
	 * IDCard 사용에 대한 정보를 콘솔창에 출력합니다.
	 */
	@Override
	public void use() {
		System.out.println(this + "을 사용합니다.");
	}
	
	/**
	 * toString 메소드를 Overriding하여, IDCard에 대한 정보와 인스턴스의 owner를 하나의 string값으로 리턴합니다.
	 * 
	 * @return IDCard 인스턴스에 대한 정보와 인스턴스의 owner를 하나의 string값으로 리턴합니다.
	 */
	@Override
	public String toString() {
		return "[IDCard: "+ owner + "]";
	}
	
	/**
	 * IDCard의 owner를 리턴합니다.
	 * 
	 * @return 현재 IDCard의 owner를 리턴합니다.
	 */
	public String getOwner() {
		return this.owner;
	}
	
}
