package Factory;

public abstract class Factory {
	protected abstract Doll createDoll(String animal, String dollName);
	protected abstract void decorateDoll(Doll doll);
	
	public final Doll create(String animal, String dollName) {
		Doll doll = createDoll(animal, dollName);
		decorateDoll(doll);
		return doll;
	}
}
