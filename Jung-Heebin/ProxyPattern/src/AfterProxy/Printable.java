package AfterProxy;

/**
 * Printable 인터페이스는 각각 printer와 printerProxy 파일에 붙습니다.
 *
 * <p>이 인터페이스는 프린터 관련 작업을 정의합니다.</p>
 */
public interface Printable {
	
	/**
	 * 프린터의 이름을 설정합니다.
	 *
	 * @param name 설정할 프린터의 이름
	 */
	public abstract void setPrinterName(String name);
	
	/**
	 * 프린터의 이름을 가져옵니다.
	 */
	public abstract void getPrinterName();
	
	/**
	 * 주어진 문자열을 출력합니다.
	 *
	 * @param string 출력할 문자열
	 */
	public abstract void print(String string);
}
