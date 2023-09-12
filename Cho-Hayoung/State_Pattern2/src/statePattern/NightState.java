package statePattern;

/**
 * NightState 클래스는 상태 패턴(State Pattern)에서 구체적인 상태(State)를 나타내는 클래스입니다.
 * 이 클래스는 야간(Night) 상태를 나타내며, 시간대(hour)에 따라 다양한 동작을 수행합니다.
 *
 * @author Cho hayoung
 */
public class NightState implements State {
    private static NightState instance = new NightState();

    /**
     * NightState의 인스턴스를 반환합니다.
     *
     * @return NightState의 인스턴스
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
        context.callSecurityCenter("비상: 야간 시간 금고 사용");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("알람 [야간]");
    }

    @Override
    public void recordPhone(Context context) {
        context.recordLog("야간 전화 기록");
    }

    /**
     * 상태를 문자열로 반환. 
     *
     * @return 상태를 나타내는 문자열 "[야간]"
     */
    public String toString() {
        return "[야간]";
    }
}
