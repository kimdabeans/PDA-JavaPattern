package templatemethod;

/**
 * template method 적용 전 ShinRamenBlack 클래스 
 */
public class ShinRamenBlackBefore {
	/**
	 * 라면의 이름 
	 */
	private String name = "신라면블랙";
	/**
	 * 신라면 블랙을 만드는 메서드 
	 */
	public void makeShinRamenBlack() {
		System.out.println("-----------------");
		System.out.println(name + " 끓이기 시작");
		boiling();
		addNoodles();
		addPowder();
		waiting();
		addAfterPowder();
		System.out.println(name + " 완성");
	}
	/**
	 * 물을 끓이는 메서드 
	 */
	private void boiling() {
		System.out.println("물을 끓인다.");
	}
	/**
	 * 면을 넣는 메서드 
	 */
	private void addNoodles() {
		System.out.println("면을 넣는다.");
	}
	/**
	 * 스프를 넣는 메서드 
	 */
	private void addPowder() {
		System.out.println("스프를 넣는다.");
	}
	/**
	 * 모든 재료를 넣고 끓기까지 기다리는 메서드 
	 */
	private void waiting() {
		System.out.println("3분간 더 끓인다.");
	}
	/**
	 * 후첨 스프를 넣는 메서드 
	 */
	private void addAfterPowder() {
		System.out.println("후첨 스프를 넣는다.");
	}
}
