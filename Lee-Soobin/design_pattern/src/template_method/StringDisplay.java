package template_method;

/**
 * StringDisplay 클래스는 AbstractDisplay의 구현을 제공합니다.
 *
 * @author Template_Method
 * @version 1.0
 */
public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    /**
     * StringDisplay의 생성자입니다.
     *
     * @param var1 출력할 문자열
     */
    public StringDisplay(String var1) {
        this.string = var1;
        this.width = var1.getBytes().length;
    }

    @Override
    public void open() {
        this.printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + this.string + "|");
    }

    @Override
    public void close() {
        this.printLine();
    }

    /**
     * 구분선을 출력하는 메서드.
     */
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < this.width; ++i) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}