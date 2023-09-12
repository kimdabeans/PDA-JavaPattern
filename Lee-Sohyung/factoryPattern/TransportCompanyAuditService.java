package factoryPattern;

/**
 * 픽업 서비스 예약 내역을 로깅하는 집계 서비스 클래스
 *
 * @author Lee Sohyeong
 */
public class TransportCompanyAuditService {

    /**
     * 컨퍼런스 주최사 대시보드에서 확인할 수 있도록 예약 내역을 로깅한다.
     *
     * @param confirmation 예약 확인 번호
     * @param transportDetails 픽업에 필요한 정보
     */
    public void logReservation(String confirmation, TransportDetails transportDetails) {
        System.out.println("Reservation logged - Confirmation: " + confirmation +
                ", Passenger: " + transportDetails.getPassengerName());
    }
}
