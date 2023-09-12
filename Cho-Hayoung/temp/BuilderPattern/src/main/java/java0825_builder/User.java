package java0825_builder;

/**
 * User 클래스는 Builder 패턴 예제를 실행하는 데 사용됩니다.
 * 이 클래스는 CSVBuilder 및 HTMLBuilder를 사용하여 다양한 형식의 텍스트 문서를 생성하고 출력합니다.
 */
public class User {

    public static void main(String[] args) {
        // Builder 인스턴스 생성
        Builder csv = new CSVBuilder();
        Builder html = new HTMLBuilder();
        
        // CSVBuilder를 이용하여 Director 인스턴스 생성
        Director hayoung = new Director(csv);
        
        // 텍스트 내용
        String hello = """
            first source
            second source
            third source
            WOow~~~~~
            is it really works?? 
            """;
        
        // CSV 형식 문서 생성 및 출력
        String csvTest = hayoung.makeStr("CSV TEST~~~~ ", hello);
        System.out.println(csvTest);
        
        // HTMLBuilder를 이용하여 Director 인스턴스 생성
        Director hyoung = new Director(html);
        
        // HTML 형식 문서 생성 및 출력
        System.out.println(hyoung.makeStr("HTMLtest", hello));
    }
}
