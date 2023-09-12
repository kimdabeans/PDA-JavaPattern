package Doll;

import Factory.Doll;

/**
 * ConcreteProduct : 곰인형을 나타내는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class TeddyBear extends Doll {
	/**
	 * 동물의 종류를 나타내는 String 인스턴스
	 **/
	private String animal;
	
	/**
	 * 인형의 이름을 나타내는 String 인스턴스
	 **/
	private String dollName;
	
	/**
	 * 동물의 종류를 나타내는 문자열과 인형의 이름을 나타내는 문자열을 파라미터로 받는 TeddyBear 생성자
	 * @param animal
	 * @param dollName
	 **/
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
