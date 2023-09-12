package publication;

import printer.Printer;

/**
 * 기능의 클래스 계층 : 출판물을 나타내는 추상 클래스 
 * @version 1.0
 * @author Lee Jieun
 * */
public abstract class Publication {
	/**
	 * Printer 객체 
	 * */
	protected Printer printer;
	
	/**
	 * Publication 추상 클래스의 생성자
	 * 
	 * @param printer 사용할 printer 객체 
	 * */
	public Publication(Printer printer) {
		this.printer = printer;
	}
	
	/**
	 * 출판물을 인쇄하는 추상 메서드 
	 * */
	public abstract void print();
}
