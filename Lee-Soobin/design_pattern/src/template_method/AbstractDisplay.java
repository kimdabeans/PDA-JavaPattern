package template_method;
/**
 * AbstractDisplay 역할의 추상 클래스.
 * 일부 메서드를 구현하고 있지만, 실제 구현 내용은 하위 클래스에 위임합니다.
 *
 * @author Template_Method
 * @version 1.0
 */
public abstract class AbstractDisplay {

    public AbstractDisplay() {}

    /**
     * 서브클래스에서 구현할 open 메서드.
     */
    public abstract void open();

    /**
     * 서브클래스에서 구현할 print 메서드.
     */
    public abstract void print();

    /**
     * 서브클래스에서 구현할 close 메서드.
     */
    public abstract void close();

    /**
     * 5번의 print를 실행하는 display 메서드.
     * 이 메서드는 오버라이드될 수 없습니다.
     */
    public final void display() {
        open();
        for (int i = 0; i < 5; ++i) {
            print();
        }
        close();
    }
}
