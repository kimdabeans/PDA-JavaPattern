package Doll;

import Factory.Doll;
import Factory.Factory;

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
