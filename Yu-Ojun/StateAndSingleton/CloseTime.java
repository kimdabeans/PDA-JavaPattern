package StateAndSingleton;
/**
 * CloseTime 클래스입니다. Time 인터페이스를 구현했으며,
 * 구체적인 시간 상태를 나타내며, 주식 거래가 마감되었을 때의 시간 상태를 나타냅니다.
 */
public class CloseTime implements Time{
    /** 싱글톤 인스턴스 */
    private static CloseTime singleton = new CloseTime();
    /**
     * CloseTime 클래스의 생성자입니다.
     * (singleton 패턴 사용을 위한 private로 선언)
     */
    private CloseTime(){

    }
    /**
     * CloseTime의 싱글톤 인스턴스를 반환합니다.
     *
     * @return CloseTime 싱글톤 인스턴스
     */
    public static Time getInstance(){
        return singleton;
    }
    /**
     * 현재 시간 상태에서 알람을 실행하고, 주식 거래 시간이 아님을 알립니다.
     *
     * @param context 알람을 호출하는 Context 객체
     */
    @Override
    public void doAlarm(Context context) {
        context.callTransactionAlarm("현재는 주식 거래 시간이 아닙니다!\n");
    }
    /**
     * 현재 시간 상태를 나타내는 TimeType을 반환합니다.
     *
     * @return 현재 시간 상태를 나타내는 TimeType 열거형 값 (CLOSE_TIME)
     */
    @Override
    public TimeType getTimeType() {
        return TimeType.CLOSE_TIME;
    }
}
