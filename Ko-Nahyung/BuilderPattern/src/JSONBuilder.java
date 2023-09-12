import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
//import java.io.FileWriter;
//import java.io.Writer;

/**
 * JSON 파일을 이용하여 문서를 만드는 클래스입니다.
 * Builder Class를 상속받고 있습니다.
 */
public class JSONBuilder extends Builder {
	
	/**
	 * 만들어질 file의 이름을 담을 변수이며, Default값은 untitled.html입니다.
	 */
	private String filename = "untitled.json";
	
	/**
	 * 문서를 구성하면서 필요한 contents들을 담아줄 StringBuilder 클래스의 인스턴스입니다.
	 */
	private StringBuilder sb = new StringBuilder();
	
	/**
	 * JSON 형식에 맞게 객체 데이터를 생성하고, 객체들을 ',' 로 구분하기 위해서 선언한 변수입니다.
	 */
	private boolean isMakeStringBefore = false;
	
	/**
	 * JSON 형식에 알맞게 제목 Key와 Value를 생성합니다.
	 * 
	 * @param title JSON문서의 제목
	 */
	@Override
	public void makeTitle(String title) {
		filename = title + ".json"; //this.filename 가능
		sb.append("{\n");
		sb.append("\t\"제목\": \"");
		sb.append(title);
		sb.append("\",\n");
	}
	
	/**
	 * JSON 형식에 알맞게 객체를 생성합니다.
	 * 
	 * @param obj 객체 Key 값
	 */
	@Override
	public void makeString(String obj) {
		if(isMakeStringBefore) sb.append(",\n");
		sb.append("\t\"" + obj + "\": {\n");
		isMakeStringBefore = true;
	}
	
	/**
	 * JSON 형식에 알맞게 Key와 Value들을 상위 객체 내부에 추가합니다.
	 * 
	 * @param items 객체 하위 Values들에 대한 리스트
	 */
	@Override
	public void makeItems(String[] items) {
		int num = 1;
		for (String s: items) {
			sb.append("\t\t\"");
			sb.append("content"+num+"\": \"");
			sb.append(s);
			if(num == items.length) sb.append("\"\n");
			else sb.append("\",\n");
			num++;
		}
		sb.append("\t}");
	}

	/**
	 * JSON 형식에 알맞게 문서 생성 작업을 종료합니다. 
	 */
	@Override
	public void close() {
		sb.append("\n}\n");
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter writer = new BufferedWriter(osw);
			//Writer writer = new FileWriter(filename);
			writer.write(sb.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * JSON 파일명을 리턴합니다.
	 * 
	 *  @return JSON 파일명을 리턴합니다.
	 */
	public String getJSONFileName() {
		return filename;
	}
}
