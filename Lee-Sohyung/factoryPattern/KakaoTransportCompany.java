package factoryPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 카카오 T 픽업 서비스를 구체적으로 나타내는 클래스 (ConcreteStrategy2)
 *
 * @author Lee Sohyeong
 */
public class KakaoTransportCompany extends TransportCompany {

    private String schedulePickupUrl = "http://kakaot.com/schedulepickup";

    @Override
    Map<String, String> makeParams(TransportDetails transportDetails) {

        // 카카오 T 서비스에 전달할 픽업 정보를 설정한다.
        Map<String, String> details = new HashMap<>();
        details.put("승객", transportDetails.getPassengerName());
        details.put("출발", "컨퍼런스 센터");
        details.put("출발 시간", transportDetails.getDepartureTime());
        details.put("도착", "공항");
        details.put("호출 옵션", "Conference");

        return details;
    }

    /**
     * 카카오 T API 를 호출하여 픽업 예약을 처리하고 예약 확인 번호를 반환한다.
     *
     * @param pickupDetails 픽업에 필요한 정보
     * @return 예약 확인 번호
     */
    @Override
    String callTApi(Map<String, String> pickupDetails) {
        // 실제로는 카카오 T API 를 호출하여 예약을 처리하고 확인 번호를 받아올 것입니다.
        // 여기에서는 예시로 "1234567890"을 반환합니다.
        return "1234567890";
    }
}
