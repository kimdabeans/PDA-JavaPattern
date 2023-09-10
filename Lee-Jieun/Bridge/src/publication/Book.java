package publication;

import printer.Printer;

public class Book extends Publication {
	private String title;
	
	public Book(String title, Printer printer) {
		super(printer);
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public void print() {
		System.out.printf("'%s' 책을 출판합니다.\n", title);
        printer.print("책");
	}
}
