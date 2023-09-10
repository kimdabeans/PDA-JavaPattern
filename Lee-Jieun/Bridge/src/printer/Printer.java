package printer;

/**
 * 구현의 클래스 계층 : 출판물을 인쇄하는 프린터를 나타내는 인터페이스 
 * @version 1.0
 * @author Lee Jieun
 * */
public interface Printer {
	/**
	 * 인자로 주어진 유형의 출판물을 인쇄하는 함수
	 * 
	 * @param publicationType 인쇄할 출판물 유형
	 * */
	public void print(String publicationType);
}
