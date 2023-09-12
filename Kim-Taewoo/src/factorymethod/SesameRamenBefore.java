package factorymethod;

/**
 * 패턴 적용 전의 참깨라면 제품 
 */
public class SesameRamenBefore {
	/**
	 * 라면 이름 
	 */
	private String name;
	/**
	 * 생성자 
	 */
	public SesameRamenBefore() {
		System.out.println("---------------------");
		name = "참깨라면";
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
