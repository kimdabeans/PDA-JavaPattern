package java0825_builder2;

/**
 * CSVBuilder 클래스는 Builder 추상 클래스의 구체적인 구현체로서, CSV 형식의 텍스트를 생성하는 데 사용됩니다.
 * 이 클래스는 CSV 파일의 제목과 항목 목록을 작성하는 메서드를 제공합니다.
 * @author Cho Hayoung 
 */
public class textBuilder extends Builder {

    // CSV 내용을 저장하는 StringBuilder
    private StringBuilder sb = new StringBuilder();

    /**
     * CSV 파일의 제목을 설정합니다.
     *
     * @param title CSV 파일에 표시될 제목입니다.
     */
    @Override
	public void strTitle(String title) {
        sb.append("=======================");
        sb.append(title);
        sb.append("=======================\n");
    }

    /**
     * CSV 파일에 항목 목록을 추가합니다.
     *
     * @param str 개행 문자로 구분된 항목 목록을 포함한 문자열입니다.
     */
    @Override
    public void strAdd(String str) {
        String[] contents = str.split("\n");
        for (int i = 0; i < contents.length; i++) {
            sb.append(" - ");
            sb.append(contents[i]);
            sb.append("\n");
        }
    }

    /**
     * CSV 파일을 닫습니다.
     *
     */
    @Override
    public void strClose() {
        sb.append("======================================================");
    }

    /**
     * 형식화된 CSV 내용을 문자열로 반환합니다.
     *
     * @return CSV 내용을 문자열로 반환합니다.
     */
    @Override
    public String getStringFormat() {
        return sb.toString();
    }

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
		
	}
}