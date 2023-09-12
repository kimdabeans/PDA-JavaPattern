package BeforeProxy;

/**
 * main 클래스는 프린터를 생성하고 동작을 테스트합니다.
 */
public class main {

	public static void main(String[] args) {
		Printable p = new Printer();
		p.getPrinterName();
		p.setPrinterName("heebin");
		p.getPrinterName();
	}
}
