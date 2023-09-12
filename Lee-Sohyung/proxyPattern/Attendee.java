package proxyPattern;

/**
 * 각 참가자에 대한 정보를 저장하는 클래스
 * 참가자 정보를 저장하고 프로필 클릭 횟수를 추적한다.
 *
 * @author Lee Sohyeong
 */
public class Attendee {

    private final int attendeeId;   // 참가자의 고유 식별자
    private int profileViews; // 프로필 클릭 횟수

    /**
     * Attendee 클래스의 생성자
     *
     * @param attendeeId 참가자의 고유 식별자
     */
    public Attendee(int attendeeId) {
        this(attendeeId, 0);
    }

    /**
     * Attendee 클래스의 생성자
     *
     * @param attendeeId 참가자의 고유 식별자
     * @param profileViews 프로필 클릭 횟수 (임의로 시뮬레이션하기 위함)
     */
    public Attendee(int attendeeId, int profileViews) {
        this.attendeeId = attendeeId;
        this.profileViews = profileViews;
    }

    /**
     * 참가자의 고유 식별자를 반환한다.
     *
     * @return 참가자의 고유 식별자
     */
    public int getAttendeeId() {
        return attendeeId;
    }

    /**
     * 프로필 클릭 횟수를 반환한다.
     *
     * @return 프로필 클릭 횟수
     */
    public int getProfileViews() {
        return profileViews;
    }

    /**
     * 프로필 클릭 횟수를 증가시킨다.
     */
    public void incrementProfileViews() {
        profileViews++;
    }

}
