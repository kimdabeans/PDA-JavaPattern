package strategyPattern;

import java.util.Map;

/**
 * 픽업 서비스 모듈을 나타내는 추상 클래스 (Strategy)
 * 이 추상 클래스는 픽업 서비스 모듈의 동작을 정의하는 역할을 합니다.
 * 모든 운수회사 모듈이 이 인터페이스를 구현하여 자체적인 픽업 서비스를 제공한다.
 *
 * @author Lee Sohyeong
 */
public abstract class TransportCompany {

    /**
     * 픽업 서비스를 예약하고 예약 확인 번호를 반환한다. (TemplateMethod)
     *
     * @param transportDetails 픽업에 필요한 정보를 담은 TransportDetails 객체
     * @return 예약 확인 번호
     */
    public final String schedulePickup(TransportDetails transportDetails) {
        return callTApi(makeParams(transportDetails));
    }

    /**
     * 픽업 정보를 생성하여 반환한다.
     *
     * @param transportDetails 픽업에 필요한 정보
     * @return 픽업 정보를 담고 있는 Map
     */
    abstract Map<String, String> makeParams(TransportDetails transportDetails);

    /**
     * 카카오 T API 또는 RediCab API 와 같은 픽업 서비스 업체의 웹 서비스를 호출하고,
     * 픽업 정보를 전송한다.
     *
     * @param pickupDetails 픽업 정보를 담은 Map 객체
     * @return API 호출 결과 또는 예약 확인 번호
     */
    abstract String callTApi(Map<String, String> pickupDetails);
}
