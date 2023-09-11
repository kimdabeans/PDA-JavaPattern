package templatemethod;

/**
 * template method 적용 후 SesameRamen 클래스 
 */
public class SesameRamenAfter extends Ramen {
	/**
	 * 라면의 이름 설정  
	 */
	public SesameRamenAfter() {
		super("참깨라면");
	}
	/**
	 * 물을 끓이는 메서드 
	 */
	@Override
	public void boiling() {
		System.out.println("물을 끓인다.");
	}
	/**
	 * 면을 넣는 메서드 
	 */
	@Override
	public void addNoodles() {
		System.out.println("면을 넣는다.");
	}
	/**
	 * 스프를 넣는 메서드 
	 */
	@Override
	public void addPowder() {
		System.out.println("스프를 넣는다.");
	}
	/**
	 * 모든 재료를 넣고 끓기까지 기다리는 메서드 
	 */
	@Override
	public void waiting() {
		System.out.println("3분간 더 끓인다.");
		addEggBlock();
	}
	/**
	 * 계란 블럭을 넣는 메서드 
	 */
	private void addEggBlock() {
		System.out.println("계란블럭을 넣는다.");
	}
}
