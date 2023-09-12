package Bridge;

/**
 * Display 클래스는 DisplayImpl을 가져와서 표시 기능을 제공합니다.
 */
public class Display {
    private DisplayImpl impl;

    /**
     * 주어진 DisplayImpl 추상클래스를 사용하여 Display 객체를 생성합니다.
     * @param impl DisplayImpl 추상 클래스
     */
    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    /**
     * DisplayImpl을 사용하여 문자열 출력 시작을 표시합니다.
     * 
     * @see StringDisplayImpl#rawOpen()
     */
    public void open() {
        impl.rawOpen();
    }

    /**
     * DisplayImpl을 사용하여 문자열을 출력합니다.
     * 
     * @see StringDisplayImpl#rawPrint()
     */
    public void print() {
        impl.rawPrint();
    }

    /**
     * DisplayImpl을 사용하여 표시를 닫습니다.
     * 
     * @see StringDisplayImpl#rawClose()
     */
    public void close() {
        impl.rawClose();
    }

    /**
     * 문자열 출력을 시작하고, 출력하고, 마무리 과정을 순서대로 수행합니다.
     * 
     * <p>문자열 출력을 시작하고 마무리하는 과정은 모두 <strong>구분선을 긋는 동작</strong>이다.</p>
     * 
     * @see StringDisplayImpl
     */
    public final void display() {
        open();
        print();
        close();
    }
}
