package printer;

public class BlackWhitePrinter implements Printer {

	@Override
	public void print(String publicationType) {
		System.out.println("흑백으로 " + publicationType + "을(를) 인쇄합니다.");
	}

}
