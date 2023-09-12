package factoryPattern;

/**
 * 픽업 서비스를 스케줄링하는 클래스 (Context)
 *
 * @author Lee Sohyeong
 */
public class TransportScheduler {

    // 집계 서비스
    private TransportCompanyAuditService auditService;
    // 회사 팩토리
    private TransportCompanyFactory transportCompanyFactory;

    /**
     * TransportScheduler 생성자
     *
     * @param auditService 집계 서비스 객체
     * @param transportCompanyFactory 회사 팩토리 객체
     */
    public TransportScheduler(TransportCompanyAuditService auditService, TransportCompanyFactory transportCompanyFactory) {
        this.auditService = auditService;
        this.transportCompanyFactory = transportCompanyFactory;
    }

    /**
     * 픽업 서비스를 예약한다.
     *
     * @param transportDetails 픽업에 필요한 정보
     * @return 예약 확인 번호
     */
    public String scheduleTransportation(TransportDetails transportDetails) {
        if (transportDetails == null) {
            throw new IllegalArgumentException("Transport details instance is required.");
        }

        // 1) 운송회사 모듈을 생성
        TransportCompany company = transportCompanyFactory.create(transportDetails);

        // 2) 해당 모듈을 사용하여 픽업을 예약
        String confirmation = company.schedulePickup(transportDetails);

        // 3) 예약이 완료되면 예약 내역을 로깅
        auditService.logReservation(confirmation, transportDetails);

        // 4) 확인 코드를 반환
        return confirmation;
    }

}
