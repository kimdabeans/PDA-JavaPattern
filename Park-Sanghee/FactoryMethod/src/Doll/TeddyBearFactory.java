package Doll;

import Factory.Doll;
import Factory.Factory;

/**
 * ConcreteCreator : 곰인형을 만들고 꾸미는 공장 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class TeddyBearFactory extends Factory {
	@Override
	protected Doll createDoll(String animal, String dollName) {
		return new TeddyBear(animal, dollName);
	}

	@Override
	protected void decorateDoll(Doll doll) {
		System.out.println(doll + "을 예쁘게 꾸며 줍니다.");
	}
}
