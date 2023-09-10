package publication;

import printer.Printer;

public class Magazine extends Publication {
	private String title;
	
	public Magazine(String title, Printer printer) {
		super(printer);
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public void print() {
		System.out.printf("'%s' 잡지를 출판합니다.\n", title);
        printer.print("잡지");
	}

}
