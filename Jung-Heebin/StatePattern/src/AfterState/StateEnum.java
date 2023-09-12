package AfterState;

/**
 * StateEnum 열거형은 각 상태를 나타내며, 해당 상태에 대응하는 State 객체를 가지고 있습니다.
 */
public enum StateEnum {
    DAY_STATE(new DayState()),
    NIGHT_STATE(new NightState()),
    LUNCH_STATE(new LunchState());

    private final State state;

    /**
     * StateEnum 생성자
     *
     * @param state 해당 상태에 대응하는 State 객체
     */
    StateEnum(State state) {
        this.state = state;
    }

    /**
     * 해당 상태에 대응하는 State 객체를 반환합니다.
     *
     * @return State 객체
     */
    public State getState() {
        return state;
    }
}