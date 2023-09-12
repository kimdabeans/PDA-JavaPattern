import java.io.*;

/**
 * HTML 파일을 이용하여 문서를 만드는 클래스입니다.
 * Builder Class를 상속받고 있습니다.
 */
public class HTMLBuilder extends Builder {
	
	/**
	 * 만들어질 file의 이름을 담을 변수이며, Default값은 untitled.html입니다.
	 */
	private String filename = "untitled.html";
	
	/**
	 * 문서를 구성하면서 필요한 contents들을 담아줄 StringBuilder 클래스의 인스턴스입니다.
	 */
	private StringBuilder sb = new StringBuilder();
	
	/**
	 * HTML 형식에 알맞게 Title을 생성합니다.
	 * 
	 * @param title 문서의 제목
	 */
	@Override
	public void makeTitle(String title) {
		filename = title + ".html"; //this.filename 가능
		sb.append("<!DOCTYPE html>\n");
		sb.append("<html>\n");
		sb.append("<head><title>");
		sb.append(title);
		sb.append("</title></head>\n");
		sb.append("<body>\n");
		sb.append("<h1>");
		sb.append(title);
		sb.append("</h1>\n\n");
	}
	
	/**
	 * HTML 형식에 알맞게 하위 문단을 생성합니다.
	 * 
	 * @param str 문서의 하위 문단
	 */
	@Override
	public void makeString(String str) {
		sb.append("<p>");
		sb.append(str);
		sb.append("</p>\n\n");
	}
	
	/**
	 * HTML 형식에 알맞게 하위 문단 제목에 대한 단수 또는 복수 개의 내용을 생성합니다.
	 * 
	 * @param items 하위 문단 제목에 대한 내용 리스트
	 */
	@Override
	public void makeItems(String[] items) {
		sb.append("<ul>\n");
		for (String s: items) {
			sb.append("<li>");
			sb.append(s);
			sb.append("</li>\n");
		}
		sb.append("</ul>\n\n");
	}

	/**
	 * HTML 형식에 알맞게 문서 생성 작업을 종료합니다. 
	 */
	@Override
	public void close() {
		sb.append("</body>");
		sb.append("</html>\n");
		try {
			Writer writer = new FileWriter(filename);
			writer.write(sb.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * HTML 파일명을 리턴합니다.
	 * 
	 *  @return HTML 파일명을 리턴합니다.
	 */
	public String getHTMLFileName() {
		return filename;
	}
}
