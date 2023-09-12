/**
 * Builder Pattern에서 핵심이 되는 부분으로,
 * 문서를 구성하기 위한 메소드를 규정한 추상 클래스입니다.
 * 공통적인 기능들을 추상 메소드들로 선언하고 있습니다.
 */
public abstract class Builder {
	
	/**
	 * Title을 생성합니다.
	 * 
	 * @param title 문서의 제목
	 */
	public abstract void makeTitle(String title);
	
	/**
	 * 하위 문단 제목(소제목)을 생성합니다.
	 * 
	 * @param str 문서의 하위 문단 제목(소제목)
	 */
	public abstract void makeString(String str);
	
	/**
	 * 하위 문단 제목에 대한 단수 또는 복수 개의 내용을 생성합니다.
	 * 
	 * @param items 하위 문단 제목에 대한 내용 리스트
	 */
	public abstract void makeItems(String[] items);
	
	/**
	 * 문서 생성 작업을 종료합니다. 
	 */
	public abstract void close();
}
