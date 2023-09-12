package DollProcess;

public class CatDollProcess extends DollProcess {
	private String animal;
	
	public CatDollProcess(String animal) {
		this.animal = animal;
	}
	
	@Override
	public void assembleHead() {
		System.out.println(animal + " 인형 머리를 조립합니다.");
		assembleEars();
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
	
	private void assembleEars() {
		for (int e = 0; e < 2; e++) {
			System.out.println("☆ 고양이 귀를 붙입니다. ☆");
		}
	}
}