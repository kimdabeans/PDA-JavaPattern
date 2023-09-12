package statePattern;

/**
 * DayState 클래스는 상태 패턴(State Pattern)에서 주간 상태를 나타내는 클래스입니다.
 * 주간 상태에서는 금고 사용, 비상벨, 일반 통화에 대한 처리를 정의합니다.
 * 
 * DayState 클래스는 다음과 같은 동작을 수행합니다:
 * - doClock(Context context, State newState): 시간대에 따라 상태 변경을 처리합니다.
 * - doUse(Context context): 주간 시간에 금고 사용을 처리합니다.
 * - doAlarm(Context context): 주간 시간에 발생한 알람을 처리합니다.
 * - recordPhone(Context context): 주간 시간에 발생한 전화 기록을 처리합니다.
 * 
 * 또한, 이 클래스는 DayState의 인스턴스를 반환하는 정적 메서드 getInstance()를 제공합니다.
 * 
 * @author Cho hayoung
 */
public class DayState implements State {
    private static DayState instance = new DayState();

    /**
     * DayState의 인스턴스를 반환합니다. (싱글톤 패턴)
     *
     * @return DayState의 인스턴스
     */
    public static State getInstance() {
        return instance;
    }

    @Override
    public void doClock(Context context, State newState) {
        // 시간대에 따라 상태 변경
        if (!newState.equals(this)) {
            context.changeState(newState);
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("금고 사용 [주간]");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("ALARM [주간]");
    }

    @Override
    public void recordPhone(Context context) {
        context.recordLog("주간 통화 기록");
    }

    /**
     * 객체를 문자열로 반환
     *
     * @return "[주간]"
     */
    public String toString() {
        return "[주간]";
    }
}
