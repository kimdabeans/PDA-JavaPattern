package Bridge;

/**
 * DisplayImpl 클래스는 Display의 구현을 제공합니다.
 */
public abstract class DisplayImpl {

    /**
     * 문자열 출력을 시작하는 추상 메서드입니다.
     */
    public abstract void rawOpen();

    /**
     * 문자열을 출력하는 추상 메서드입니다.
     */
    public abstract void rawPrint();

    /**
     * 문자열 출력을 마무리하는 추상 메서드입니다.
     */
    public abstract void rawClose();
}
