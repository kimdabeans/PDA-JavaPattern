package factorymethod;

/**
 * 패턴 적용 전의 신라면을 만드는 공장 클래스 
 */
public class ShinRamenFactoryBefore {
	/**
	 * 신라면을 생성하는 메서드 
	 * @return 새롭게 생성된 신라면 
	 */
	public ShinRamenBefore createShinRamen() {
		return new ShinRamenBefore();
	}
}
