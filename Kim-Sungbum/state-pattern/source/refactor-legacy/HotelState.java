
/**
 * HotelState 열거형은 호텔 객실의 상태를 정의합니다.
 * 각 열거 상수는 객실의 가능한 상태를 나타냅니다.
 */
public enum HotelState {
    /**
     * 객실이 예약되어 있는 상태를 나타냅니다.
     */
    RESERVED,

    /**
     * 객실이 점유되어 있는 상태를 나타냅니다.
     */
    OCCUPIED,

    /**
     * 객실이 사용 가능한 상태를 나타냅니다.
     */
    AVAILABLE
}
