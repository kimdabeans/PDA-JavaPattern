package Doll;

import Factory.Doll;

public class TeddyBear extends Doll {
	private String animal;
	private String dollName;
	
	TeddyBear(String animal, String dollName) {
		System.out.println(animal + "인형을 만듭니다.");
		this.animal = animal;
		this.dollName = dollName;
	}

	@Override
	public void getName() {
		System.out.println("이 " + animal + "인형의 이름은 " + dollName + "입니다.");
	}

	@Override
	public String toString() {
		return "[Doll : " + dollName + "]";
	}
}
