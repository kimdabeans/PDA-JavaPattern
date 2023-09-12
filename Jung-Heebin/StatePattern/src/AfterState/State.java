package AfterState;

/**
 * State 인터페이스는 시간대에 따른 동작을 정의합니다.
 * <p>
 *     시간대에 따라 금고 사용, 비상벨, 일반 통화 등의 동작이 정의됩니다.
 * </p>
 */
public interface State {
    /**
     * 금고 사용 동작을 수행합니다.
     *
     * @param context Context 인터페이스를 구현한 객체
     */
    void doUse(Context context);

    /**
     * 비상벨 동작을 수행합니다.
     *
     * @param context Context 인터페이스를 구현한 객체
     */
    void doAlarm(Context context);

    /**
     * 일반 통화 동작을 수행합니다.
     *
     * @param context Context 인터페이스를 구현한 객체
     */
    void doPhone(Context context);
}