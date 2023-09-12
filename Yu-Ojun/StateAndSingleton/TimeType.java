package StateAndSingleton;
/**
 * TimeType enum입니다.
 * 시간 유형을 정의합니다.
 */
public enum TimeType {
    /**
     * 개장 시간을 나타내는 시간 유형입니다.
     */
    OPEN_TIME{
        /**
         * 개장 시간에 해당하는 시간 객체를 반환합니다.
         *
         * @return 개장 시간을 처리하는 Time 인터페이스 구현체
         */
        public Time getTime(){
            return OpenTime.getInstance();
        }
    },
    /**
     * 마감 시간에 나타내는 시간 유형입니다.
     */
    CLOSE_TIME{
        /**
         * 마감 시간에 해당하는 시간 객체를 반환합니다.
         *
         * @return 마감 시간을 처리하는 Time 인터페이스 구현체
         */
        public Time getTime(){
            return CloseTime.getInstance();
        }
    };
    /**
     * 해당 시간 유형에 대한 시간 객체를 반환하는 추상 메서드입니다.
     *
     * @return 시간 객체 ()
     */
    abstract Time getTime();
}
