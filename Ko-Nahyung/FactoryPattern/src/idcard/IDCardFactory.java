package idcard;

import framework.*;

/**
 * Factory 클래스를 상속하여 만든, IDCard를 만드는 IDCardFactory 클래스입니다.
 */
public class IDCardFactory extends Factory {
	
	/**
	 * Factory에 정의된 추상 메소드 createProduct를 Override합니다.
	 * IDCard 인스턴스를 생성하여 리턴합니다.
	 * 
	 * @param owner IDCard의 owner입니다.
	 * @return owner을 parameter로하여 생성한 IDCard 인스턴스를 리턴합니다.
	 */
	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}
	
	/**
	 * Factory에 정의된 추상 메소드 registerProduct를 Override합니다.
	 * IDCard 정보와 IDCard 등록에 대한 정보를 콘솔창에 출력합니다.
	 * 
	 * @param product Product를 상속하는 IDCard
	 */
	@Override
	protected void registerProduct(Product product) {
		System.out.println(product + "을 등록했습니다.\n");
	}
}
