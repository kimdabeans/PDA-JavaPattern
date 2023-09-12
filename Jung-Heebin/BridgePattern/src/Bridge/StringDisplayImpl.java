package Bridge;

/**
 * StringDisplayImpl 클래스는 DisplayImpl을 상속받아 문자열을 이용한 표시 기능을 제공합니다.
 */
public class StringDisplayImpl extends DisplayImpl {
    private String string;
    private int width;

    /**
     * 주어진 문자열을 이용하여 StringDisplayImpl 객체를 생성합니다.
     * @param string 출력할 문자열
     */
    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.length();
    }

    /**
     * 문자열 출력을 시작합니다.
     * 
     * <p>화면에 구분선을 생성합니다.</p>
     * 
     * @see StringDisplayImpl#printLine()
     */
    @Override
    public void rawOpen() {
        printLine();
    }

    /**
     * 문자열을 화면에 출력합니다.
     */
    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    /**
     * 문자열 출력을 마무리합니다.
     *  
     *  <p>화면에 구분선을 생성합니다.</p>
     *  
     *  @see StringDisplayImpl#printLine()
     */
    @Override
    public void rawClose() {
        printLine();
    }

    /**
     * 화면을 그리는 구분선을 출력합니다.
     * 
     * <p>rawOpen(), rawClose() 메소드에 적용 됩니다.</p>
     */
    private void printLine() {
        System.out.print("+");
        for(int i=0; i<width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}