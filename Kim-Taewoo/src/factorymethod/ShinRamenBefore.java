package factorymethod;

/**
 * 패턴 적용 전의 신라면 제품 
 */
public class ShinRamenBefore {
	/**
	 * 라면 이름 
	 */
	private String name;
	/**
	 * 생성자 
	 */
	public ShinRamenBefore() {
		System.out.println("---------------------");
		name = "신라면";
	}
	/**
	 * 라면을 포장하는 메서드 
	 */
	public void packaging() {
		System.out.println(name + "을 포장");
	}
	/**
	 * 라면을 배송하는 메서드 
	 */
	public void deliver() {
		System.out.println(name + " 제품을 배송");
	}
}
