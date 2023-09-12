# Builder Pattern

&ensp;Builder는 복잡한 객체들을 단계별로 생성할 수 있도록 하는 생성 디자인 패턴입니다. 이 패턴을 사용하면 같은 코드를 사용하여, 객체의 다양한 유형들과 표현을 제작할 수 있습니다.

### Builder Pattern UML
![Builder_before](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/e6981481-e321-4d33-9e3c-633e5c9f72eb)

Builder Pattern의 등장인물
- Builder: 인스턴스를 생성하기 위한 인터페이스를 결정합니다. Builder 역에는 인스턴스의 각 부분을 만드는 메소드가 준비됩니다. 위 UML에서 Builder에 해당합니다.
- ConcreteBuilder: Builder의 인터페이스를 구현하는 클래스입니다. 실제 인스턴스 생성으로 호출되는 메소드가 정의됩니다. 또한 최종적으로 완성된 결과를 얻는 메소드가 준비됩니다. 위 UML에서 TextBuilder와 HTMLBuilder에 해당합니다.
- Director: Builder의 인터페이스를 사용하여 인스턴스를 생성합니다. ConcreteBuilder 역에 의존하는 프로그래밍은 하지 않도록 합니다. ConcreteBuilder 역이 무엇이든 잘 작동할 수 있도록 Builder의 메소드만 사용합니다. 위 UML에서 Director에 해당합니다.
- Client: Builder 패턴을 이용합니다. 위 UML에서는 Main에 해당합니다.

&ensp;UML에서는 Builder 클래스는 추상 클래스로 makeTitle, maekString, makeItems, close 추상 메서드를 갖습니다. Director 클래스는 이러한 Builder 클래스를 가지고 있으며, construct 메서드를 갖습니다. 
&ensp;TextBuilder와 HTMLBuilder 두 클래스 모두가 Builder 클래스를 상속하며, Builder 클래스의 추상 메서드들을 Override하고 있습니다. 또한, 각각의 클래스는 필요한 변수와 필요한 메서드를 추가적으로 갖습니다.
&ensp;UML을 통해서 Builder Pattern은 확장에 대해서 열려있고, 수정에 대해서 닫혀있는 Open Closed Principle 원칙을 잘 지키고 있음을 알 수 있습니다. 
## 기존의 Builder Pattern 구조에 JSONBuilder 추가하기
### Builder Pattern UML
![Builder_after](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/019e9fcc-2abb-47d9-8978-fd59c0240d44)
### 추가한 Code
#### JSONBuilder.java
--- 발생했던 사소한 이슈: json파일의 인코딩 문제로 한글이 깨지는 문제가 발생.. 기존의 java.io.FileWriter, java.io.Writer 대신에 java.io.BufferedWriter, java.io.FileOutputStream, java.io.OutputStreamWriter 를 통해서 해결! (기존 방식은 주석처리)
```java
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
```
#### Main.java
```java
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
```
#### 결과물
[textBuilder로 문서를 만든 경우]


![textbuilder](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/658071b9-c3a8-4ba8-82ac-e862ae7057cd)

[htmlBuilder로 문서를 만든 경우]


콘솔>>


![htmlbuilder](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/3f598fd5-aab8-40c3-89a5-e4851cef6a3a)


생성된 메뉴판.html>>


![htmlcontents](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/41f49526-e327-4fe0-bacd-b7296015deaf)


[jsonBuilder로 문서를 만든 경우]


콘솔>>


![json_builder](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/effd6b6a-78cf-4d81-9576-20521ca20247)


생성된 메뉴판.json>>


![jsoncontents](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/7ebfddf1-1d76-4075-8972-ea96d28766c5)


