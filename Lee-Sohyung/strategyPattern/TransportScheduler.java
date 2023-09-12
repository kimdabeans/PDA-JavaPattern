package strategyPattern;

/**
 * 픽업 서비스를 스케줄링하는 클래스 (Context)
 *
 * @author Lee Sohyeong
 */
public class TransportScheduler {

    // 집계 서비스
    private TransportCompanyAuditService auditService;

    /**
     * TransportScheduler 생성자
     *
     * @param auditService 집계 서비스 객체
     */
    public TransportScheduler(TransportCompanyAuditService auditService) {
        this.auditService = auditService;
    }

    /**
     * 픽업 서비스를 예약한다.
     *
     * @param transportDetails 픽업에 필요한 정보
     * @return 예약 확인 번호
     */
    public String scheduleTransportation(TransportDetails transportDetails) {
        TransportCompany company;

        // 입력된 운수회사명에 따라 적절한 운수회사 객체를 생성한다.
        switch (transportDetails.getCompanyName()) {
            case "RediCab":
                company = new RediCabTransportCompany();
                break;
            case "kakaoT":
                company = new KakaoTransportCompany();
                break;
            default:
                System.out.println("Invalid transport company");
                return null;
        }

        // 운수회사 객체를 통해 픽업 서비스를 예약하고, 예약 내역을 집계 서비스에 로깅한다.
        String confirmation = company.schedulePickup(transportDetails);
        auditService.logReservation(confirmation, transportDetails);
        return confirmation;
    }

}
