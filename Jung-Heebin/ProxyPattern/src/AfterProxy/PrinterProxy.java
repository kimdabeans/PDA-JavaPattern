package AfterProxy;

/**
 * 프린터를 대리하는 프록시 클래스입니다.
 */
public class PrinterProxy implements Printable {
	private String name;
	private Printer real;
	
	/**
	 * 기본 생성자로, 이름 없이 프록시를 생성합니다.
	 */
	public PrinterProxy() {
		this.name = "no name";
		this.real = null;
	}
	
	/**
	 * 주어진 이름으로 프록시를 생성합니다.
	 *
	 * @param name 프록시의 이름
	 */
	public PrinterProxy(String name) {
		this.name = name;
		this.real = null;
	}
	
	/**
	 * 프록시의 이름을 설정합니다.
	 * 	 
	 * @param name 프록시의 이름
	 */
	@Override
	public void setPrinterName(String name) {
		if(real != null) {
			real.setPrinterName(name);
		}else {
			this.name = name;
		}
	}

	/**
	 * 현재 프록시의 정보를 알려줍니다.
	 * 
	 * <p>print 메서드를 수행하지 전까지는 Printer 인스턴스가 생성되지 않았으므로 real의 값은 null이 됩니다.</p>
	 *
	 * @param name 프록시의 이름
	 */
	@Override
	public void getPrinterName() {
		System.out.println("the real is " + real );
		System.out.println("The current name is \"" + this.name + "\"");
	}

	/**
	 * 주어진 문자열을 출력하는 메서드입니다. 
	 * 
	 * <p>프록시가 아닌 Printer 인스턴스를 생성하여 무거운 동작으로 가정된 print 메서드를 수행합니다.</p>
	 *
	 * @param name 프록시의 이름
	 */
	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}
	
	/**
	 * print메서드를 수행하기 위해 printer 인스턴스를 생성합니다.
	 *
	 * @param name 프록시의 이름
	 */
	private synchronized void realize() {
		if(real == null) {
			real = new Printer(name);
		}
	}
}
