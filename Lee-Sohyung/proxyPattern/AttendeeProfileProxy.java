package proxyPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 실체와의 연동을 관장하는 프록시 클래스 (Proxy)
 * 프로필 클릭 횟수에 따라 프로필을 선취하여 성능을 최적화한다.
 *
 * @author Lee Sohyeong
 */
public class AttendeeProfileProxy implements ProfileService {

    // realSubject
    private final AttendeeProfileService profileService = new AttendeeProfileService();
    private final int prefetchLimit;
    private final Map<Integer, String> prefetched = new HashMap<>();

    /**
     * AttendeeProfileProxy 클래스의 생성자
     *
     * @param prefetchLimit 선취할 프로필 수의 제한 값
     */
    public AttendeeProfileProxy(int prefetchLimit) {
        if (prefetchLimit < 0) prefetchLimit = 0;
        this.prefetchLimit = prefetchLimit;

        prefetchAll();
    }

    /**
     * 프로필을 선취한다.
     *
     * @param attendeeId 참가자의 고유 식별자
     */
    private void prefetch(int attendeeId) {
        String profile = profileService.getProfile(attendeeId);
        if (profile != null) {
            prefetched.put(attendeeId, profile);
        }
    }

    /**
     * 프로필 클릭 횟수에 따라 가장 인기 있는 프로필을 미리 가져온다.
     */
    private void prefetchAll() {
        System.out.println("=== prefetch start ===");
        List<Integer> popularAttendees = profileService.getAttendeesSortedByViews(prefetchLimit);
        for (int attendeeId : popularAttendees) {
            prefetch(attendeeId);
        }
        System.out.println("=== prefetch end ===");
    }

    /**
     * 주어진 참가자의 프로필을 반환한다.
     * 프로필 조회 시 클릭 횟수를 증가시킨다.
     *
     * @param attendeeId 참가자의 고유 식별자
     * @return 참가자의 프로필 정보
     */
    @Override
    public String getProfile(int attendeeId) {
        // 프로필 클릭 횟수 증가
        profileService.incrementProfileViews(attendeeId);
        String profile = prefetched.get(attendeeId);
        return profile != null ? profile : profileService.getProfile(attendeeId);
    }

}
