package StateAndSingleton;
/**
 * OpenTime 클래스입니다. Time 인터페이스를 구현했으며,
 * 구체적인 시간 상태를 나타내며, 주식 거래가 시작되었을 때의 시간 상태를 나타냅니다.
 */
public class OpenTime implements Time{
    /** 싱글톤 인스턴스 */
    private static OpenTime singleton = new OpenTime();
    /**
     * OpenTime 클래스의 생성자입니다.
     * (singleton 패턴 사용을 위한 private로 선언)
     */
    private OpenTime(){

    }
    /**
     * OpenTime의 싱글톤 인스턴스를 반환합니다.
     *
     * @return OpenTime 싱글톤 인스턴스
     */
    public static Time getInstance(){
        return singleton;
    }
    /**
     * 현재 시간 상태에서 알람을 실행하고, 주식 거래임을 알립니다.
     *
     * @param context 알람을 호출하는 Context 객체
     */
    @Override
    public void doAlarm(Context context) {
        context.callTransactionAlarm("현재는 주식 거래 시간입니다.\n");
    }
    /**
     * 현재 시간 상태를 나타내는 TimeType을 반환합니다.
     *
     * @return 현재 시간 상태를 나타내는 TimeType 열거형 값 (OPEN_TIME)
     */
    @Override
    public TimeType getTimeType() {
        return TimeType.OPEN_TIME;
    }
}
