
/**
 * ReservedRoomState 클래스는 호텔 객실의 예약된 상태를 나타냅니다.
 * 이 클래스는 HotelRoomState 인터페이스를 구현하여 객실의 상태 전이를 처리합니다.
 *
 * @see HotelRoomState
 */
public class ReservedRoomState implements HotelRoomState {
    private HotelRoom hotelRoom;

    /**
     * ReservedRoomState 클래스의 생성자입니다.
     *
     * @param hotelRoom 해당 객실을 나타내는 HotelRoom 객체입니다.
     */
    public ReservedRoomState(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    /**
     * 객실을 예약하려고 할 때 호출되는 메서드입니다.
     * 이미 예약된 객실임을 알립니다.
     */
    @Override
    public void reserveRoom() {
        System.out.println("이미 예약된 객실입니다.");
    }

    /**
     * 예약된 객실에서 체크인할 때 호출되는 메서드입니다.
     * 체크인을 완료하고 객실 상태를 변경합니다.
     */
    @Override
    public void checkIn() {
        System.out.println("체크인 완료");
        hotelRoom.changeState(new OccupiedRoomState(hotelRoom));
    }

    /**
     * 예약된 객실에서 체크아웃하려고 할 때 호출되는 메서드입니다.
     * 아직 체크인이 완료되지 않았음을 알립니다.
     */
    @Override
    public void checkOut() {
        System.out.println("아직 체크인이 완료되지 않았습니다.");
    }

    /**
     * 예약된 객실의 예약을 취소하려고 할 때 호출되는 메서드입니다.
     * 객실 예약을 취소하고 객실 상태를 변경합니다.
     */
    @Override
    public void cancelReservation() {
        System.out.println("객실 예약 취소");
        hotelRoom.changeState(new AvailableRoomState(hotelRoom));
    }
}
