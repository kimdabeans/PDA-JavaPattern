package factorymethod;

/**
 * 패턴 적용 전의 참깨라면을 만드는 공장 클래스 
 */
public class SesameRamenFactoryBefore {
	/**
	 * 참깨라면을 생성하는 메서드 
	 * @return 새롭게 생성된 참깨라면 
	 */
	public SesameRamenBefore createSesameRamen() {
		return new SesameRamenBefore();
	}
}
