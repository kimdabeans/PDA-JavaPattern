/**
 * Client 클래스는 호텔 객실 예약 및 상태 전이를 테스트하는 예제 프로그램입니다.
 * 이 클래스를 실행하여 HotelRoom과 관련된 다양한 작업을 시뮬레이션할 수 있습니다.
 */
public class Client {
    /**
     * Client 클래스의 메인 메서드입니다.
     *
     * @param args 명령줄 인수 (사용되지 않음).
     */
    public static void main(String[] args) {
        // HotelRoom 객체 생성 및 초기 상태 설정
        HotelRoom room = new HotelRoom();
        room.changeState(new AvailableRoomState(room));

        // 객실 체크인 및 체크아웃 테스트
        room.checkIn(); // Available : 객실 예약이 필요합니다.
        room.checkOut(); // Available : 아직 체크인이 완료되지 않았습니다.

        // 객실 예약 테스트 (두 번 예약 시도)
        room.reserveRoom(); // Available -> Reserved: 객실 예약 완료
        room.reserveRoom(); // Reserved : 이미 예약된 객실입니다.

        // 객실 체크인 및 예약 취소 테스트
        room.checkIn(); // Reserved -> OccupiedRoomState : 체크인 완료
        room.cancelReservation(); // OccupiedRoomState : 이미 체크인 되었습니다. 취소할 수 없습니다.

        // 객실 체크아웃 및 현재 상태 출력
        room.checkOut(); // OccupiedRoomState  -> Available : 체크아웃 완료.
        System.out.println("현재 상태: " + room.getState()); // Available: 현재상태: AvailableRoomState
    }
}
