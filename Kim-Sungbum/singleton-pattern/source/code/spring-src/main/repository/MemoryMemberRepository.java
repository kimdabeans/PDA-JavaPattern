
import com.example.practice.domain.Member;

import java.util.*;

/**
 * MemoryMemberRepository class
 * 이 클래스는 회원 정보를 메모리에 저장하고 조회하는 리포지토리 구현체입니다.
 *
 * @author kim sungbum
 */
public class MemoryMemberRepository implements MemberRepository {
    /**
     * 회원 정보를 메모리에 저장하기 위한 맵입니다.
     * Key로 회원의 고유 식별자(ID)를 사용하고, Value로 회원 객체(Member)를 저장합니다.
     */
    private static Map<Long, Member> store = new HashMap<>();

    /**
     * 회원 정보를 메모리에 저장합니다.
     *
     * @param member 저장할 회원 정보를 담은 Member 객체
     */
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    /**
     * 주어진 회원 식별자(ID)에 해당하는 회원 정보를 조회합니다.
     *
     * @param memberId 조회할 회원의 고유 식별자(ID)
     * @return 회원 정보를 담은 Member 객체 (해당 ID에 해당하는 회원이 없으면 null 반환)
     */
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
