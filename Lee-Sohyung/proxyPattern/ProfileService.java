package proxyPattern;

/**
 * 참가자 프로필 정보를 가져오는 추상 메서드만 정의한 인터페이스 (Subject)
 *
 * @author Lee Sohyeong
 */
public interface ProfileService {

    /**
     * 주어진 attendeeId에 해당하는 참가자의 프로필 정보를 가져온다.
     *
     * @param attendeeId 참가자의 고유한 식별자
     * @return 참가자의 프로필 정보를 나타내는 문자열
     */
    String getProfile(int attendeeId);
}
