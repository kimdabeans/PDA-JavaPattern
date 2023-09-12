package printer;

/**
 * 구현의 클래스 계층 : 컬러 프린터를 나타내는 클래스  
 * @version 1.0
 * @author Lee Jieun
 * */
public class ColorPrinter implements Printer {
	@Override
	public void print(String publicationType) {
		System.out.println("컬러로 " + publicationType + "을(를) 인쇄합니다.");
	}
}
