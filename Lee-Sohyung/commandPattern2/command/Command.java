package commandPattern2.command;

/**
 * 명령을 표현하는 인터페이스 (Command; Component)
 * 명령을 실행하고 되돌릴 수 있다.
 *
 * @author Lee Sohyeong
 */
public interface Command {

    /**
     * 명령을 실행하는 추상 메서드
     */
    void call();

    /**
     * 명령을 취소하는 추상 메서드
     */
    void undo();

    /**
     * 명령 성공 여부를 반환하는 추상 메서드
     *
     * @return 성공한 명령이면 true, 실패한 명령이면 false
     */
    boolean isSucceeded();
}
