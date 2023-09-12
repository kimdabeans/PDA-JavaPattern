package statePattern;

/**
 * Hours 열거형은 시간대(Time of Day)와 각 시간대에 해당하는 상태(State)를 매핑하는 역할을 합니다.
 * 시간대별로 해당하는 상태 객체(State)를 반환하는 추상 메서드 getState()를 정의하고 있습니다.
 * 
 * 이 열거형은 다음과 같은 시간대와 상태를 매핑합니다:
 * - LUNCH_STATE: 점심 시간(Lunch Time)을 나타내며, LunchState 상태와 매핑됩니다.
 * - DAY_STATE: 주간 시간(Day Time)을 나타내며, DayState 상태와 매핑됩니다.
 * - NIGHT_STATE: 밤 시간(Night Time)을 나타내며, NightState 상태와 매핑됩니다.
 * 
 * @author Cho hayoung
 */
public enum Hours {
    /**
     * 점심 시간(Lunch Time)을 나타내며, LunchState 상태와 매핑됩니다.
     */
    LUNCH_STATE {
        @Override
        public State getState() {
            return LunchState.getInstance();
        }
    },

    /**
     * 주간 시간(Day Time)을 나타내며, DayState 상태와 매핑됩니다.
     */
    DAY_STATE {
        @Override
        public State getState() {
            return DayState.getInstance();
        }
    },

    /**
     * 밤 시간(Night Time)을 나타내며, NightState 상태와 매핑됩니다.
     */
    NIGHT_STATE {
        @Override
        public State getState() {
            return NightState.getInstance();
        }
    };

    /**
     * 상태(State)를 반환하는 추상 메서드입니다.
     *
     * @return State 상태 객체
     */
    public abstract State getState();
}
