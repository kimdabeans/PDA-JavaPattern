package strategyPattern;

/**
 * 동작 테스트용 클래스
 * 이 클래스는 Strategy 패턴의 동작을 테스트하는 목적으로 사용된다.
 *
 * @author Lee Sohyeong
 */
public class Client {

    /**
     * Strategy 패턴 테스트를 실행한다.
     * TransportScheduler 를 통해 여러 운송회사에 예약을 요청하고 예약 확인 번호를 출력한다.
     *
     * @param args 커맨드 라인 인수 (사용하지 않음)
     */
    public static void main(String[] args) {

        // 의존성 인스턴스를 생성한다.
        TransportCompanyAuditService auditService = new TransportCompanyAuditService();

        // TransportScheduler 인스턴스를 생성한다.
        TransportScheduler scheduler = new TransportScheduler(auditService);

        // 첫 번째 운송 상세 정보를 생성한다.
        TransportDetails details = new TransportDetails("RediCab", "이가형", "7:30 PM");

        // 첫 번째 예약을 수행하고 예약 확인 번호를 출력한다.
        String confirmationNumber = scheduler.scheduleTransportation(details);
        System.out.println(confirmationNumber);

        // 두 번째 운송 상세 정보를 생성한다.
        details = new TransportDetails("kakaoT", "이나형", "5:30 PM");

        // 두 번째 예약을 수행하고 예약 확인 번호를 출력한다.
        confirmationNumber = scheduler.scheduleTransportation(details);
        System.out.println(confirmationNumber);
    }
}
