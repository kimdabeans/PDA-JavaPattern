import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Main 클래스
 */
public class Main {
	
	/**
	 * main 메소드로, 실제 BuilderPattern을 적용하여 문서화를 수행합니다.
	 */
	public static void main(String[] args) {
		
		/**
		 * args에 주어진 형식에 알맞게 각 builder들을 통해서, 문서를 생성합니다.
		 * 단, args가 1개가 아닌 경우에는 ERROR 처리합니다.
		 */
		if (args.length != 1) {
			usage();
			System.exit(0);
		}
		
		/**
		 * main 실행 시, 주어지는 args[0]에 따라서 서로 다른 방식으로 문서를 생성합니다.
		 */
		if (args[0].equals("text")) {
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.construct();
			String result = textbuilder.getTextResult();
			System.out.println(result);
		} else if (args[0].equals("html")) {
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.construct();
			String filename = htmlbuilder.getHTMLFileName();
			System.out.println("HTML파일 " + filename + "이 작성되었습니다.");
		} else if (args[0].equals("json")) {
			JSONBuilder jsonbuilder = new JSONBuilder();
			Director director = new Director(jsonbuilder);
			director.construct();
			String filename = jsonbuilder.getJSONFileName();
			System.out.println("JSON파일 " + filename + "이 작성되었습니다.");
		} else {
			usage();
			System.exit(0);
		}		
	}
	
	/**
	 * 본 프로그램을 동작하는 방법을 출력합니다.
	 */
	public static void usage() {
		System.out.println("Usage: java Main text");
		System.out.println("Usage: java Main html");
		System.out.println("Usage: java Main json");
	}

}
