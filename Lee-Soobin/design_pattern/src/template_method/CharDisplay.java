package template_method;

/**
 * CharDisplay 클래스는 AbstractDisplay의 구현을 제공합니다.
 *
 * @author Template_Method
 * @version 1.0
 */
public class CharDisplay extends AbstractDisplay {
    private char ch;

    /**
     * CharDisplay의 생성자입니다.
     *
     * @param var1 출력할 문자
     */
    public CharDisplay(char var1) {
        this.ch = var1;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}