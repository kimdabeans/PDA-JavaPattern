package DollProcess;

/**
 * ConcreteClass : 토끼 인형을 만드는 과정을 구현한 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class RabbitDollProcess extends DollProcess {
	/**
	 * 동물의 종류를 나타내는 String 인스턴스
	 **/
	private String animal;
	
	/**
	 * 동물의 종류를 나타내는 문자열을 파라미터로 받는 RabbitDollProcess 생성자
	 * @param animal 동물의 종류를 나타내는 문자열
	 **/
	public RabbitDollProcess(String animal) {
		this.animal = animal;
	}
	
	@Override
	public void assembleHead() {
		System.out.println(animal + " 인형 머리를 조립합니다.");
	}

	@Override
	public void assembleBody() {
		System.out.println(animal + " 인형 몸을 조립합니다.");		
	}
	
	@Override
	public void assembleArms() {
		System.out.println(animal + " 인형 팔을 조립합니다.");
		System.out.println(animal + " 인형 손에 하트를 붙입니다.");
	}

	@Override
	public void assembleLegs() {
		System.out.println(animal + " 인형 다리를 조립합니다.");
		System.out.println(animal + " 인형 발에 하트를 붙입니다.");
	}
}
