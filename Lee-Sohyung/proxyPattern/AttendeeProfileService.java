package proxyPattern;

import java.util.*;

/**
 * 참가자 프로필을 가져오는 서비스 클래스 (RealSubject)
 * 실제 데이터베이스 대신 이 클래스를 사용하여 실제 프로필 데이터를 관리하고, 프로필을 가져온다.
 *
 * @author Lee Sohyeong
 */
public class AttendeeProfileService implements ProfileService {

    private final Map<Integer, Attendee> attendees = new HashMap<>();
    private final Map<Integer, String> profiles = new HashMap<>();

    /**
     * AttendeeProfileService 클래스의 생성자
     * 초기 데이터를 설정한다.
     */
    public AttendeeProfileService() {
        // 실제 데이터베이스 대신 간단한 데이터로 초기화
        attendees.put(10, new Attendee(10, 3));
        profiles.put(10, "Profile for Attendee " + 10);
        attendees.put(11, new Attendee(11, 0));
        profiles.put(11, "Profile for Attendee " + 11);
        attendees.put(12, new Attendee(12));
        profiles.put(12, "Profile for Attendee " + 12);
        attendees.put(13, new Attendee(13, 3));
        profiles.put(13, "Profile for Attendee " + 13);
        attendees.put(14, new Attendee(14, 10));
        profiles.put(14, "Profile for Attendee " + 14);
        attendees.put(15, new Attendee(15, 2));
        profiles.put(15, "Profile for Attendee " + 15);
        attendees.put(16, new Attendee(16, 1));
        profiles.put(16, "Profile for Attendee " + 16);
    }

    /**
     * 참가자 프로필을 반환한다.
     *
     * @param attendeeId 참가자의 고유 식별자
     * @return 참가자 프로필 문자열
     */
    @Override
    public String getProfile(int attendeeId) {
        System.out.println("Loading profile for " + attendeeId);
        return profiles.get(attendeeId);
    }

    /**
     * 참가자의 프로필 클릭 횟수를 증가시킨다.
     *
     * @param attendeeId 참가자의 고유 식별자
     */
    public void incrementProfileViews(int attendeeId) {
        Attendee attendee = attendees.get(attendeeId);
        if (attendee != null) {
            attendee.incrementProfileViews();
        }
    }

    /**
     * 프로필 클릭 횟수에 따라 참가자 목록을 정렬하여 반환한다.
     *
     * @param limit 최대 반환할 참가자 수
     * @return 참가자 식별자 목록
     */
    public List<Integer> getAttendeesSortedByViews(int limit) {
        List<Integer> sortedAttendees = new ArrayList<>(attendees.keySet());
        Collections.sort(sortedAttendees, (a, b) -> attendees.get(b).getProfileViews() - attendees.get(a).getProfileViews());
        return sortedAttendees.subList(0, Math.min(limit, sortedAttendees.size()));
    }

}
