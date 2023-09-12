import printer.*;
import publication.*;

/**
 * Main Class 
 * @version 1.0
 * @author Lee Jieun
 * */
public class Main {

	/**
	 * Bridge Pattern을 테스트하는 메인 함수 
	 * 
	 * @param args 프로그램을 실행할 때 넘겨주는 값
	 * */
	public static void main(String[] args) {
		Printer color = new ColorPrinter();
        Printer blackWhite = new BlackWhitePrinter();

        Publication book1 = new Book("디자인 패턴", color);
        Publication book2 = new Book("도커&쿠버네티스", blackWhite);
        Publication magazine = new Magazine("그것이 알고싶다", blackWhite);

        System.out.println("=============== 책 출판 ===============");
        book1.print();
        System.out.println();
        book2.print();
        
        System.out.println("\n=============== 잡지 출판 ==============");
        magazine.print();
	}
}
