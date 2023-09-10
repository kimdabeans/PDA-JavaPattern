package printer;

/**
 * 구현의 클래스 계층 : 흑백 프린터를 나타내는 클래스  
 * @version 1.0
 * @author Lee Jieun
 * */
public class BlackWhitePrinter implements Printer {
	@Override
	public void print(String publicationType) {
		System.out.println("흑백으로 " + publicationType + "을(를) 인쇄합니다.");
	}
}
