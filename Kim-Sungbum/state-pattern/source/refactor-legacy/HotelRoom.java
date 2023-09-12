
/**
 * HotelRoom 클래스는 호텔 객실의 상태를 관리하고 객실 상태 전이를 처리하는 클래스입니다.
 * 객실 상태는 HotelRoomState 객체를 통해 관리됩니다.
 */
public class HotelRoom {
    private HotelRoomState state;

    /**
     * HotelRoom의 상태를 변경하는 메서드입니다.
     *
     * @param state 새로운 객실 상태를 나타내는 HotelRoomState 객체입니다.
     */
    void changeState(HotelRoomState state) {
        this.state = state;
    }

    /**
     * 객실을 예약하는 메서드입니다.
     * 현재 상태에 따라 예약이 가능하거나 불가능합니다.
     */
    public void reserveRoom() {
        state.reserveRoom();
    }

    /**
     * 객실에 체크인하는 메서드입니다.
     * 현재 상태에 따라 체크인이 가능하거나 불가능합니다.
     */
    public void checkIn() {
        state.checkIn();
    }

    /**
     * 객실에서 체크아웃하는 메서드입니다.
     * 현재 상태에 따라 체크아웃이 가능하거나 불가능합니다.
     */
    public void checkOut() {
        state.checkOut();
    }

    /**
     * 객실 예약을 취소하는 메서드입니다.
     * 현재 상태에 따라 예약 취소가 가능하거나 불가능합니다.
     */
    public void cancelReservation() {
        state.cancelReservation();
    }

    /**
     * 현재 객실의 상태를 문자열 형태로 반환하는 메서드입니다.
     *
     * @return 현재 객실의 상태를 나타내는 문자열입니다.
     */
    public String getState() {
        return state.getClass().getSimpleName();
    }
}
