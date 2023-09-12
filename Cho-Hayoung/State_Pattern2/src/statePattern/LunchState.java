package statePattern;



/**
 * @author  Cho hayoung
 * LunchState 클래스는 점심 시간(Lunch Time)에 해당하는 상태(State)를 나타내는 구체적인 클래스입니다.
 * 이 클래스는 시간 변화에 따라 상태를 변경하는 메서드와 금고 사용, 비상벨, 통화 기록과 같은 동작을 정의합니다.
 */
public class LunchState implements State {

    private static LunchState me = new LunchState();

    /**
     * LunchState의 인스턴스를 반환합니다.
     *
     * @return LunchState의 인스턴스
     */
    public static State getInstance() {
        return me;
    }

    /**
     * 시간대에 맞는 상태로 변경합니다.
     *
     * @param context 현재 컨텍스트
     * @param map     시간대와 상태를 매핑한 맵
     * @param hour    현재 시간
     */
    @Override
    public void doClock(Context context, State newState) {
        context.changeState(newState);
    }

    /**
     * 금고를 사용할 때 호출되는 메서드로, 시간대에 맞는 금고 상황 print 
     *
     * @param context 현재 컨텍스트
     */
    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상: 점심 시간에 금고를 사용합니다.");
    }

    /**
     * 비상벨을 작동시킬 때 호출되는 메서드로, 해당 시간대의 비상벨 상황 print 
     *
     * @param context 현재 컨텍스트
     */
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("ALRM[ 점심 시간 ]");
    }

    /**
     * 통화를 기록할 때 호출되는 메서드로, 해당 시간대의 통화 기록 print
     *
     * @param context 현재 컨텍스트
     */
    @Override
    public void recordPhone(Context context) {
        context.recordLog("점심 시간에 발생한 통화 기록");
    }

    /**
     * 객체를 문자열 형식으로 바꾸어 return. 
     *
     * @return 현재 상태를 나타내는 문자열
     */
    @Override
    public String toString() {
        return "[LUNCH]";
    }
}
