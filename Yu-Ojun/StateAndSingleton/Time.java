package StateAndSingleton;
/**
 * Time 인터페이스입니다.
 * 개장 시간과 마감 시간에 따라 구현하고자 하는 메서드를 정의합니다.
 *
 * @see Context
 */
public interface Time {
    /**
     * 개장 시간, 마감 시간에 따라 알림 메시지를 보내는 동작을 수행하는 메서드입니다.
     *
     * @param context 거래 상태에 관련된 컨텍스트 객체
     */
    public abstract void doAlarm(Context context);
    /**
     * 시간 유형을 반환하는 메서드입니다.
     *
     * @return 시간 유형 (오픈 타임 또는 클로즈 타임)
     */
    public abstract TimeType getTimeType();
}
