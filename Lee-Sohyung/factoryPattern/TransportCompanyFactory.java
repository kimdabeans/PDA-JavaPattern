package factoryPattern;

/**
 * 운송회사 모듈을 생성/반환하는 팩토리 클래스
 *
 * @author Lee Sohyeong
 */
public class TransportCompanyFactory {

    /**
     * 팩토리 메소드
     * transportDetails 를 보고 어떤 운송회사 모듈을 생성/반환해야 할지 결정한다.
     *
     * @param transportDetails 픽업에 필요한 정보
     * @return 운송회사 인스턴스
     */
    public TransportCompany create(TransportDetails transportDetails) {

        switch (transportDetails.getCompanyName()) {
            case "RediCab":
                return new RediCabTransportCompany();
            case "kakaoT":
                return new KakaoTransportCompany();
            default:
                System.out.println("Invalid transport company");
                return null;
        }
    }

}
