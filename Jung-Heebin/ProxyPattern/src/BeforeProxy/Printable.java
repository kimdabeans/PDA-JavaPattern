package BeforeProxy;

/**
 * Printable 인터페이스는 프린터와 프린터 프록시를 구현하기 위한 기본적인 동작을 정의합니다.
 * 
 * <p>이 인터페이스를 구현하려면 프린터의 이름 설정, 현재 이름 가져오기, 문자열 출력 등을 구현해야 합니다.</p>
 */
public interface Printable {
	
	/**
	 * 프린터의 이름을 설정합니다.
	 * 
	 * @param name 프린터의 이름
	 */
	public abstract void setPrinterName(String name);
	
	/**
	 * 현재 프린터의 이름을 가져옵니다.
	 */
	public abstract void getPrinterName();
	
	/**
	 * 주어진 문자열을 출력합니다.
	 * 
	 * @param string 출력할 문자열
	 */
	public abstract void print(String string);
}
