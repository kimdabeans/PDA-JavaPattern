
/**
 * HotelSystem은 호텔 객실 상태를 관리하는 클래스입니다.
 * 이 클래스를 사용하여 객실 예약, 체크인, 체크아웃 및 예약 취소를 수행할 수 있습니다.
 */
public class HotelSystem {
    private HotelState hotelState;

    /**
     * HotelSystem의 생성자입니다. 기본 상태는 AVAILABLE로 설정됩니다.
     */
    public HotelSystem() {
        this.hotelState = HotelState.AVAILABLE;
    }

    /**
     * 객실을 예약하는 메서드입니다.
     * 현재 상태에 따라 예약이 가능하거나 불가능합니다.
     */
    public void reserveRoom() {
        if (this.hotelState == HotelState.AVAILABLE) {
            System.out.println("객실 예약 완료");
            this.hotelState = HotelState.RESERVED;
        } else if (this.hotelState == HotelState.RESERVED) {
            System.out.println("이미 예약된 객실입니다.");
        } else if (this.hotelState == HotelState.OCCUPIED) {
            System.out.println("이미 체크인 되었습니다.");
        } else {
            System.out.println("잘못된 예약 상태입니다.");
        }
    }

    /**
     * 객실에 체크인하는 메서드입니다.
     * 예약된 상태에서만 체크인이 가능합니다.
     */
    public void checkIn() {
        if (this.hotelState == HotelState.RESERVED) {
            System.out.println("체크인 완료");
            this.hotelState = HotelState.OCCUPIED;
        } else if (this.hotelState == HotelState.AVAILABLE) {
            System.out.println("객실 예약이 필요합니다.");
        } else if (this.hotelState == HotelState.OCCUPIED) {
            System.out.println("이미 체크인 되었습니다.");
        } else {
            System.out.println("잘못된 예약 상태입니다.");
        }
    }

    /**
     * 객실에서 체크아웃하는 메서드입니다.
     * 체크인된 상태에서만 체크아웃이 가능합니다.
     */
    public void checkOut() {
        if (this.hotelState == HotelState.OCCUPIED) {
            System.out.println("체크아웃 완료");
            this.hotelState = HotelState.AVAILABLE;
        } else if (this.hotelState == HotelState.AVAILABLE) {
            System.out.println("아직 체크인이 완료되지 않았습니다.");
        } else if (this.hotelState == HotelState.RESERVED) {
            System.out.println("아직 체크인이 완료되지 않았습니다.");
        } else {
            System.out.println("잘못된 예약 상태입니다.");
        }
    }

    /**
     * 객실 예약을 취소하는 메서드입니다.
     * 예약된 상태에서만 예약 취소가 가능합니다.
     */
    public void cancelReservation() {
        if (this.hotelState == HotelState.RESERVED) {
            System.out.println("객실 예약 취소");
            this.hotelState = HotelState.AVAILABLE;
        } else if (this.hotelState == HotelState.AVAILABLE) {
            System.out.println("예약된 객실이 없습니다.");
        } else if (this.hotelState == HotelState.OCCUPIED) {
            System.out.println("이미 체크인 되었습니다. 취소할 수 없습니다.");
        } else {
            System.out.println("잘못된 예약 상태입니다.");
        }
    }
}
