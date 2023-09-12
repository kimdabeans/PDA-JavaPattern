package AfterProxy;

/**
 * main 클래스는 프린터와 프린터 프록시를 테스트합니다.
 */
public class main {

	public static void main(String[] args) {
		Printable p = new PrinterProxy();
		p.getPrinterName();
		p.setPrinterName("heebin");
		p.getPrinterName();
		
		p.print("hello");
		p.getPrinterName();
	}
}


