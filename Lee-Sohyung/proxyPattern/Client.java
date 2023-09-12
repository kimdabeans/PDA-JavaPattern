package proxyPattern;

/**
 * 동작 테스트용 클래스
 * 선취 프록시 테스트를 실행한다.
 *
 * @author Lee Sohyeong
 */
public class Client {

    /**
     * 프록시 패턴을 활용하여 참가자 프로필을 조회하는 예제를 실행한다.
     *
     * @param args
     */
    public static void main(String[] args) {

        ProfileService proxy = new AttendeeProfileProxy(3); // 선취할 프로필 수 지정

        // 프로필 조회
        for (int i = 10; i <= 16; i++) {
            String profile = proxy.getProfile(i);
            System.out.println("Attendee " + i + " Profile: " + profile);
        }

    }
}
