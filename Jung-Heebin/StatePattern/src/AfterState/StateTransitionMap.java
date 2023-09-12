package AfterState;

import java.util.*;

/**
 * StateTransitionMap 클래스는 시간대별 상태 전환을 관리하는 클래스입니다.
 */
public class StateTransitionMap {
    private Map<HourRange, StateEnum> transitionMap = new HashMap<>();

    /**
     * StateTransitionMap 클래스의 생성자입니다. 초기 상태 전환 규칙을 설정합니다.
     */
    public StateTransitionMap() {
        // Day State
        transitionMap.put(new HourRange(9, 11), StateEnum.DAY_STATE);
        transitionMap.put(new HourRange(15, 17), StateEnum.DAY_STATE);

        // Lunch State
        transitionMap.put(new HourRange(12, 14), StateEnum.LUNCH_STATE);

        // Night State
        transitionMap.put(new HourRange(18, 8), StateEnum.NIGHT_STATE);
    }

    /**
     * 주어진 시간에 해당하는 상태를 반환합니다.
     *
     * @param hour 시간 (0~23)
     * @return 해당 시간에 대응하는 StateEnum 값, 없을 경우 null 반환
     */
    public StateEnum getStateForHour(int hour) {
        for (Map.Entry<HourRange, StateEnum> entry : transitionMap.entrySet()) {
            if (entry.getKey().containsHour(hour)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * 시간 범위를 나타내는 내부 클래스입니다.
     */
    private static class HourRange {
        private int startHour;
        private int endHour;

        /**
         * HourRange 클래스의 생성자입니다.
         *
         * @param startHour 시작 시간 (0~23)
         * @param endHour   종료 시간 (0~23)
         */
        public HourRange(int startHour, int endHour) {
            this.startHour = startHour;
            this.endHour = endHour;
        }

        /**
         * 주어진 시간이 범위에 속하는지 여부를 반환합니다.
         *
         * @param hour 시간 (0~23)
         * @return 속하는 경우 true, 아닌 경우 false
         */
        public boolean containsHour(int hour) {
            if (startHour <= endHour) {
                return hour >= startHour && hour <= endHour;
            } else {
                return hour >= startHour || hour <= endHour;
            }
        }
    }
}
