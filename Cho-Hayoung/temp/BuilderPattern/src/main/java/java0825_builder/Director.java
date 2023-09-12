package java0825_builder;

/**
 * Director 클래스는 Builder 패턴을 사용하여 텍스트 형식의 문서를 생성하는 역할을 수행합니다.
 * 이 클래스는 특정 Builder 인스턴스를 받아서 해당 빌더를 사용하여 문서를 생성합니다.
 */
public class Director {

    Builder btype;

    /**
     * Director 클래스의 생성자입니다. 특정 Builder 인스턴스를 받아서 초기화합니다.
     *
     * @param btype Builder 인스턴스
     */
    Director(Builder btype) {
        this.btype = btype;
    }

    /**
     * 제목과 내용을 사용하여 텍스트 문서를 생성하고 해당 문서를 문자열 형태로 반환합니다.
     *
     * @param title    문서의 제목
     * @param contents 문서의 내용
     * @return 생성된 텍스트 문서를 문자열 형태로 반환합니다.
     */
    public String makeStr(String title, String contents) {
        this.btype.strTitle(title);
        this.btype.strAdd(contents);
        this.btype.strClose();
        return btype.getStringFormat();
    }
}
