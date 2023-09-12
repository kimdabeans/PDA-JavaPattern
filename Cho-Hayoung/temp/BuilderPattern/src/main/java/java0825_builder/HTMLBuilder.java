package java0825_builder;

/**
 * HTMLBuilder 클래스는 Builder 추상 클래스의 구체적인 구현체로서, HTML 형식의 텍스트를 생성하는 데 사용됩니다. 
 * 이 클래스는 HTML 문서의 제목과 항목 목록을 작성하는 메서드를 제공합니다.
 */
public class HTMLBuilder extends Builder {

    // HTML 내용을 저장하는 StringBuilder
    private StringBuilder sb = new StringBuilder();

    /**
     * HTML 문서의 제목을 설정합니다.
     *
     * @param title HTML 문서에 표시될 제목입니다.
     */
    @Override
    void strTitle(String title) {
        sb.append("==================");
        sb.append("<h1>").append(title).append("</h1>");
        sb.append("==================<br>");
    }

    /**
     * HTML 문서에 항목 목록을 추가합니다.
     *
     * @param str 개행 문자로 구분된 항목 목록을 포함한 문자열입니다.
     */
    @Override
    void strAdd(String str) {
        String[] contents = str.split("\n");
        sb.append("<ul>");
        for (int i = 0; i < contents.length; i++) {
            sb.append("<li>").append(contents[i]).append("</li><br>");
        }
        sb.append("</ul><br>");
    }

    /**
     * HTML 문서를 닫습니다.
     */
    @Override
    void strClose() {
        sb.append("===============end");
    }

    /**
     * 형식화된 HTML 내용을 문자열로 반환합니다.
     *
     * @return HTML 내용을 문자열로 반환합니다.
     */
    @Override
    public String getStringFormat() {
        return sb.toString();
    }
}
