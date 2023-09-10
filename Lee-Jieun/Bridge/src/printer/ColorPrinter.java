package printer;

public class ColorPrinter implements Printer {

	@Override
	public void print(String publicationType) {
		System.out.println("컬러로 " + publicationType + "을(를) 인쇄합니다.");
	}
}
