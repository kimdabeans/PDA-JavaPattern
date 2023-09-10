import printer.*;
import publication.*;

public class Main {

	public static void main(String[] args) {
		Printer color = new ColorPrinter();
        Printer blackWhite = new BlackWhitePrinter();

        Publication book = new Book("디자인 패턴", color);
        Publication magazine = new Magazine("프디아, 그것이 알고싶다", blackWhite);

        System.out.println("=============== 책 출판 ===============");
        book.print();
        
        System.out.println("\n=============== 잡지 출판 ==============");
        magazine.print();
	}
}
