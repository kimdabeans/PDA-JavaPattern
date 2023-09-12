package strategyPattern;

/**
 * 픽업에 필요한 정보를 저장하는 클래스
 * 운송 서비스 예약에 필요한 정보를 캡슐화하고 저장하는 데 사용된다.
 *
 * @author Lee Sohyeong
 */
public class TransportDetails {

    // 운수회사명
    private String companyName;
    // 승객명
    private String passengerName;
    // 출발 시각
    private String departureTime;

    /**
     * TransportDetails 생성자
     *
     * @param companyName 운수회사명
     * @param passengerName 승객명
     * @param departureTime 출발 시각
     */
    public TransportDetails(String companyName, String passengerName, String departureTime) {
        this.companyName = companyName;
        this.passengerName = passengerName;
        this.departureTime = departureTime;
    }

    /**
     * 승객명을 반환한다.
     *
     * @return 승객명
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * 출발 시각을 반환한다.
     *
     * @return 출발 시각
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * 운수회사명을 반환한다.
     *
     * @return 운수회사명
     */
    public String getCompanyName() {
        return companyName;
    }
}
