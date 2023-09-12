package strategyPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * RediCab 픽업 서비스를 구체적으로 나타내는 클래스 (ConcreteStrategy1)
 * 이 클래스는 TransportCompany 인터페이스를 구현하여 RediCab 픽업 서비스의 동작을 정의한다.
 *
 * @author Lee Sohyeong
 */
public class RediCabTransportCompany extends TransportCompany{

    // 픽업 정보를 전송할 URL
    private String schedulePickupUrl = "http://redicab.com/schedulepickup";

    @Override
    Map<String, String> makeParams(TransportDetails transportDetails) {

        Map<String, String> details = new HashMap<>();
        details.put("passenger", transportDetails.getPassengerName());
        details.put("pickUp", "컨퍼런스 센터");
        details.put("pickUpTime", transportDetails.getDepartureTime());
        details.put("dropOff", "공항");
        details.put("rateCode", "Conference");

        return details;
    }

    /**
     * RediCab API 를 호출하여 픽업 예약을 처리하고 예약 확인 번호를 반환한다.
     *
     * @param pickupDetails 픽업에 필요한 정보
     * @return 예약 확인 번호
     */
    @Override
    String callTApi(Map<String, String> pickupDetails) {
        // 실제로는 RediCab API 를 호출하여 예약을 처리하고 확인 번호를 받아올 것입니다.
        // 여기에서는 예시로 "ABC-123-XYZ"을 반환합니다.
        return "ABC-123-XYZ";
    }
}
