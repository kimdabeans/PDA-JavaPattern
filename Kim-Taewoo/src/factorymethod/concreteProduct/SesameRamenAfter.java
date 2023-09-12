package factorymethod.concreteProduct;

import factorymethod.framework.Product;

/**
 * 패턴 적용 후 신라면 제품 클래스 
 */
public class SesameRamenAfter extends Product {
	/**
	 * 라면의 이름을 가지는 변수 
	 */
	private String name;
	/**
	 * 참깨라면의 생성자 - 라면의 이름을 설정한다. 
	 * @param name 라면의 이름 
	 */
	public SesameRamenAfter(String name) {
		this.name = name;
		System.out.println("---------------------");
		System.out.println(name + "을 생산");
	}
	/**
	 * 라면을 포장하는 메서드 
	 */
	@Override
	public void packaging() {
		// TODO Auto-generated method stub
		System.out.println(name + "을 포장");
	}
	/**
	 * 라면을 배송하는 메서드 
	 * @param destination 배송 목적지 
	 */
	@Override
	public void deliver(String destination) {
		// TODO Auto-generated method stub
		System.out.println(name + " 제품을 " + destination + "으로 배송");
	}

}
