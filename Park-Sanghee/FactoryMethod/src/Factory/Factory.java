package Factory;

/**
 * Creator : 인형을 만들고 꾸미는 공장을 나타내는 추상 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public abstract class Factory {
	/**
	 * 동물의 종류와 인형의 이름으로 인형을 만드는 추상 메서드
	 * @param animal 동물의 종류를 나타내는 문자열
	 * @param dollName 인형의 이름을 나타내는 문자열
	 * @return 생성된 인형 인스턴스
	 **/
	protected abstract Doll createDoll(String animal, String dollName);
	
	/**
	 * 인형을 꾸미는 추상 메서드
	 * @param doll 꾸미려는 인형 인스턴스
	 **/
	protected abstract void decorateDoll(Doll doll);
	
	/**
	 * 인형을 만들고 꾸미는 메서드
	 * @param animal 동물의 종류를 나타내는 문자열
	 * @param dollName 인형의 이름을 나타내는 문자열
	 * @return 만들기 및 꾸미기 과정을 마친 인형 인스턴스
	 **/
	public final Doll create(String animal, String dollName) {
		Doll doll = createDoll(animal, dollName);
		decorateDoll(doll);
		return doll;
	}
}
