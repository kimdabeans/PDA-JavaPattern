package factoryPattern;

/**
 * 동작 테스트용 클래스
 *
 * @author Lee Sohyeong
 */
public class Client {

    /**
     * Strategy 패턴 테스트를 실행한다.
     *
     * @param args 커맨드 라인 인수 (사용하지 않음)
     */
    public static void main(String[] args) {

        // 의존성 인스턴스를 생성한다.
        TransportCompanyAuditService auditService = new TransportCompanyAuditService();
        TransportCompanyFactory companyFactory = new TransportCompanyFactory();

        TransportScheduler scheduler = new TransportScheduler(auditService, companyFactory);

        TransportDetails details = new TransportDetails("RediCab", "이가형", "7:30 PM");

        String confirmationNumber = scheduler.scheduleTransportation(details);
        System.out.println(confirmationNumber);

        details = new TransportDetails("kakaoT", "이나형", "7:30 PM");

        confirmationNumber = scheduler.scheduleTransportation(details);
        System.out.println(confirmationNumber);
    }
}
