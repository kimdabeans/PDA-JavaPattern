/**
 * 텍스트(일반 문자열)을 이용하여 문서를 만드는 클래스입니다.
 * Builder Class를 상속받고 있습니다.
 */
public class TextBuilder extends Builder {
	
	/**
	 * 문서를 구성하면서 필요한 contents들을 담아줄 StringBuilder 클래스의 인스턴스입니다.
	 */
	private StringBuilder sb = new StringBuilder();
	
	/**
	 * Plain Text의 형식에 알맞게 Title을 생성합니다.
	 * 
	 * @param title 문서의 제목
	 */
	@Override
	public void makeTitle(String title) {
		sb.append("===============================\n");
		sb.append("[");
		sb.append(title);
		sb.append("]\n\n");
	}
	
	/**
	 * Plain Text의 형식에 알맞게 하위 문단을 생성합니다.
	 * 
	 * @param str 문서의 하위 문단
	 */
	@Override
	public void makeString(String str) {
		sb.append("■");
		sb.append(str);
		sb.append("\n\n");
	}
	
	/**
	 * Plain Text의 형식에 알맞게 하위 문단 제목에 대한 단수 또는 복수 개의 내용을 생성합니다.
	 * 
	 * @param items 하위 문단 제목에 대한 내용 리스트
	 */
	@Override
	public void makeItems(String[] items) {
		for (String s: items) {
			sb.append(" ·");
			sb.append(s);
			sb.append("\n");
		}
		sb.append("\n");
	}
	
	/**
	 * Plain Text의 형식에 알맞게 문서 생성 작업을 종료합니다. 
	 */
	@Override
	public void close() {
		sb.append("===============================\n");
	}
	
	/**
	 * Plain Text 파일명을 리턴합니다.
	 * 
	 *  @return Plain Text 파일 내용을 리턴합니다.
	 */
	public String getTextResult() {
		return sb.toString();
	}
}
