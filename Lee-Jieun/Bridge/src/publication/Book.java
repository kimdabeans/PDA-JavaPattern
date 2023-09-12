package publication;

import printer.Printer;

/**
 * 기능의 클래스 계층 : 책을 나타내는 클래스 
 * @version 1.0
 * @author Lee Jieun
 * */
public class Book extends Publication {
	/**
	 * 제목 
	 * */
	private String title;
	
	/**
	 * Book 클래스의 생성자 
	 * 
	 * @param title   책의 제목
	 * @param printer 사용할 프린터 객체 
	 * */
	public Book(String title, Printer printer) {
		super(printer);
		this.title = title;
	}
	
	/**
	 * 책의 제목을 반환
	 * 
	 * @return 책의 제목
	 * */
	public String getTitle() {
		return title;
	}

	@Override
	public void print() {
		System.out.printf("'%s' 책을 출판합니다.\n", title);
        printer.print("책");
	}
}
