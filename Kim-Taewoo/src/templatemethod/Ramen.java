package templatemethod;

/**
 * 라면 추상 클래스 
 */
public abstract class Ramen {
	private String name;
	/**
	 * Ramen 클래스의 생성자 
	 * @param name 라면의 이름 
	 */
	public Ramen(String name) {
		this.name = name;
	}
	/**
	 * 라면을 끓이는 공통 과정 메서드 - final로 재정의 불가 
	 */
	public final void RamenLogic() {
		System.out.println("-----------------");
		System.out.println(name + " 끓이기 시작");
		boiling();
		addNoodles();
		addPowder();
		waiting();
		System.out.println(name + " 완성");
	}
	
	/**
	 * 물을 끓이는 메서드 
	 */
	public abstract void boiling();
	/**
	 * 면을 넣는 메서드 
	 */
	public abstract void addNoodles();
	/**
	 * 스프를 넣는 메서드 
	 */
	public abstract void addPowder();
	/**
	 * 모든 재료를 넣고 끓기까지 기다리는 메서드 
	 */
	public abstract void waiting();
	
}
