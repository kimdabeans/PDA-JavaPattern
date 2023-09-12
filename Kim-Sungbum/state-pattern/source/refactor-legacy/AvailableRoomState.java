/**
 * AvailableRoomState 클래스는 호텔 객실의 사용 가능한 상태를 나타냅니다.
 * 이 클래스는 HotelRoomState 인터페이스를 구현하여 객실의 상태 전이를 처리합니다.
 *
 * @see HotelRoomState
 */
public class AvailableRoomState implements HotelRoomState {
    private final HotelRoom room;

    /**
     * AvailableRoomState 클래스의 생성자입니다.
     *
     * @param hotelRoom 해당 객실을 나타내는 HotelRoom 객체입니다.
     */
    public AvailableRoomState(HotelRoom hotelRoom) {
        this.room = hotelRoom;
    }

    /**
     * 객실을 예약하려고 할 때 호출되는 메서드입니다.
     * 객실을 예약하고 객실 상태를 변경합니다.
     */
    @Override
    public void reserveRoom() {
        System.out.println("객실 예약 완료");
        room.changeState(new ReservedRoomState(room));
    }

    /**
     * 사용 가능한 객실에서 체크인을 시도할 때 호출되는 메서드입니다.
     * 먼저 객실을 예약해야만 체크인이 가능함을 알립니다.
     */
    @Override
    public void checkIn() {
        System.out.println("객실 예약이 필요합니다.");
    }

    /**
     * 사용 가능한 객실에서 체크아웃하려고 할 때 호출되는 메서드입니다.
     * 아직 체크인이 완료되지 않았음을 알립니다.
     */
    @Override
    public void checkOut() {
        System.out.println("아직 체크인이 완료되지 않았습니다.");
    }

    /**
     * 예약된 객실을 취소하려고 할 때 호출되는 메서드입니다.
     * 예약된 객실이 없음을 알립니다.
     */
    @Override
    public void cancelReservation() {
        System.out.println("예약된 객실이 없습니다.");
    }
}
