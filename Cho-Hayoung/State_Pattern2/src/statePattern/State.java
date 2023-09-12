package statePattern;

/**
 * State 인터페이스는 상태 패턴(State Pattern)에서 각 상태 클래스가 구현해야 하는 메서드를 정의합니다.
 * 각 상태에서는 시계 시간, 금고 사용, 비상벨, 일반 통화에 대한 처리 메서드를 구현해야 합니다.
 *
 * @author Cho hayoung
 */
public interface State {
    /**
     * 현재 시간과 해당 시간에 대한 처리를 수행하는 메서드입니다.
     *
     * @param context   컨텍스트 객체
     * @param newState  새로운 상태 객체
     */
    void doClock(Context context, State newState);

    /**
     * 금고 사용에 대한 처리를 수행하는 메서드입니다.
     *
     * @param context   컨텍스트 객체
     */
    void doUse(Context context);

    /**
     * 비상벨 동작에 대한 처리를 수행하는 메서드입니다.
     *
     * @param context   컨텍스트 객체
     */
    void doAlarm(Context context);

    /**
     * 일반 통화 기록에 대한 처리를 수행하는 메서드입니다.
     *
     * @param context   컨텍스트 객체
     */
    void recordPhone(Context context);
}
