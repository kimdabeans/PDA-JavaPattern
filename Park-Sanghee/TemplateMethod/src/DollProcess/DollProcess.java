package DollProcess;

/**
 * AbstractClass : 인형을 만드는 과정을 정의한 추상 클래스
 * @version 1.0
 * @author Park SangHee
 **/
abstract class DollProcess {
	/**
	 * 머리 조립을 수행하는 추상 메서드
	 **/
	public abstract void assembleHead();
	
	/**
	 * 몸 조립을 수행하는 추상 메서드
	 **/
	public abstract void assembleBody();
	
	/**
	 * 팔 조립을 수행하는 추상 메서드
	 **/
	public abstract void assembleArms();
	
	/**
	 * 다리 조립을 수행하는 추상 메서드
	 **/
	public abstract void assembleLegs();
	
	/**
	 * 인형을 만드는 메서드
	 * 머리와 몸을 조립하고, 팔과 다리를 2 개씩 조립
	 **/
	public final void createDoll() {
		assembleHead();
		assembleBody();
		
		for (int i = 0; i < 2; i++) {
			assembleArms();
			assembleLegs();
		}
	}
}
